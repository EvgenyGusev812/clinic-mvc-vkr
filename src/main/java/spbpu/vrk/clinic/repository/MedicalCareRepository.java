package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;

import java.util.List;

public interface MedicalCareRepository extends JpaRepository<MedicalCare, Long> {

    List<MedicalCare> findAllByTypeOfMedicalCare(TypeOfMedicalCare typeOfMedicalCare);
}
