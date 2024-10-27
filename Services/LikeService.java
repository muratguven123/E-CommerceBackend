package Services;

import Entities.Like;
import Entities.Post;
import Entities.User;
import Repos.LikeRepository;
import Request.LikeCreateRequest;
import Request.PostUpdateRequest;
import org.springframework.stereotype.Service;
import Entities.Like;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;

    }

    public List<Like> getAllPost(Optional<Integer> userId) {
        if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        }
        return likeRepository.findAll();
    }

    public List<Like> getAllLike(Optional<Integer> userId ){
            if (userId.isPresent()) {
                return likeRepository.findByUserId(userId.get());
            }
            return likeRepository.findAll();
        }

    public Like createOnePost(LikeCreateRequest newLikeRequest) {
        User user =   userService.getOneUser(likeRepository.getUserId());
        if (user==null) return null;
        Like toSave = new Like();
        toSave.setText(newLikeRequest.getText());
        toSave.setTitle(newLikeRequest.getTitle());
        toSave.setUser(user);
        return likeRepository.save(toSave);
    }

    public Like getOnePostById(Integer postId) {
        return likeRepository.findById(postId).orElse(null);
    }

    public Like updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Like> like = likeRepository.findById(Math.toIntExact(postId));
        if (like.isPresent()){
            Like toUpdate = like.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            likeRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long likeId) {
        likeRepository.deleteById(Math.toIntExact(likeId));
    }
}

