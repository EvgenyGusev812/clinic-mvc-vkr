package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spbpu.vrk.clinic.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
