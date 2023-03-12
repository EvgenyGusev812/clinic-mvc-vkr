package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment extends BaseEntity {

    @Column(name = "DATE")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patiend_id", referencedColumnName = "id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_care_id", referencedColumnName = "id")
    private MedicalCare medicalCare;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

}
