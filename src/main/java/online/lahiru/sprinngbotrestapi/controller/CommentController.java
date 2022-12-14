package online.lahiru.sprinngbotrestapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.lahiru.sprinngbotrestapi.payload.CommentDTO;
import online.lahiru.sprinngbotrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = " CatsWhoCode REST APIs Comment Resourse")

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @ApiOperation(value = "Create Comment REST API")

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@Valid @PathVariable(value = "postId") long postId, @RequestBody
    CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get All commentsById REST API")

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommenntsByPostId(@PathVariable(value = "postId") long postId) {

        return commentService.getCommentsByPostId(postId);

    }
    @ApiOperation(value = "Get Single comment ById REST API")


    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId) {
        CommentDTO commentById = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentById, HttpStatus.OK);

    }
    @ApiOperation(value = "Update commentsById REST API")
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDTO> updateComment(@Valid @PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId, @RequestBody CommentDTO commentDTO) {

        CommentDTO updatedComment = commentService.updateComment(postId, commentId, commentDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);

    }
    @ApiOperation(value = "Delete commentById POST REST API")
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,@PathVariable(value = "id") Long commentId) {
        commentService.deletePost(postId, commentId);
        return new ResponseEntity<>("Commmet deleted successfully", HttpStatus.OK);
    }
}
