package tda.darkarmy.ngomanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.ngomanagement.dto.LoginRequest;
import tda.darkarmy.ngomanagement.dto.PasswordResetRequest;
import tda.darkarmy.ngomanagement.dto.RegisterRequest;
import tda.darkarmy.ngomanagement.model.User;
import tda.darkarmy.ngomanagement.service.AuthService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/auth")
@RestController
@AllArgsConstructor
public class AuthController
{
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) throws Exception
	{
		return ResponseEntity.status(201).body(authService.createUser(registerRequest));
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
		return ResponseEntity.status(200).body(authService.loginUser(loginRequest));
	}

	@GetMapping("/")
	public ResponseEntity<?> getUser(@PathVariable Long userId){
		return ResponseEntity.status(200).body(authService.getLoggedInUser());
	}

	@PutMapping("/reset-password")
	public ResponseEntity<?> updatePassword(@RequestBody PasswordResetRequest resetRequest){
		return ResponseEntity.status(200).body(authService.updatePassword(resetRequest));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(User user){
		return ResponseEntity.status(200).body(authService.deleteUser());
	}

}
