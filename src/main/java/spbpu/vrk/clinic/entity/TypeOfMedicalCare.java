package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TYPEOFMEDICALCARE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfMedicalCare extends BaseEntity {

    @Column(name = "label")
    private String label;

    @OneToOne
    private Specialization specialization;

}
