package com.hospitals.allergy.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allergies")
public class Allergy  extends RepresentationModel<Allergy> { // класс пищевой аллергии
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкрементный идентификатор
    private int id;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "allergen")
    private String allergen;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "severity")
    private String severity; // степень тяжести - mild, moderate, severe

    @Column(name = "area_allergy")
    private String areaAllergy;

    @Column(name = "age_of_diagnosis")
    private int ageOfDiagnosis;

    @Column(name = "patients_number")
    private int patientsNumber;

    @Column(name = "comment")
    private String comment;

    public com.hospitals.allergy.model.Allergy withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
