package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.Info;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

}
