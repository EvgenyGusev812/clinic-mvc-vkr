package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.Bio;

@Repository
public interface BioRepository extends JpaRepository<Bio, Long> {
}
