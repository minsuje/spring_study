package study.studysprigbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.studysprigbootjpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;


// JpaRepository
// - 인터페이스
// - JpaRepository<T, ID>
// - T: 테이블에 매핑될 엔티티 클래스
// - ID : 엔티티의 기본 키 타입

// Repository
// - Entity 에 의해 생성된 DB에 접근하는 메소드를 사용하기 위한 인터페이스
@Repository // Repository 계층임을 명시하는 클래스
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // 1)
    // existsByXXX()
    // - XXX : 컬럼 명, Upper Case
    // - XXX 과 일치하는 것이 있는지 boolean 반환
    boolean existsByName(String name);

    // 2)
    // findByXXX()
    // - XXX : 컬럼 명 , Upper Case
    // - XXX 의 값을 찾아서 반환해줌
    List<UserEntity> findByName(String name); // 해당하는 이름이 여러개 일 수 있어서 List 로 반환
    List<UserEntity> findByNameOrNickname(String name, String nickname); // 또는 을 사용해서 찾아준다.

    // 반환 형식은 Entity 또는 List<Entity> 모두 가능
    // 단! 반환된 값이 1개를 넘는데 Entity 로 넣으려고 하면 문제가 발생 하니까 List 로 담자

    // Optional
    // - null 이 될 수 도 있을 때 사용
    Optional<UserEntity> findById(int id); // findById 는 id 를 제공하는 것

    // @Query 어노테이션
    // - JpaRepository 인터페이스에 내장된 메소드만으로 해결이 안되는 경우, raw query 작성 가능
    // - 일반 적인 SQL 문과 조금 다르다!
    // JPA 는 테이블이 아니라 객체 위주로 돌아가기 때문데 객체 (Entity) 이름으로 사용해야 함
    // ex. @Query("SELECT u FROM UserEntity u where u.name=:name and u.nickname=:nickname") , * u 는 전체를 의미
    // - nativeQuery 옵션을 사용하면 찐 raw SQL 문으로 사용 가능 -> DBMS 종속적이지 않은 ORM 특징을 살릴 수 없음
    // ex. @Query(nativeQuery = true, value = "SELECT * FROM user where u.name=:name and u.nickname=:nickname")

    @Query("select u from UserEntity u where u.name=:name")
    UserEntity findName(String name);

}
