package com.hospitals.allergy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospitals.allergy.model.Allergy;
import com.hospitals.allergy.service.*;

//4 метода, которые реализуют HTTP-запросы POST, GET, PUT, DELETE
@RestController
@RequiredArgsConstructor
@RequestMapping("/allergy") // value="hospitals/{hospitalName}/allergy"
public class AllergyController {
    @Autowired
    private final AllergyService allergyService;

    @GetMapping("/{id}")
    public Allergy getAllergy(@PathVariable("id") int id) {
        return allergyService.findById(id);
    }

    @PostMapping
    public int createAllergy(@RequestBody Allergy allergy) {
        return allergyService.createAllergy(allergy);
    }

    @PutMapping("/{id}")
    public int updateAllergy(@PathVariable("id") int id, @RequestBody Allergy allergy) {
        return allergyService.updateAllergy(id, allergy);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        allergyService.deleteById(id);
    }
}