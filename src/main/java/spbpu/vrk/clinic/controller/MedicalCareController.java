package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.service.MedicalCareService;
import spbpu.vrk.clinic.service.TypeOfMedicalCareService;

import java.util.List;

@Controller
@RequestMapping("/medical-care")
public class MedicalCareController {

    @Autowired
    private MedicalCareService medicalCareService;

    @Autowired
    private TypeOfMedicalCareService typeOfMedicalCareService;

    @GetMapping("/{id}")
    private String getInfoAboutMedicalCare(@PathVariable("id") Long id, Model model) {
        MedicalCare medicalCare = medicalCareService.findById(id);
        List<MedicalCare> medicalCares = medicalCareService.findAllByType(id);
        List<TypeOfMedicalCare> typeOfMedicalCares = typeOfMedicalCareService.findAll();
        model.addAttribute("medicalCare", medicalCare);
        model.addAttribute("medicalCares", medicalCares);
        model.addAttribute("typeOfMedicalCares", typeOfMedicalCares);
        return "medical-care-id";
    }

    @GetMapping("/type/{typeOfMedicalCareId}")
    private String getTypeOfMedicalCareById(@PathVariable("typeOfMedicalCareId") Long id, Model model) {
        List<MedicalCare> medicalCares = medicalCareService.findAllByType(id);
        List<TypeOfMedicalCare> typeOfMedicalCares = typeOfMedicalCareService.findAll();
        MedicalCare medicalCare = medicalCareService.findById(id);
        model.addAttribute("medicalCare", medicalCare);
        model.addAttribute("typeOfMedicalCares", typeOfMedicalCares);
        model.addAttribute("medicalCares", medicalCares);
        return "medical-care-id";
    }
}
