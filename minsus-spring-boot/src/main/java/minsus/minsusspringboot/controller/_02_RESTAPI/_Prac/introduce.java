//package minsus.minsusspringboot.controller._02_RESTAPI._Prac;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class introduce {
//    @GetMapping("/")
//    public String getReq(){
//        return "_00_practice/introduce_req";
//    }
//    @GetMapping("introduce/{name}")
//    public String introduce1(@PathVariable(value = "name") String name, @PathVariable(value = "age", required = false) Integer age, Model model){
//        model.addAttribute("name", name);
//        return "_00_practice/introduce_res";
//    }
//    @GetMapping("introduce/2")
//    public String introduce2(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, Model model){
//        model.addAttribute("name",name);
//        model.addAttribute("age",age);
//        System.out.println(name);
//        return "_00_practice/introduce_res";
//    }
//    @GetMapping("/form")
//    public String getForm(){
//        return "_00_practice/Form";
//    }
//    @PostMapping("/form/result")
//    public String postForm(@RequestParam String name, @RequestParam String gender, @RequestParam int year, @RequestParam int month, @RequestParam int day, @RequestParam String hobby, Model model){
//        model.addAttribute("name", name);
//        model.addAttribute("gender", gender);
//        model.addAttribute("year", year);
//        model.addAttribute("month", month);
//        model.addAttribute("day",day);
//        model.addAttribute("hobby", hobby);
//        return "_00_practice/FormResult";
//    }
//}
