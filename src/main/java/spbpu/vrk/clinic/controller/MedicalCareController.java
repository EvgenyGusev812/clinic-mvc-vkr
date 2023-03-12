package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.Price;
import spbpu.vrk.clinic.entity.TextEntity;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.service.MedicalCareService;
import spbpu.vrk.clinic.service.PriceService;
import spbpu.vrk.clinic.service.TypeOfMedicalCareService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/medical-care")
public class MedicalCareController {

    @Autowired
    private MedicalCareService medicalCareService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private TypeOfMedicalCareService typeOfMedicalCareService;

    @GetMapping("/{id}")
    private String getInfoAboutMedicalCare(@PathVariable("id") Long id, Model model) {
        MedicalCare medicalCare = medicalCareService.findById(id);
        List<MedicalCare> medicalCares = medicalCareService.findAllByType(id);
        List<TypeOfMedicalCare> typeOfMedicalCares = typeOfMedicalCareService.findAll();
        medicalCares.forEach(e -> e.setTextEntities(null));
        model.addAttribute("medicalCare", medicalCare);
        model.addAttribute("medicalCares", medicalCares);
        model.addAttribute("typeOfMedicalCares", typeOfMedicalCares);
        return "medical-care-id";
    }

    @GetMapping("/type/{typeOfMedicalCareId}")
    private String getTypeOfMedicalCareById(@PathVariable("typeOfMedicalCareId") Long id, Model model) {
        List<MedicalCare> medicalCares = medicalCareService.findAllByType(id);
        medicalCares.forEach(e -> e.setTextEntities(null));
        List<TypeOfMedicalCare> typeOfMedicalCares = typeOfMedicalCareService.findAll();
        MedicalCare medicalCare = medicalCareService.findById(id);
        model.addAttribute("medicalCare", medicalCare);
        model.addAttribute("typeOfMedicalCares", typeOfMedicalCares);
        model.addAttribute("medicalCares", medicalCares);
        return "medical-care-id";
    }

    @GetMapping("/edit/{id}")
    public String editMedCare(@PathVariable("id") Long id, Model model) {
        MedicalCare medicalCare = medicalCareService.findById(id);
        model.addAttribute("textEntities", medicalCare.getTextEntities());
        model.addAttribute("medicalCare", medicalCare);
        return "medical-care-to-edit";
    }

    @PostMapping("/edit/save-medical-care")
    public String saveMedCare(@ModelAttribute("medicalCare") MedicalCare medicalCare,
                              @ModelAttribute("textEntities") TextEntity textEntities,
                              Model model) {
        medicalCare = medicalCareService.saveMedicalCare(medicalCare, textEntities);
        model.addAttribute("medicalCare", medicalCare);
        return "medical-care-to-edit";
    }

    @PostMapping("/edit/delete-medical-care")
    public String deleteMedCare(@ModelAttribute("medicalCare") MedicalCare medicalCare, @ModelAttribute Model model, String keyWord) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyWord);
        model.addAttribute("prices", prices);
        medicalCareService.deleteMedicalCare(medicalCare);
        model.addAttribute("medicalCare", medicalCare);
        return "prices-cared-edit";
    }

}
