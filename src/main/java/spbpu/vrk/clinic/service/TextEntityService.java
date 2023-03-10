package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.entity.TextEntity;
import spbpu.vrk.clinic.repository.TextEntityRepository;

import java.util.List;

@Service
public class TextEntityService {

    @Autowired
    private TextEntityRepository textEntityRepository;

    public List<TextEntity> findInfoAboutUs() {
        return textEntityRepository.findAllByMedicalCareIdIsNull();
    }
}
