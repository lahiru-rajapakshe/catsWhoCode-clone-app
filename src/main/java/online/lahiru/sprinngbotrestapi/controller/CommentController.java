package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.payload.CommentDTO;
import online.lahiru.sprinngbotrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") long postId, @RequestBody
    CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommenntsByPostId(@PathVariable(value = "postId") long postId) {

        return commentService.getCommentsByPostId(postId);

    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId) {
        CommentDTO commentById = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentById, HttpStatus.OK);

    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId, @RequestBody CommentDTO commentDTO) {

        CommentDTO updatedComment = commentService.updateComment(postId, commentId, commentDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);

    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,@PathVariable(value = "id") Long commentId) {
        commentService.deletePost(postId, commentId);
        return new ResponseEntity<>("Commmet deleted successfully", HttpStatus.OK);
    }
}
