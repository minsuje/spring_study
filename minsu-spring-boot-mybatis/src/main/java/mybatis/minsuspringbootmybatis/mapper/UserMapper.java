package mybatis.minsuspringbootmybatis.mapper;

import mybatis.minsuspringbootmybatis.domain.Board;
import mybatis.minsuspringbootmybatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper // 스프링 부트에게 Mapper 역할을 하는 인터페이스임을 알림
public interface UserMapper {
    // sql 과 객체를 매핑해주는 곳으로 실제 DB 접속할 때 실행할 sql 문 정의

//    case 1. xml 파일 (mapper 파일) 참고
    List<User> retrieveAll();
    // UserMapper.xml 의 id 값과 함수 이름이 같아야 함
    // User 에 대한 내용이List 형태로 반환함

    // case 2. xml 파일 (mapper 파일) 참고하지 않고, sql 을 실행
    @Insert("insert into user (name, nickname) values (#{name}, #{nickname})")
    void insertUser(User user);
    // 외부에서 insertUser 를 실행하면 위에 Insert 에 적힌 sql 문이 실해 됨
    // 변수를 사용할 때는 #을 사용해서 사용할 수 있다.
    // void insertUser(String name, String nickname); 방식으로도 동일하게 동작
    List<Board> boardAll();
    List<Board> boardTitle(String title);
    @Insert("insert into board (title, content, writer) values (#{title}, #{content}, #{writer})")
    void insertBoard(Board board);

    @Delete("delete from board where id = #{id}")
    void deleteBoardWithID(Board board);

    @Delete("delete from board")
    void deleteAllBoard(Board board);

    @Update("UPDATE board SET title = #{title}, content=#{content}, writer=#{writer} where id = #{id}")
    void updateBoard(Board board);

    void patchBoard(Board board);
    void delete(int id);

//    SearchBoard
    List<Board> searchBoard(String word);
}
