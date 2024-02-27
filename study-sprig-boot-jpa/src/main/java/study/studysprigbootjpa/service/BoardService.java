package study.studysprigbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.studysprigbootjpa.dto.BoardDTO;
import study.studysprigbootjpa.entity.BoardEntity;
import study.studysprigbootjpa.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;


    // DateTime -> String
    // SimpleDateFormat(형식).format(dateTime 테이더)
    // ex. new SimpleDateFormat("yyyy-mm-dd").format(board.getRegistered())

    public List<BoardDTO> getBoardList(){
        List<BoardEntity> boards = boardRepository.findAll();
        List<BoardDTO> result = new ArrayList<>();
        for(BoardEntity b : boards){
            BoardDTO board = BoardDTO.builder()
                    .id(b.getId())
                    .title(b.getTitle())
                    .content(b.getContent())
                    .registered(b.getRegistered())
                    .writer(b.getWriter())
                    .build();

            result.add(board);
        }
        return result;
    }

    public String insertBoard(BoardEntity board){
        BoardEntity newBoard = boardRepository.save(board);
        return newBoard.getTitle();
    }

    //update
    //보통 patch 를 할 때, id 랑 정보랑 따로 전달하니까
    public void patchBoard(BoardDTO boardDTO){
        BoardEntity board = boardRepository.findById(boardDTO.getId()).orElseThrow(() -> new RuntimeException("board patch : id is wrong"));
        BoardEntity modified = BoardEntity.builder()
                .id(board.getId())
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .registered(boardDTO.getRegistered())
                .build();
        boardRepository.save(modified);
    }

    // delete
    public void deleteBoards(int id){
        // repository 의 delete 기본 메서드 이용
        // delete(Entity)
        // 1) id 를 이용해서 entity 를 검색
        // 2) 검색된 entity 를 delete 에 보내야 삭제 완료
        boardRepository.delete(boardRepository.findById(id).orElseThrow(() -> new RuntimeException("has to correct user id")));
    }
    public String updateBoard(BoardEntity board){
        BoardEntity updateBoards = boardRepository.save(board);
        return updateBoards.getId() + updateBoards.getTitle();
    }

    public void deleteBoard(int id){
        boardRepository.delete(boardRepository.findById(id).orElseThrow(() -> new RuntimeException("has to correct user id")));
//        boardRepository.delete(id);
    }
}
