package tda.darkarmy.ngomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ngomanagement.model.Happenings;

public interface HappeningsRepository extends JpaRepository<Happenings, Long>
{
}
