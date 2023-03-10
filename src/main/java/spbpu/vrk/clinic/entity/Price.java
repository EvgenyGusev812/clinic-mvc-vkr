package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price extends BaseEntity{

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "ENDED")
    private boolean ended;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_care_id", referencedColumnName = "id")
    private MedicalCare medicalCare;
}
