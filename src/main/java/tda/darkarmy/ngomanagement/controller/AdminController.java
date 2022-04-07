package tda.darkarmy.ngomanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/admin")
@RestController
@AllArgsConstructor
public class AdminController
{
	@GetMapping("/")
	public String getAdmin(){
		return "Admin";
	}
}
