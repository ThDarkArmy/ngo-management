package tda.darkarmy.ngomanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tda.darkarmy.ngomanagement.config.TokenProvider;
import tda.darkarmy.ngomanagement.dto.LoginRequest;
import tda.darkarmy.ngomanagement.dto.LoginResponse;
import tda.darkarmy.ngomanagement.dto.PasswordResetRequest;
import tda.darkarmy.ngomanagement.dto.RegisterRequest;
import tda.darkarmy.ngomanagement.model.Role;
import tda.darkarmy.ngomanagement.model.Roles;
import tda.darkarmy.ngomanagement.model.User;
import tda.darkarmy.ngomanagement.repository.RolesRepository;
import tda.darkarmy.ngomanagement.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {
	private UserRepository userRepository;
	private RolesRepository rolesRepository;
	private PasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;
	private TokenProvider tokenProvider;

	public User createUser(RegisterRequest registerRequest) throws Exception
	{
		User user1 = userRepository.findByEmail(registerRequest.getEmail());

		if(user1 != null){
			throw new Exception("User already exists with given email.");
		}

		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setUserName(registerRequest.getUserName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

		Roles roles = rolesRepository.findByRoleName(Role.valueOf(registerRequest.getRoles().toUpperCase()));
		user.getRoles().add(roles);
		user.setIsActive(true);
		return userRepository.save(user);
	}

	public LoginResponse loginUser(LoginRequest loginRequest){
		User user = userRepository.findByEmail(loginRequest.getEmail());

		if(user == null){
			throw new UsernameNotFoundException("No user found with given email.");
		}

		Set<Roles> role = user.getRoles();
		List<Roles> roleList = new ArrayList<>(user.getRoles());
		System.out.println(roleList.get(0).getRoleName());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = tokenProvider.generateToken(authentication);

		return  new LoginResponse(authentication.getName(), token, user.getUserName(), true, roleList.get(0).getRoleName().name());
	}

	public Optional<User> getUser(Long userId){
		getLoggedInUser();
		return userRepository.findById(userId);
	}

	public User getLoggedInUser(){
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByEmail(userDetails.getUsername());
	}

	public User updateUser(User user){
		User user1 = getLoggedInUser();
		user1.setUserName(user.getUserName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());

		return userRepository.save(user1);
	}

	public User updatePassword(PasswordResetRequest resetRequest){
		User user = userRepository.findByEmail(resetRequest.getEmail());
		System.out.println("Email: Reste"+ resetRequest.getEmail());
		if(user == null){
			throw new UsernameNotFoundException("No user found with given email.");
		}

		user.setPassword(passwordEncoder.encode(resetRequest.getPassword()));

		return userRepository.save(user);
	}

	public String deleteUser(){
		User user = getLoggedInUser();
		userRepository.deleteById(user.getUserId());
		return "User deleted successfully.";
	}
}
