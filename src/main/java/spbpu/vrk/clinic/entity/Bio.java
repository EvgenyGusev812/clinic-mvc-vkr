package spbpu.vrk.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bio extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "MIDDLENAME")
    private String middlename;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "OMSPOLICY")
    private String omsPolicy;

    @Column(name = "BIRTHDATE")
    private Date birthdate;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private Boolean sex;

}
