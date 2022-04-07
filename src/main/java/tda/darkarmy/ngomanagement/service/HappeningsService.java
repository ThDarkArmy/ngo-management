package tda.darkarmy.ngomanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tda.darkarmy.ngomanagement.model.Happenings;
import tda.darkarmy.ngomanagement.repository.HappeningsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class HappeningsService {
	private HappeningsRepository happeningsRepository;

	public Happenings oraganiseHappenings(Happenings happenings){
		return happeningsRepository.save(happenings);
	}

	public List<Happenings> getAllHappenings(){
		return happeningsRepository.findAll();
	}

	public Optional<Happenings> getById(Long id){
		return happeningsRepository.findById(id);
	}
}
