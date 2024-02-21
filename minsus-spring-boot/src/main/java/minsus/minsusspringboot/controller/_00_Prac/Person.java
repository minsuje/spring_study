package minsus.minsusspringboot.controller._00_Prac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Person {

    @GetMapping("/person")
    public String getPerson(Model model){
        List<Persons> person = new ArrayList<>();
        person.add(new Persons(20,"kim"));
        // or => Persons person1 = new Persons("kim",20);
        // person.add(person1);
        Persons person2 = new Persons(30,"Lee");
        person.add(person2);
        Persons person3 = new Persons(19, "Jeong");
        person.add(person3);
        Persons person4 = new Persons(25, "HIM");
        person.add(person4);

        model.addAttribute("person", person);



        return "_01_thymeleaf/person";
    }

}

@Getter
@Setter
@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자
class Persons{
    private int age;
    private String name;
}