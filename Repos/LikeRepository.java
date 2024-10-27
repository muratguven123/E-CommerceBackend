package Repos;
import Entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    List<Like> findCommentByUser_Id(Integer integer, Integer integer1);
    List<Like> findCommentByUser_Id(Integer integer);

    List<Like> findByUserId(Integer integer);

    Integer getUserId();
}
