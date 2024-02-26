package study.studysprigbootjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity
// - DB 에서 쓰이는 필드와 매핑이 되는 클래스 ( DB 테이블과 대응되는 클래스 ), domain 과 entity 를 혼용해서 사용하기 때문에 주의

// 빌더, 엔티티 어노테이션 동시에 사용 -> 두개가 충동하여 생성자가 만들어지지 않는 문제 발생! (한 쪽이 안생김)
// 원래는 Entity, Builder 각각에 맞는 생성자가 자동으로 생김
// 빌더 -> 모든 필드를 사용하는 생성자가 필요
// 엔티티 -> 기본 생성자 필요
// 그래서 해결하기 위해 직접 두개를 전부 만들어 준다.

@Getter
@Builder
@AllArgsConstructor // 모든 필드를 사용하는 생성자
@NoArgsConstructor // 매개변수가 없는 생성자 (기본 생성자)
@Entity // 해당 클래스가 Entity 클래스임을 명시, ( 반드시 추가!! )
@Table(name = "user") // 테이블 명과 클래스 명이 동일한 경우 생략 가능 ( 대문자 사용하려면 따로 설정 필요 )
// name = user 의미는 user 라는 이름의 테이블로 만들거다
public class UserEntity {
    @Id // PK를 지정해주는 값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 사용하겠다는 옵션!
    private int id;

    // length 를 안적으면 최대값 255 가 들어간다.
    @Column(nullable = false, length = 20) // null 이 안된다는 옵션 과 varchar = 20 이라는 옵션
    private String name; // 만약 컬럼 명이 다르다면 name ="text" 로 매핑시킬 컬럼명 적어주면 된다.

    // 타입 : varchar 가 아니라 "TEXT" 로 들어간다.
    @Column(columnDefinition = "TEXT")
    private String nickname;

    // 참고, Enum 타입 지정 가능
//    @Column
//    @Enumerated(EnumType.STRING)
//    private UserType type;
//    public enum UserType{
//        STUDENT, TEACHER
//    }
}
