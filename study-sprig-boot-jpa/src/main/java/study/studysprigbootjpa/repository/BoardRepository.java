package study.studysprigbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.studysprigbootjpa.entity.BoardEntity;
import study.studysprigbootjpa.entity.UserEntity;

import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    Optional<BoardEntity> findById(int id);
}
