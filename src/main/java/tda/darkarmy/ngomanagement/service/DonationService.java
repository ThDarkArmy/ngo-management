package tda.darkarmy.ngomanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tda.darkarmy.ngomanagement.model.Donation;
import tda.darkarmy.ngomanagement.model.Role;
import tda.darkarmy.ngomanagement.model.User;
import tda.darkarmy.ngomanagement.repository.DonationRepository;
import tda.darkarmy.ngomanagement.repository.RolesRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DonationService{
	private DonationRepository donationRepository;
	private AuthService authService;
	private RolesRepository rolesRepository;



	public Donation donate(Donation donation){
		User user = authService.getLoggedInUser();
//		user.getRoles().add(rolesRepository.findByRoleName(Role.DONOR));
		donation.setUser(user);
		return donationRepository.save(donation);
	}

	public Donation donateClothes(Donation donation){
		User user = authService.getLoggedInUser();
//		user.getRoles().add(rolesRepository.findByRoleName(Role.DONOR));
		donation.setUser(user);
		donation.setDonationType("CLOTHES");
		return donationRepository.save(donation);
	}

	public Donation donateMoney(Donation donation){
		User user = authService.getLoggedInUser();
//		user.getRoles().add(rolesRepository.findByRoleName(Role.DONOR));
		donation.setUser(user);
		donation.setDonationType("MONEY");
		return donationRepository.save(donation);
	}
}
