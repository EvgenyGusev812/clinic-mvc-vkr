package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spbpu.vrk.clinic.entity.Doctor;
import spbpu.vrk.clinic.entity.MedicalCare;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.service.DoctorService;
import spbpu.vrk.clinic.service.MedicalCareService;
import spbpu.vrk.clinic.service.TypeOfMedicalCareService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainMenuController {

    @Autowired
    private MedicalCareService medicalCareService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TypeOfMedicalCareService typeOfMedicalCareService;

    @GetMapping("/")
    public String mainMenu() {
        return "main-menu";
    }

    @GetMapping("/medical-cares")
    public String getAllMedicalCares(Model model) {
        List<TypeOfMedicalCare> typeOfMedicalCares = typeOfMedicalCareService.findAll();
        model.addAttribute("typeOfMedicalCares", typeOfMedicalCares);
        List<MedicalCare> medicalCares = medicalCareService.findAll();
        model.addAttribute("medicalCares", medicalCares);
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "medical-cares";
    }

    @GetMapping("/doctors")
    public String getAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



}
