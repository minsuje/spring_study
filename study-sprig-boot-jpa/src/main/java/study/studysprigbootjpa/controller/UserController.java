package study.studysprigbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import study.studysprigbootjpa.dto.UserDTO;
import study.studysprigbootjpa.entity.UserEntity;
import study.studysprigbootjpa.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUsers(Model model){
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    @PostMapping("/")
    @ResponseBody
    public String insert(@RequestBody UserEntity user){
        String newName = userService.insertUser(user);
        return newName + " Success";
    }
}
