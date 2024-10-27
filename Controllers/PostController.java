package Controllers;

import Entities.Post;
import Request.PostCreateRequest;
import Request.PostUpdateRequest;
import Services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
   private PostService postService;
   public PostController(PostService postService) {
      this.postService = postService;
   }
   @GetMapping
   public List<Post> getAllPost(@RequestParam Optional<Integer> userId) {
      return postService.getAllPost(userId);
   }
   @PostMapping
   public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
      return postService.createOnePost(newPostRequest);
   }

   @GetMapping("/{postId}")
   public Post getOnePost(@PathVariable Integer postId) {
      return postService.getOnePostById(postId);
   }
   @PutMapping("/{postId}")
   public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
      return postService.updateOnePostById(postId,updatePost);
   }
   @DeleteMapping("/{postId}")
   public void deleteOnePost(@PathVariable Long postId){
      postService.deleteOnePostById(postId);
   }

}
