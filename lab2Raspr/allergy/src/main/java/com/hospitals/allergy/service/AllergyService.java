package com.hospitals.allergy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;

import com.hospitals.allergy.model.Allergy;
//(создание, чтение, модификация, удаление)
@Service
public class AllergyService {
    @Autowired
    private MessageSource messages;
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

    public String createAllergy(Allergy allergy, Locale locale) {
        System.out.println("Received request to create allergy");
        String responseMessage = null;
//        allergy.setId(++count);
//        allergyList.add(allergy);
//        responseMessage = String.format(messages.getMessage("allergy.create.message", null, locale), allergy);
        if(allergy != null) {
            allergy.setId(++count);
            allergyList.add(allergy);
            responseMessage = String.format(messages.getMessage("allergy.create.message", null,locale), allergy.toString());
        }
        return responseMessage;
    }

    public String updateAllergy(int id, Allergy newAllergy, Locale locale) {
        System.out.println("Received request to update allergy with ID: " + id);
        Allergy allergy = allergyList.get(id - 1);
        changeAllergy(allergy, newAllergy);
        return String.format(messages.getMessage("allergy.update.message", null, locale), allergy);
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

    public String deleteById(int id, Locale locale) {
        System.out.println("Received request to delete allergy with ID: " + id);
        allergyList.remove(id - 1);
        return String.format(messages.getMessage("allergy.delete.message", null, locale), id);
    }
}
