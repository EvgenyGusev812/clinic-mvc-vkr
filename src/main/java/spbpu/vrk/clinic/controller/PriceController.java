package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spbpu.vrk.clinic.entity.Price;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.service.PriceService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices")
    public String getAllPrices(Model model, String keyword) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyword);
        model.addAttribute("prices", prices);
        return "prices";
    }

    @GetMapping("/prices/find")
    public String getAllPricesKeyWord(Model model, String keyword) {
        Map<TypeOfMedicalCare, List<Price>> prices = priceService.findAllPricesWithTypeByKeyWord(keyword.toLowerCase());
        model.addAttribute("prices", prices);
        return "prices";
    }
}
