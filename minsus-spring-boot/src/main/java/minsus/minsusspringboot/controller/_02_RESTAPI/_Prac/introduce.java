package minsus.minsusspringboot.controller._02_RESTAPI._Prac;

import minsus.minsusspringboot.controller._02_RESTAPI._Prac.vo.NewUserDTO;
import minsus.minsusspringboot.controller._02_RESTAPI._Prac.vo.NewUserVO;
import minsus.minsusspringboot.controller._02_RESTAPI._Prac.vo.PracVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class introduce {
    @GetMapping("/")
    public String getReq(){
        return "_00_practice/introduce_req";
    }
    @GetMapping("introduce/{name}")
    public String introduce1(@PathVariable(value = "name") String name, @PathVariable(value = "age", required = false) Integer age, Model model){
        model.addAttribute("name", name);
        return "_00_practice/introduce_res";
    }
    @GetMapping("introduce/2")
    public String introduce2(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        System.out.println(name);
        return "_00_practice/introduce_res";
    }
    @GetMapping("/form")
    public String getForm(){
        return "_00_practice/Form";
    }
    @PostMapping("/form/result")
    public String postForm(@RequestParam String name, @RequestParam String gender, @RequestParam int year, @RequestParam int month, @RequestParam int day, @RequestParam String hobby, Model model){
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day",day);
        model.addAttribute("hobby", hobby);
        return "_00_practice/FormResult";
    }

    @PostMapping("/form")
    @ResponseBody
    public String axiosPrac(@RequestBody PracVO pracVO){
        return pracVO.getName() + "회원가입 성공";
    }
    // 회원 가입 prac
    @PostMapping("/user/register")
    @ResponseBody
    public String register(@RequestBody NewUserDTO newUserDTO){
        System.out.println(newUserDTO);
//        newUserDTO.setUserId();
//        newUserDTO.setUserPw();
        return null;
    }
    @PostMapping("/user/login")
    @ResponseBody
    public String login(@RequestBody NewUserVO newUserVO){
        if(newUserVO.getUserId() != "minsu" || newUserVO.getUserPw() != "12341234"){
            return "로그인 정보가 잘못 되었습니다";
        }
        return newUserVO.getUserId() + "로그인 성공";
    }

}
