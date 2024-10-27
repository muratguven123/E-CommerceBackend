package Repos;
import org.springframework.data.jpa.repository.JpaRepository;
import Entities.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentByUser_Id(int id,int postid);
    List<Comment> findCommentByUser_Id(int id);

}
