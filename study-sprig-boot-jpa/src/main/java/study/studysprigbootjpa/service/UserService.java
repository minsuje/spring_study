package study.studysprigbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import study.studysprigbootjpa.dto.UserDTO;
import study.studysprigbootjpa.entity.UserEntity;
import study.studysprigbootjpa.repository.UserRepository;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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




    // 아이디로 찾아보자~
    public String searchId(int id){
        Optional<UserEntity> userid = userRepository.findById(id);
        // Get() : optional 내부에 담긴 객체 반환
        // - 만약 null 이라면 null NoSuchElementException 발생
        // isPresent() : 메서드를 통해서 객체 여부를 boolean 값으로 반환
        // orElse() : 있으면 반환하고 없으면 다른 값 반환 (()있는 설정된 값)
        // - orElse : Optional.orElse()
//        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user doesn't exist"));

        if(userid.isPresent()){
            return userid.get().getName();
        } else {
            return "no User";
        }
    }


    public String searchName(String name){
//    public String getUsers(@RequestParam String name){
        List<UserEntity> users = userRepository.findByName(name);
        for (UserEntity user : users){
            System.out.println(user.getId() + user.getNickname());
        }
        return users.size() + " 명";
    }

    public String searchNameOrNickname(String word){
        List<UserEntity> users = userRepository.findByNameOrNickname(word, word);
        return users.size() + " 명";
    }



    public boolean checkUser(String name){
        return userRepository.existsByName(name);
    }
    public List<UserEntity> userList(String name){
        return userRepository.findByName(name);
    }
    public List<UserEntity> userNameOrNick(String name, String nickname){
        return userRepository.findByNameOrNickname(name, nickname);
    }
    public Optional<UserEntity> findUser(int id){
        return userRepository.findById(id);
    }

    public UserEntity findName (String name){
        return userRepository.findName(name);
    }
}
