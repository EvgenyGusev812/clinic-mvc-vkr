package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;

@Repository
public interface TypeOfMedicalCareRepository extends JpaRepository<TypeOfMedicalCare, Long> {
}
