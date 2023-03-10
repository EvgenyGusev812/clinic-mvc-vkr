package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
