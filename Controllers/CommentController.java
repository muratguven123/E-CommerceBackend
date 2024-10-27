package Controllers;

import Entities.Comment;
import Entities.Post;
import Request.CommentCreateRequest;
import Request.CommentUpdateRequest;
import Request.PostUpdateRequest;
import Services.CommentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;
    private CommentCreateRequest comment;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment> getComments(@RequestParam Optional<Integer> userId,@RequestParam Optional<Integer> postId) {
        return commentService.getAllComments(userId,postId);
    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentUpdateRequest request) {
        return commentService.createOneComment(comment);
    }
    @GetMapping("{commentId}")
    public Comment getOneComment(@PathVariable int commentId) {
        return commentService.getOneCommnetById(commentId);
    }
    @PutMapping("{commentid")
    public Comment updateComment(@PathVariable Long commentid, @RequestBody CommentUpdateRequest updateComment){
        return commentService.updateCommentById(commentid,updateComment);
    }
    @DeleteMapping("/{commentid}")
    public void delteComment(@PathVariable Long commentid){
        commentService.deleteOnePostById(commentid);
    }

}
