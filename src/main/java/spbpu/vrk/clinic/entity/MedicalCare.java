package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEDICALCARE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCare extends BaseEntity {

    @Column(name = "LABEL", nullable = false)
    private String label;

    @OneToOne(mappedBy = "medicalCare")
    private Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_of_medical_care_id", referencedColumnName = "id")
    private TypeOfMedicalCare typeOfMedicalCare;

    @ManyToMany
    @JoinTable(
            name = "doctors_cares",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_care_id")
    )
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "medicalCare")
    private List<TextEntity> textEntities;



}
