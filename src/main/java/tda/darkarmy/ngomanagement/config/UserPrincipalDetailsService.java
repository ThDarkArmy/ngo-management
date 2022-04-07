package tda.darkarmy.ngomanagement.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tda.darkarmy.ngomanagement.model.User;
import tda.darkarmy.ngomanagement.repository.UserRepository;


@AllArgsConstructor
@Slf4j
@Service
public class UserPrincipalDetailsService implements UserDetailsService
{
	private UserRepository userRepository;

//	private UserPrincipal userPrincipal;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByEmail(username);
		return new UserPrincipal(user);
	}
}
