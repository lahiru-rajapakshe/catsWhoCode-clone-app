package online.lahiru.sprinngbotrestapi.service.impl;

import online.lahiru.sprinngbotrestapi.entity.Comment;
import online.lahiru.sprinngbotrestapi.entity.Post;
import online.lahiru.sprinngbotrestapi.exception.BlogAPIException;
import online.lahiru.sprinngbotrestapi.exception.ResourceNotFoundException;
import online.lahiru.sprinngbotrestapi.payload.CommentDTO;
import online.lahiru.sprinngbotrestapi.repository.CommentRepository;
import online.lahiru.sprinngbotrestapi.repository.PostRepository;
import online.lahiru.sprinngbotrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.BadLocationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);

        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);


        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());

    }

    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw  new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs to the post");
        }
        return mapToDTO(comment);
    }

    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmial(comment.getEmial());
        commentDTO.setBody(comment.getBody());

        return commentDTO;
    }

    private Comment mapToEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setEmial(commentDTO.getEmial());
        comment.setBody(commentDTO.getBody());

        return comment;
    }
}
