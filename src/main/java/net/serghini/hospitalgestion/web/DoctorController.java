package net.serghini.hospitalgestion.web;

import net.serghini.hospitalgestion.entities.Doctor;
import net.serghini.hospitalgestion.entities.Patient;
import net.serghini.hospitalgestion.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @GetMapping ("/doctors")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page ,
                        @RequestParam(name = "size",defaultValue = "5") int size ,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){

        Page<Doctor> doctors = doctorRepository.findByNomContainsIgnoreCase(keyword , PageRequest.of(page,size));
        model.addAttribute("ListDoctors",doctors.getContent());
        model.addAttribute("page",new int[doctors.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);




        return "doctors";
    }


    @GetMapping("/deleteDoctor")
    public String delete(@RequestParam(name = "id") Long id){
        doctorRepository .deleteById(id);
        return "redirect:/doctors";

    }


}
