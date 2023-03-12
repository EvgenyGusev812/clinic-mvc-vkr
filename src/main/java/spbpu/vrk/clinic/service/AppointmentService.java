package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.vrk.clinic.entity.Appointment;
import spbpu.vrk.clinic.entity.Bio;
import spbpu.vrk.clinic.repository.AppointmentRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAllByDoctor(Long doctor) {
        return appointmentRepository.findAllByDoctor_Id(doctor)
                .stream()
                .sorted((o1, o2) -> o1.getDate().before(o2.getDate()) ? 1 : 0)
                .collect(Collectors.toList());
    }

    public List<Appointment> findAllByKeyword(String keyword) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> result = new ArrayList<>();
        appointments.forEach(e -> {
            Bio bio = e.getPatient().getBio();
            if (bio.getName().toLowerCase().contains(keyword)
                    || bio.getSurname().toLowerCase().contains(keyword)
                    || bio.getMiddlename().toLowerCase().contains(keyword)) {
                result.add(e);
                return;
            }
            if (e.getMedicalCare().getLabel().toLowerCase().contains(keyword)) {
                result.add(e);
                return;
            }
            if (e.getDate() != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = formatter.format(e.getDate());
                if (dateStr.contains(keyword)) {
                    result.add(e);
                }
            }
        });
        return result;
    }
}
