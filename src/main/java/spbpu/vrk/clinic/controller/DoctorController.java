package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbpu.vrk.clinic.entity.Doctor;
import spbpu.vrk.clinic.entity.Specialization;
import spbpu.vrk.clinic.repository.SpecializationRepository;
import spbpu.vrk.clinic.service.DoctorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecializationRepository specializationRepository;


    @GetMapping("/edit")
    public String editDoctors(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors-edit";
    }

    @GetMapping("/edit/{id}")
    public String findDoctorById(@PathVariable(name = "id") Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        List<Specialization> specializations = specializationRepository.findAll();
        Map<Specialization, Boolean> map = new HashMap<>();
        for (Specialization specialization : specializations) {
            if (doctor.getSpecialization().contains(specialization)) {
                map.put(specialization, true);
            }
            map.put(specialization, false);
        }
        model.addAttribute("doctor", doctor);
        model.addAttribute("map", map);
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
