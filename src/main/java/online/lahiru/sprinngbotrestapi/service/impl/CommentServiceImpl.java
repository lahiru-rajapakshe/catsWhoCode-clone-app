package online.lahiru.sprinngbotrestapi.service.impl;

import online.lahiru.sprinngbotrestapi.entity.Comment;
import online.lahiru.sprinngbotrestapi.payload.CommentDTO;
import online.lahiru.sprinngbotrestapi.repository.CommentRepository;
import online.lahiru.sprinngbotrestapi.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        return null;
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
