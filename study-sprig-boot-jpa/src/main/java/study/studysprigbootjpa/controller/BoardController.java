package study.studysprigbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.studysprigbootjpa.dto.BoardDTO;
import study.studysprigbootjpa.entity.BoardEntity;
import study.studysprigbootjpa.service.BoardService;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoard(Model model){
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board";
    }

    @PostMapping("/board/insert")
    @ResponseBody
    public String postBoard(@RequestBody BoardEntity board){
        String title = boardService.insertBoard(board);
        return title + " 게시물이 추가 되었습니다";
    }

    @PatchMapping("/board/update")
    @ResponseBody
    public String updateBoard(@RequestBody BoardEntity board){
       String update = boardService.updateBoard(board);
        return update + " 가 수정 되었습니다.";
    }

    @DeleteMapping("/board/delete")
    @ResponseBody
    public void deleteBoard(@RequestParam int id){
//        boardRepository.delete(boardRepository.findById(id).orElseThrow(() -> new RuntimeException("has to correct user id")));
           boardService.deleteBoard(id);
//        return boardService.deleteBoard(id);
    }
}
