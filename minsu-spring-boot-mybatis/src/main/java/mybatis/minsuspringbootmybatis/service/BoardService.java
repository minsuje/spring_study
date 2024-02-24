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
}
