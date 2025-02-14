package com.hospitals.allergy.repository;

import com.hospitals.allergy.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//@Repository
//public interface AllergyRepository extends JpaRepository<Allergy, Integer> {
//}

@Repository
public interface AllergyRepository extends CrudRepository<Allergy, Integer> {
//    public List<Allergy> findByHospitalName (String hospitalName);
//    public Allergy findByHospitalNameAndBoneType(String hospitalName, String boneType);
}