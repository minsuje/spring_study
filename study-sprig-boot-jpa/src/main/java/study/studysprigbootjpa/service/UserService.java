package study.studysprigbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.studysprigbootjpa.dto.UserDTO;
import study.studysprigbootjpa.entity.UserEntity;
import study.studysprigbootjpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUserList(){
        // repository 에서 전체 조회 가능하도록
        // findAll() JpaRepository 인터페이스에 정의되어 있는 메서드

        // findAll 은 안 만들었지만 상속받은 JpaRepository 에 들어 있다.
       List<UserEntity> users = userRepository.findAll();
       List<UserDTO> result = new ArrayList<>();
       for(UserEntity user : users) {
           UserDTO userDTO = UserDTO.builder()
                   .id(user.getId())
                   .name(user.getName())
                   .nickname(user.getNickname())
                   .no(user.getId() + 100)
                   .build();

           result.add(userDTO);
       }
       return result;
    }

    public String insertUser(UserEntity user){
        // jpa save(T) 메서드 : T 는 Entity
        // - insert 할 때 사용한다.
        // - 기존 entity 를 update 할 때 사용
        // => 기본값(pk) 상태에 따라 다르게 동작
        // pk 가 존재하면 pk 와 연결된 entity update
        // pk 가 없는 경우, 새로운 entity insert
        UserEntity newUser = userRepository.save(user); // 새로 생성된 유저를 반환
        // save 를 했을 때 반환되는 객체는 Entity 객체
        return newUser.getName();
    }
}
