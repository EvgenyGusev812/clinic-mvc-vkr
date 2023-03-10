package spbpu.vrk.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalAreaController {

    @GetMapping("/personal-area")
    public String personalArea() {
        return "personal-area";
    }
}
