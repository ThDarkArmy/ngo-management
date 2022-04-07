package tda.darkarmy.ngomanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse
{
	private String email;
	private String token;
	private String userName;
	private Boolean success;
	private String role;
}
