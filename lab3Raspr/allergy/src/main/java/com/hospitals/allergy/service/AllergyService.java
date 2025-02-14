package com.hospitals.allergy.service;

import com.hospitals.allergy.config.ServiceConfig;
import com.hospitals.allergy.model.Allergy;

import com.hospitals.allergy.repository.AllergyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

//(создание, чтение, модификация, удаление)
@Service
@RequiredArgsConstructor
public class AllergyService {
    @Autowired
    private final ServiceConfig config;
    @Autowired
    private final MessageSource messages;
    @Autowired
    private final AllergyRepository repository;

    public Allergy findById(int id, Locale locale) {
        System.out.println("Received request to find allergy with ID: " + id);
        var allergy = repository.findById(id);

        if(allergy.isEmpty()){
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("allergy.search.error.message", null, locale))
            );
        }

        return allergy.get().withComment(config.getProperty());
    }

    public Allergy createAllergy(Allergy allergy, Locale locale) {
        System.out.println("Received request to create allergy");
        return repository.save(allergy).withComment(config.getProperty());
    }

    public Allergy updateAllergy(int id, Allergy newAllergy, Locale locale) {
        System.out.println("Received request to update allergy with ID: " + id);
        var allergy = changeAllergy(repository.findById(id).get(), newAllergy);
        return repository.save(allergy).withComment(config.getProperty());
    }

    private Allergy changeAllergy(Allergy allergy, Allergy newAllergy) {
        allergy.setHospitalName(newAllergy.getHospitalName());
        allergy.setAllergen(newAllergy.getAllergen());
        allergy.setSymptoms(newAllergy.getSymptoms());
        allergy.setSeverity(newAllergy.getSeverity());
        allergy.setAreaAllergy(newAllergy.getAreaAllergy());
        allergy.setAgeOfDiagnosis(newAllergy.getAgeOfDiagnosis());
        allergy.setPatientsNumber(newAllergy.getPatientsNumber());

        return allergy;
    }

    public String deleteById(int id, Locale locale) {
        System.out.println("Received request to delete allergy with ID: " + id);
        repository.deleteById(id);
        return String.format(messages.getMessage("allergy.delete.message", null, locale), id);
    }
}
