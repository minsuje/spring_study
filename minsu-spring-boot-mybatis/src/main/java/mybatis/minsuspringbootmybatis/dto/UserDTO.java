package mybatis.minsuspringbootmybatis.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no;
    // domain.User 와 다르게 "no" 라는 항목을 추가함
    // 실제 테이블에 존재하는 컬럼은 아니지만 서비스 로직에서 no 정보를 활용할 예정
    // DTO 안에는 테이블과 다른 값을 넣어 줄 수 있다.
}

//@Builder
// - 빌더 패턴
// - 디자인 패턴의 "생성" 패턴 중 하나
// - 객체를 생성하는 방법 중 하나
// 1) set 함수를 이용하는 방법
// 2) 생성자에 주입하는 방법
// 빌더 사용하면 setter 없이 생성 가능
// 빌더 패턴은 복잡한 객체의 생성 과정 및 표현 방법을 분리해서 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
// 생성자에게 넘겨주는 값의 순서를 신경 썼어야 했는데 빌더에서는 신경 쓰지 않아도 된다.
// 어떤 값을 넣을 지 명확하게 볼 수 있다는 장점이 있다.
// setter 를 이용하는 것보다 안전하다.
// setter 를 생성하지 않기 때문에 값을 변경하지 않는 곳에서 유용하다.
