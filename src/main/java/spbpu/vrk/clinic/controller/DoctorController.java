package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbpu.vrk.clinic.entity.Doctor;
import spbpu.vrk.clinic.service.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/edit")
    public String editDoctors(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors-edit";
    }

    @GetMapping("/edit/{id}")
    public String findDoctorById(@PathVariable(name = "id") Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-page";
    }

    @PostMapping("/edit/save-doctor")
    public String editDoctorById(@ModelAttribute("doctor") Doctor doctor) {
        if (doctor != null) {
            doctorService.saveDoctor(doctor);
        }
        return "doctor-page";
    }

    @PostMapping("/add-doctor")
    public String addDoctor(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "doctor-page";
    }

    @PostMapping("/delete-doctor")
    public String deleteDoctor(Model model, @ModelAttribute ("doctor") Doctor doctor) {
        if (doctor != null) {
            doctorService.deleteDoctor(doctor);
        }
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors-edit";
    }


}
