package study.studysprigbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.studysprigbootjpa.entity.BoardEntity;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
