package tda.darkarmy.ngomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ngomanagement.model.Role;
import tda.darkarmy.ngomanagement.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{
	Roles findByRoleName(Role role);
}
