package com.hospitals.allergy.service;

import com.hospitals.allergy.model.Allergy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

//(создание, чтение, модификация, удаление)
@Service
public class AllergyService {
    private final List<Allergy> allergyList = new ArrayList<>();
    private int count = 4;
    {
    allergyList.add(new Allergy(1, "h1", "apple", "symptoms",
            "mild", "eyes", 1, 1));
    allergyList.add(new Allergy(2, "h1", "milk", "symptoms",
            "severe", "nose", 10, 2));
    allergyList.add(new Allergy(3, "h2", "nuts", "symptoms",
            "moderate", "skin", 9, 3));
    allergyList.add(new Allergy(4, "h3", "fish", "symptoms",
            "mild", "skin", 5, 4));
    }
    public Allergy findById(int id) {
        return allergyList.get(id - 1);
    }

//        Allergy allergy = new Allergy();
//        //allergy.setId(new Random().nextInt(1000));
//        allergy.setHospitalName(hospitalName);
//        allergy.setAllergen(allergen);
//        allergy.setSymptoms("diaphyseal");
//        allergy.setSeverity("mild");
//        allergy.setAreaAllergy("eyes");
//        allergy.setAgeOfDiagnosis(2);
//        allergy.setPatientsNumber(patientsNumber);

    public int createAllergy(Allergy allergy) {
        allergy.setId(++count);
        allergyList.add(allergy);
        return allergy.getId();
    }

    public int updateAllergy(int id, Allergy newAllergy) {
        Allergy allergy = allergyList.get(id - 1);
        changeAllergy(allergy, newAllergy);
        return allergy.getId();
    }

    private void changeAllergy(Allergy allergy, Allergy newAllergy) {
        allergy.setHospitalName(newAllergy.getHospitalName());
        allergy.setAllergen(newAllergy.getAllergen());
        allergy.setSymptoms(newAllergy.getSymptoms());
        allergy.setSeverity(newAllergy.getSeverity());
        allergy.setAreaAllergy(newAllergy.getAreaAllergy());
        allergy.setAgeOfDiagnosis(newAllergy.getAgeOfDiagnosis());
        allergy.setPatientsNumber(newAllergy.getPatientsNumber());
    }

    public void deleteById(int id) {
        allergyList.remove(id - 1);
    }

}
