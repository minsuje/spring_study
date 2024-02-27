package study.studysprigbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.studysprigbootjpa.dto.UserDTO;
import study.studysprigbootjpa.entity.UserEntity;
import study.studysprigbootjpa.service.UserService;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody UserEntity user){
        String newName = userService.insertUser(user);
        return newName + " Success";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkName(@RequestParam String name){
        // name 을 param 으로 받아서 그런 이름을 가진 사용자가 있는지 여부를 return
        boolean result = userService.checkUser(name);
        if(result){
            return "있습니다.";
        }else{
            return "없습니다.";
        }
    }
    @GetMapping("/check/list")
    @ResponseBody
    public String getUser(String name){
//    public String getUsers(@RequestParam String name){
        List<UserEntity> users = userService.userList(name);
        for (UserEntity user : users){
            System.out.println(user.getId() + user.getNickname());
        }
        return users.size() + " 명";
    }
    ////////

    @GetMapping("/nickname")
    @ResponseBody
    public String findNameOrNickname(@RequestParam String word){
        String cnt = userService.searchNameOrNickname(word);
        return cnt + "명 입니다";
    }
//
    @GetMapping("/search")
    @ResponseBody
    public String searchName(@RequestParam String name){
        // query name 으로 받은 값으로 겁색
        return  userService.searchName(name);
    }

    @GetMapping("/searchid")
    @ResponseBody
    public String searchName(@RequestParam int id){
        // Optional 확인용
        return  userService.searchId(id);
    }

    /////////////

    @GetMapping("/check/list/users")
    @ResponseBody
    public String getUsersNameOrNick(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "nickname", required = false) String nickname){
        List<UserEntity> users = userService.userNameOrNick(name, nickname);
        return users.size() + " 명";
    }

    @GetMapping("/find")
    @ResponseBody
    public String getFindUserId(@RequestParam int id){
        System.out.println("!!!!!!!!!!!");
        Optional<UserEntity> userid = userService.findUser(id);
        System.out.println(userService.findUser(id));
        if(userid == null){
            return "존재하지 않는 유저 입니다.";
        }else{
            return "존재하는 유저 입니다.";
        }
    }

    @GetMapping("/find/sql")
    @ResponseBody
    public String getFindUserSQL(@RequestParam String name){
        UserEntity user = userService.findName(name);
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .no(user.getId())
                .build();

        return userDTO.getUser();
    }
}
