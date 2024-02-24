package mybatis.minsuspringbootmybatis.service;

import mybatis.minsuspringbootmybatis.domain.User;
import mybatis.minsuspringbootmybatis.dto.UserDTO;
import mybatis.minsuspringbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// - 스프링 부트에게 서비스 계층임을 알림
// - 해당 어노테이션이 없으면 컨트롤러에서 서비스 클래스를 찾을 수 없음
// 꼭 작성하자, -> 로직 구현 위치
public class UserService {
    // @AutoWired
    // 의존성 주입 하는 어노테이션( 쉽게 말하면, 원하는 객체를 직접 생성하지 않고도 사용할 수 있도록 함!)

    @Autowired
    UserMapper userMapper;
    // 지금 여기서는 필드 주입 방식 사용

    // getUserList()
    // - controller 에서 전체 조회
    // - mapper 의 retrieveAll() 메서드 실행

    public List<UserDTO> getUserList(){
        List<User> users = userMapper.retrieveAll();
        List<UserDTO> result = new ArrayList<>();
        for(User user: users){
            // case 1) builder 패턴 사용하지 않는 경우
//            UserDTO userDTO = new UserDTO(); // @Builder 어노테이션을 사용하면 빨간 줄 발생!
//            userDTO.setId(user.getId());
//            userDTO.setName(user.getName());
//            userDTO.setNickname(user.getNickname());
//            userDTO.setNo(user.getId() + 100);

            ///////////////////////////////////////////
            // case 2) builder 패턴 사용하는 경우 , 객체를 생성할 때 사용하는게 builder 패턴
            UserDTO userDTO = UserDTO.builder().name(user.getName())
                    .nickname(user.getNickname())
                    .id(user.getId())
                    .no(user.getId() + 100)
                    .build();

            result.add(userDTO);
        }
        return result;
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }
}
