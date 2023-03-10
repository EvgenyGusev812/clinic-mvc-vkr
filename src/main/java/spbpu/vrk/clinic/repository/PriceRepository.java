package spbpu.vrk.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spbpu.vrk.clinic.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
