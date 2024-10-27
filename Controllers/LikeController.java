package Controllers;

import Entities.Like;
import Entities.Post;
import Request.LikeCreateRequest;
import Request.PostCreateRequest;
import Request.PostUpdateRequest;
import Services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {
    private LikeService likeService;
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping
    public List<Like> getAllLike(@RequestParam Optional<Integer> userId) {
        return likeService.getAllLike(userId);
    }
    @PostMapping
    public Like createOnePost(@RequestBody LikeCreateRequest newLikeRequest) {
        return likeService.createOnePost(newLikeRequest);
    }
    @GetMapping("/{likeId}")
    public Like getOnePost(@PathVariable Integer postId) {
        return likeService.getOnePostById(postId);
    }
    @PutMapping("/{postId}")
    public Like updateOnePost(@PathVariable Long likeId, @RequestBody PostUpdateRequest updatePost){
        return likeService.updateOnePostById(likeId,updatePost);
    }
    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        likeService.deleteOnePostById(postId);
    }
}
