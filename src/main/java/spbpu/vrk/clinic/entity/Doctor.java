package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bio_id", referencedColumnName = "id")
    private Bio bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "doctors")
    private Set<Specialization> specialization;

    @ManyToMany(mappedBy = "doctors")
    private List<MedicalCare> medicalCares;

    @Column(name = "INFO", columnDefinition = "TEXT")
    private String info;

    @Column(name = "EDUCATION", columnDefinition = "TEXT")
    private String education;

    @Column(name = "PHOTO")
    private String photo;


}
