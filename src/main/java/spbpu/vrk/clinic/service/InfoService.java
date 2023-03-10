package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import spbpu.vrk.clinic.entity.Info;
import spbpu.vrk.clinic.repository.InfoRepository;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Info> find() {
        return infoRepository.findAll();
    }

}
