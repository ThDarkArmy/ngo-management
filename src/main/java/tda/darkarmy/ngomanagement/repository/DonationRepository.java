package tda.darkarmy.ngomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ngomanagement.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>
{

}
