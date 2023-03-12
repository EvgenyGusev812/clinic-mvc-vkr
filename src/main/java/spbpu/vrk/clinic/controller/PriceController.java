package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.Price;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.service.MedicalCareService;
import spbpu.vrk.clinic.service.PriceService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private MedicalCareService medicalCareService;

    @GetMapping("")
    public String getAllPrices(Model model, String keyword) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyword);
        model.addAttribute("prices", prices);
        return "prices";
    }

    @GetMapping("/find")
    public String getAllPricesKeyWord(Model model, String keyword) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyword.toLowerCase());
        model.addAttribute("prices", prices);
        return "prices";
    }

    @GetMapping("/edit")
    public String getAllPricesList(Model model) {
        List<MedicalCare> medicalCares = medicalCareService.findAll();
        model.addAttribute("medicalCares", medicalCares);
        return "prices-cared-edit";
    }

    @GetMapping("/edit-all")
    public String getAllPricesToEdit(Model model, String keyword) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyword);
        model.addAttribute("prices", prices);
        return "prices-cared-edit";
    }
}
