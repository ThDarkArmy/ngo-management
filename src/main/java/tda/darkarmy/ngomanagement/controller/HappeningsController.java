package tda.darkarmy.ngomanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.ngomanagement.model.Happenings;
import tda.darkarmy.ngomanagement.service.HappeningsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/happenings")
@AllArgsConstructor
public class HappeningsController {
	private HappeningsService happeningsService;

	@GetMapping("/")
	public ResponseEntity<?> getAllHappenings(){
		return ResponseEntity.status(200).body(happeningsService.getAllHappenings());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getHappeningsById(@PathVariable("id") Long id){
		return ResponseEntity.status(200).body(happeningsService.getById(id));
	}

	@PostMapping("/organize")
	public ResponseEntity<?> organiseHappenings(@RequestBody Happenings happenings){
		return ResponseEntity.status(200).body(happeningsService.oraganiseHappenings(happenings));
	}
}
