package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.repository.BioRepository;

@Service
public class BioService {

    private final BioRepository bioRepository;

    @Autowired
    public BioService(BioRepository bioRepository) {
        this.bioRepository = bioRepository;
    }
}
