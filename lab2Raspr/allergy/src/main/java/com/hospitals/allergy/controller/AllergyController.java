package com.hospitals.allergy.controller;

import com.hospitals.allergy.model.Allergy;
import com.hospitals.allergy.service.AllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//4 метода, которые реализуют HTTP-запросы POST, GET, PUT, DELETE
@RestController
@RequiredArgsConstructor
@RequestMapping("/allergy")
public class AllergyController {
    @Autowired
    private final AllergyService allergyService;
    @Autowired
    private final MessageSource messages;

    @GetMapping("/{id}")
    public Allergy getAllergy(@PathVariable("id") int id,
                              @RequestHeader(value = "Accept-Language", required = false) Locale locale){
        Allergy allergy = allergyService.findById(id);
        allergy.add(
                linkTo(methodOn(AllergyController.class)
                        .getAllergy(id, locale))
                        .withSelfRel(),
                linkTo(methodOn(AllergyController.class)
                        .createAllergy(allergy, locale))
                        .withRel(String.format(messages.getMessage(
                                "allergy.hateoas.create.message", null, locale))),
                linkTo(methodOn(AllergyController.class)
                        .updateAllergy(id, allergy, locale))
                        .withRel(String.format(messages.getMessage(
                                "allergy.hateoas.update.message", null, locale))),
                linkTo(methodOn(AllergyController.class)
                        .deleteById(id, locale))
                        .withRel(String.format(messages.getMessage(
                                "allergy.hateoas.delete.message", null, locale)))
        );
        return allergy;
    }

    @PostMapping
    public ResponseEntity<String> createAllergy(@RequestBody Allergy allergy,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(allergyService.createAllergy(allergy, locale));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAllergy(@PathVariable("id") int id, @RequestBody Allergy allergy,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(allergyService.updateAllergy(id, allergy, locale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id,
                                             @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(allergyService.deleteById(id, locale));
    }
}