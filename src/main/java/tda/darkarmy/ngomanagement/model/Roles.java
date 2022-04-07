package tda.darkarmy.ngomanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roles
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLES_ID")
	private Long rolesId;
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE_NAME")
	private Role roleName;

	public Roles(Role user)
	{
		this.roleName = user;
	}
}
