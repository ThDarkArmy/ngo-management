package tda.darkarmy.ngomanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.ngomanagement.model.Donation;
import tda.darkarmy.ngomanagement.repository.DonationRepository;
import tda.darkarmy.ngomanagement.service.DonationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/donation")
@RestController
@AllArgsConstructor
public class DonationController {

	private DonationService donationService;
	private DonationRepository donationRepository;

	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.status(200).body(donationRepository.findAll());
	}
	@PostMapping("/donate")
	public ResponseEntity<?> donate(@RequestBody Donation donation){
		return ResponseEntity.status(201).body(donationService.donate(donation));
	}

	@PostMapping("/clothes")
	public ResponseEntity<?> donateClothes(@RequestBody Donation donation){
		return ResponseEntity.status(201).body(donationService.donateClothes(donation));
	}

	@PostMapping("/money")
	public ResponseEntity<?> donateMoney(@RequestBody Donation donation){
		return ResponseEntity.status(201).body(donationService.donateMoney(donation));
	}
}
