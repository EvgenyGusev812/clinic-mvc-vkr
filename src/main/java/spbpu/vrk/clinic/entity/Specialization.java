package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SPECIALIZATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Specialization extends BaseEntity{

    @Column(name = "label")
    private String label;

    @ManyToMany
    @JoinTable(
            name = "doctors_specializations",
            joinColumns = @JoinColumn(name = "specialization_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;
}
