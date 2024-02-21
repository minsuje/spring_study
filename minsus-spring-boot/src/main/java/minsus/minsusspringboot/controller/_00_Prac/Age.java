package minsus.minsusspringboot.controller._00_Prac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 실습
@Controller
public class Age {
    @GetMapping("/age")
    public String getAge(Model model){
        model.addAttribute("age",15);
        return "_01_thymeleaf/age";
    }
}
