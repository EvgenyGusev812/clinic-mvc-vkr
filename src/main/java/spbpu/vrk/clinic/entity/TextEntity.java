package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TEXTENTITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TextEntity extends BaseEntity {

    @Column(name = "MAINTAG", columnDefinition = "TEXT")
    private String mainTag;

    @Column(name = "BASICTEXT", columnDefinition = "TEXT")
    private String basicText;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_care_id")
    private MedicalCare medicalCare;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private Info info;
}
