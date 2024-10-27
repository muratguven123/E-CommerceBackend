package Repos;
import Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import Entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
        List<Post> findByUserId(int userId);
}
