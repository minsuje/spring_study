package mybatis.minsuspringbootmybatis.controller;

import mybatis.minsuspringbootmybatis.domain.Board;
import mybatis.minsuspringbootmybatis.dto.BoardDTO;
import mybatis.minsuspringbootmybatis.dto.UserDTO;
import mybatis.minsuspringbootmybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;


    @GetMapping({"/board/{title}", "/board"})
    public String getTable(@PathVariable(value = "title", required = false) String title, Model model){
        List<BoardDTO> boardList = boardService.getAllBoardList();

        if(title != null) {
            List<BoardDTO> boardTitleList = boardService.getTitleBoard(title);
            model.addAttribute("boardList", boardTitleList);
        }else{
            // mybatis 를 통해 전달된 정보를 받아와 users 에 넣고
            model.addAttribute("boardList", boardList);
            // 템플릿으로 값을 전달하는 model 에 담아 전달한다.
        }
        return "board";
    }

    @PostMapping("/board")
    public String boardInsert(@RequestParam String title, @RequestParam String content, @RequestParam String writer){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        boardService.insertBoard(board);
        return "board";
    }

//    @GetMapping("/board/{title}")
//    public String getBoardWithTitle(@PathVariable(value = "title") String title, Model model){
//        List<BoardDTO> boardTitleList = boardService.getTitleBoard(title);
//        model.addAttribute("boardList", boardTitleList);
//        return "board";
//    }
}
