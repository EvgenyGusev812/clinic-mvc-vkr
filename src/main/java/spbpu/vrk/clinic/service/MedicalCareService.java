package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.TextEntity;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.repository.MedicalCareRepository;
import spbpu.vrk.clinic.repository.TextEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCareService {

    @Autowired
    private MedicalCareRepository medicalCareRepository;

    @Autowired
    private TypeOfMedicalCareService typeOfMedicalCareService;

    @Autowired
    private TextEntityRepository textEntityRepository;


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

    public MedicalCare saveMedicalCare(MedicalCare medicalCare, TextEntity textEntities) {
        textEntityRepository.save(textEntities);
        return medicalCareRepository.save(medicalCare);
    }

    public void deleteMedicalCare(MedicalCare medicalCare) {
        medicalCareRepository.delete(medicalCare);
    }
}
