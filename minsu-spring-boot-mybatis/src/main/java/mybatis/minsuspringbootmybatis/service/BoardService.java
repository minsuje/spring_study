package mybatis.minsuspringbootmybatis.service;


import mybatis.minsuspringbootmybatis.domain.Board;
import mybatis.minsuspringbootmybatis.domain.User;
import mybatis.minsuspringbootmybatis.dto.BoardDTO;
import mybatis.minsuspringbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    UserMapper userMapper;

    public List<BoardDTO> getAllBoardList(){
        List<Board> boards = userMapper.boardAll();
        List<BoardDTO> listAll = new ArrayList<>();
        for(Board b : boards){
            BoardDTO board = BoardDTO.builder().title(b.getTitle())
                    .content(b.getContent())
                    .writer(b.getWriter())
                    .id(b.getId())
                    .registered(b.getRegistered())
                    .build();
            listAll.add(board);
        }
        return listAll;
    }

    public List<BoardDTO> getTitleBoard(String title){
        List<Board> boards = userMapper.boardTitle(title);
        System.out.println("boards >>>>> " + boards);
        List<BoardDTO> listTitle = new ArrayList<>();
        for(Board b : boards){
            BoardDTO board = BoardDTO.builder().title(b.getTitle())
                    .content(b.getContent())
                    .writer(b.getWriter())
                    .id(b.getId())
                    .registered(b.getRegistered())
                    .build();
            listTitle.add(board);
        }
        return listTitle;
    }

    public void insertBoard(Board board){
        userMapper.insertBoard(board);
    }

    // 방식 1
    public void updateBoard(Board board) { userMapper.updateBoard(board);}

    public void deleteBoard(Board board) {userMapper.deleteBoardWithID(board);}


    // 방식 2
    public void patchBoard(Board board){
        userMapper.patchBoard(board);
    }

    public void delete(int id){
        userMapper.delete(id);
    }

    public int searchBoard(String word){
        // select 문  자체를 count 로 동작시킬 수도 있고,
        // List 로 받아서 그에 대한 길이를 전달할 수도 있다.
     List<Board> result = userMapper.searchBoard(word);
     return result.size();
//     return result;
    }
}
