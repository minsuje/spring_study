package mybatis.minsuspringbootmybatis.controller;

import mybatis.minsuspringbootmybatis.domain.Board;
import mybatis.minsuspringbootmybatis.domain.User;
import mybatis.minsuspringbootmybatis.dto.UserDTO;
import mybatis.minsuspringbootmybatis.service.BoardService;
import mybatis.minsuspringbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 작업 순서: sql 이용해 table 생성 -> 도메인 생성 -> dto -> mapper -> service -> controller

@Controller
public class UserController {
    // Create, Read

    @Autowired
    UserService userService; // UserService 가 Bean 으로 등로 된 개체야애 한다.
    // @Service 어노테이션 안에는 @Component 가 포함되어 있어서 사용 가능
    BoardService boardService;

    @GetMapping("/")
    public String getUser(Model model){
        List<UserDTO> users = userService.getUserList();
        // mybatis 를 통해 전달된 정보를 받아와 users 에 넣고
        model.addAttribute("list", users);
        // 템플릿으로 값을 전달하는 model 에 담아 전달한다.
        return "user";
    }

    // postman 사용해서 값 insert 할 것
    @PostMapping("/user")
    public String userInsert(@RequestParam String name, @RequestParam String nickname){
        User user = new User();
        user.setName(name);
        user.setNickname(nickname);
        userService.insertUser(user);
        return "user";
//        return "redirect:/";
    }

}
