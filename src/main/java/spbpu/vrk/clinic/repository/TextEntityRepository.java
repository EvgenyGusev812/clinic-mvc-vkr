package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.TextEntity;

import java.util.List;

@Repository
public interface TextEntityRepository extends JpaRepository<TextEntity, Long> {

    List<TextEntity> findAllByMedicalCareIdIsNull();
}
