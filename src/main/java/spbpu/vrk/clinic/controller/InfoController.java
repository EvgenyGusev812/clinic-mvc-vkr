package spbpu.vrk.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spbpu.vrk.clinic.entity.TextEntity;
import spbpu.vrk.clinic.service.TextEntityService;

import java.util.List;

@Controller
public class InfoController {

    @Autowired
    private TextEntityService textEntityService;

    @GetMapping("/about")
    private String aboutUsInfo(Model model) {
        List<TextEntity> info = textEntityService.findInfoAboutUs();
        model.addAttribute("infos", info);
        return "about";
    }

}
