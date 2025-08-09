package net.serghini.hospitalgestion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavigationController {


    @GetMapping("/gotodoctors")
    public String goToDoctorsPage() {
        return "redirect:/doctors";
    }


    @GetMapping("/gotoindex")
    public String goToIndexPage() {
        return "redirect:/index";
    }


}


