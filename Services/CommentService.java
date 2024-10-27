package Services;

import Entities.Comment;
import Entities.Post;
import Entities.User;
import Repos.CommentRepository;
import Request.CommentCreateRequest;
import Request.CommentUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;
    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Integer> userId,Optional<Integer> postId) {
        if (userId.isPresent()&& postId.isPresent()) {
            return commentRepository.findCommentByUser_Id(userId.get(),postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findCommentByUser_Id(userId.get());
        } else if (postId.isPresent()) {
            commentRepository.findCommentByUser_Id(postId.get());
        }
        return commentRepository.findAll();
    }

    public Comment createOneComment(CommentCreateRequest request) {
        User user = userService.getOneUser(request.getUserid());
        Post post = postService.getOnePostById(request.getPostid());
        if(user != null && post != null) {
            Comment commentTosave = new Comment();
            commentTosave.setUser(user);
            commentTosave.setId(request.getId());
            commentTosave.setText(request.getText());
            return commentRepository.save(commentTosave);
        }else return null;
    }

    public Comment getOneCommnetById(int commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment updateCommentById(Long commentid,@RequestBody CommentUpdateRequest updateComment) {
        Optional<Comment> comment = commentRepository.findById(Math.toIntExact(commentid));
        if (comment.isPresent()){
            Comment toUpdate = comment.get();
            toUpdate.setText(updateComment.getText());
            toUpdate.setTitle(updateComment.getTitle());
            commentRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long commentid) {
        commentRepository.deleteById(Math.toIntExact(commentid));
    }
}

