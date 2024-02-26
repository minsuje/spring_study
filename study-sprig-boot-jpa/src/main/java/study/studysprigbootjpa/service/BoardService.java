package study.studysprigbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.studysprigbootjpa.repository.BoardRepository;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;



}
