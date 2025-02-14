package com.hospitals.allergy.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Allergy { // класс пищевой аллергии
    private int id;
    private String hospitalName;
    private String allergen;
    private String symptoms;
    private String severity; // степень тяжести - mild moderate severe
    private String areaAllergy;
    private int ageOfDiagnosis;
    private int patientsNumber;
}
