package com.hospitals.allergy.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Allergy extends RepresentationModel<Allergy> { // класс пищевой аллергии
    private int id;
    private String hospitalName;
    private String allergen;
    private String symptoms;
    private String severity; // степень тяжести - mild moderate severe
    private String areaAllergy;
    private int ageOfDiagnosis;
    private int patientsNumber;
}
