package mybatis.minsuspringbootmybatis.controller;

import mybatis.minsuspringbootmybatis.domain.Board;
import mybatis.minsuspringbootmybatis.dto.BoardDTO;
import mybatis.minsuspringbootmybatis.dto.UserDTO;
import mybatis.minsuspringbootmybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board") // /board가 기본으로 들어간 형태
public class BoardController {
    @Autowired
    BoardService boardService;


    @GetMapping({"{title}", ""})
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

    // 방식 1 - post
//    @PostMapping("/")
//    public String boardInsert(@RequestParam String title, @RequestParam String content, @RequestParam String writer){
//        Board board = new Board();
//        board.setTitle(title);
//        board.setContent(content);
//        board.setWriter(writer);
//        boardService.insertBoard(board);
//        return "board";
//    }

    // 방식 2 - post axios
    @PostMapping("")
    @ResponseBody
    public void boardInsert2(@RequestBody Board board){
        // 게시글 작성 - post
        boardService.insertBoard(board);
    }

    // update 방식 1 - 일반 폼
    @PostMapping("update/{id}")
    public String boardUpdate(@PathVariable(value = "id") int id, @RequestParam String title, @RequestParam String content, @RequestParam String writer){
        Board board = new Board();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        boardService.updateBoard(board);
        return "board";
    }

    // delete 방식 - 일반 폼
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        Board board = new Board();
        board.setId(id);
        boardService.deleteBoard(board);
        return "board";
    }

    // update 방식 2 - axios
    @PatchMapping("")
    @ResponseBody
    public void patchBoard(@RequestBody Board board){
        // 3. 게시글 수정 - update 문
        boardService.patchBoard(board);
    }

    // delete 방식 2
    @DeleteMapping("")
    @ResponseBody
    public void deleteBoard(@RequestParam int id){
        // 게시글 삭제 - delete 문
        boardService.delete(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word){
        // 5. 게시글 검색 - get
        return boardService.searchBoard(word);
    }


//    @GetMapping("/board/{title}")
//    public String getBoardWithTitle(@PathVariable(value = "title") String title, Model model){
//        List<BoardDTO> boardTitleList = boardService.getTitleBoard(title);
//        model.addAttribute("boardList", boardTitleList);
//        return "board";
//    }
}
