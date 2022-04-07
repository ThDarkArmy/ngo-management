package tda.darkarmy.ngomanagement;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import tda.darkarmy.ngomanagement.model.Role;
import tda.darkarmy.ngomanagement.model.Roles;
import tda.darkarmy.ngomanagement.repository.RolesRepository;


@SpringBootApplication
@AllArgsConstructor
public class NgomanagementApplication {
	public static void main(String[] args){
		SpringApplication.run(NgomanagementApplication.class, args);
	}


	private RolesRepository rolesRepository;
	@EventListener(ApplicationReadyEvent.class)
	public void initializeRoles() {
		if(rolesRepository.findByRoleName(Role.USER)==null)
			rolesRepository.save(new Roles(Role.USER));
		if(rolesRepository.findByRoleName(Role.ADMIN)==null)
			rolesRepository.save(new Roles(Role.ADMIN));
		if(rolesRepository.findByRoleName(Role.DONOR)==null)
			rolesRepository.save(new Roles(Role.DONOR));
		if(rolesRepository.findByRoleName(Role.VOLUNTEER)==null)
			rolesRepository.save(new Roles(Role.VOLUNTEER));
	}
}
