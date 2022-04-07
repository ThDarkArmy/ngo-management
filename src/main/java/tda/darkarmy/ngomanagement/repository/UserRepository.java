package tda.darkarmy.ngomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ngomanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String username);
}
