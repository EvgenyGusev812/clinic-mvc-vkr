package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spbpu.vrk.clinic.entity.Appointment;
import spbpu.vrk.clinic.service.AppointmentService;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/previous")
    public String getMyAppointmentsPrev(Model model) {
        List<Appointment> appointmentList = appointmentService.findAllByDoctor(1L);
        model.addAttribute("appointments", appointmentList);
        return "doctor-previous-orders";
    }

    @GetMapping("/future")
    public String getMyAppointmentsFut(Model model) {
        List<Appointment> appointmentList = appointmentService.findAllByDoctor(1L);
        model.addAttribute("appointments", appointmentList);
        return "doctor-future-orders";
    }

    @GetMapping("/current")
    public String getMyAppointmentsCur(Model model) {
        List<Appointment> appointmentList = appointmentService.findAllByDoctor(1L);
        model.addAttribute("appointments", appointmentList);
        return "doctor-current-orders";
    }

    @GetMapping("/find-by-keyword")
    public String getAppointmentsByKeyWord(Model model, String keyword) {
        List<Appointment> appointments = appointmentService.findAllByKeyword(keyword);
        model.addAttribute("appointments", appointments);
        return "doctor-previous-orders";
    }
}
