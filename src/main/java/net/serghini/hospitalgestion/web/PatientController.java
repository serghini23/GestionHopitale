package net.serghini.hospitalgestion.web;

import net.serghini.hospitalgestion.entities.Patient;
import net.serghini.hospitalgestion.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class PatientController {
    @Autowired
    private PatientRepository  patientRepository;
    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("ListPatiants", patients);
        return "/patients";
    }



}
