package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.repository.MedicalCareRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCareService {

    @Autowired
    private MedicalCareRepository medicalCareRepository;

    @Autowired
    private TypeOfMedicalCareService typeOfMedicalCareService;


    public List<MedicalCare> findAll() {
        return medicalCareRepository.findAll();
    }

    public MedicalCare findById(Long id) {
        return medicalCareRepository.findById(id).orElse(null);
    }

    public List<MedicalCare> findAllByType(Long typeOfMedicalCareId) {
        TypeOfMedicalCare typeOfMedicalCare = typeOfMedicalCareService.findById(typeOfMedicalCareId);
        return medicalCareRepository.findAllByTypeOfMedicalCare(typeOfMedicalCare);
    }
}
