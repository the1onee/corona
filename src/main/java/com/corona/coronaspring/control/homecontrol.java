package com.corona.coronaspring.control;

import com.corona.coronaspring.main.coronadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class homecontrol {

    @Autowired
    com.corona.coronaspring.main.coronadata coronadata;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("loc",coronadata.getAlllist());
        return "home";
    }
}
