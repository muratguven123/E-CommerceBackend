package Services;

import Entities.Post;
import Entities.User;
import Repos.PostRepository;
import Request.PostCreateRequest;
import Request.PostUpdateRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
  private   PostRepository postRepository;
  private UserService userService;
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPost(Optional<Integer> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePostById(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
      User user =   userService.getOneUser(newPostRequest.getUserId());
      if (user==null) return null;
      Post toSave = new Post();
      toSave.setId(newPostRequest.getUserId());
      toSave.setText(newPostRequest.getText());
      toSave.setTitle(newPostRequest.getTitle());
      toSave.setUser(user);
      return postRepository.save(toSave);

    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(Math.toIntExact(postId));
        if (post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(Math.toIntExact(postId));
    }
}
