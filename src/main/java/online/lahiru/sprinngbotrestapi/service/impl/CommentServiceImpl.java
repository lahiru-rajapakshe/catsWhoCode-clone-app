package online.lahiru.sprinngbotrestapi.service.impl;

import online.lahiru.sprinngbotrestapi.entity.Comment;
import online.lahiru.sprinngbotrestapi.entity.Post;
import online.lahiru.sprinngbotrestapi.exception.ResourceNotFoundException;
import online.lahiru.sprinngbotrestapi.payload.CommentDTO;
import online.lahiru.sprinngbotrestapi.repository.CommentRepository;
import online.lahiru.sprinngbotrestapi.repository.PostRepository;
import online.lahiru.sprinngbotrestapi.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);

        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);

        


        return mapToDTO(newComment);
    }

    private CommentDTO mapToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmial(comment.getEmial());
        commentDTO.setBody(comment.getBody());

        return commentDTO;
    }
private Comment mapToEntity(CommentDTO commentDTO){
    Comment comment = new Comment();
    comment.setId(commentDTO.getId());
    comment.setName(commentDTO.getName());
    comment.setEmial(commentDTO.getEmial());
    comment.setBody(commentDTO.getBody());

    return comment;
}
}
