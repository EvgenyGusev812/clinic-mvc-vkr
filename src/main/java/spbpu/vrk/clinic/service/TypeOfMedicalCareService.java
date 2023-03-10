package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.repository.TypeOfMedicalCareRepository;

import java.util.List;

@Service
public class TypeOfMedicalCareService {

    @Autowired
    private TypeOfMedicalCareRepository typeOfMedicalCareRepository;

    public List<TypeOfMedicalCare> findAll() {
        return typeOfMedicalCareRepository.findAll();
    }

    public TypeOfMedicalCare findById(Long id) {
        return typeOfMedicalCareRepository.findById(id).orElse(null);
    }
}
