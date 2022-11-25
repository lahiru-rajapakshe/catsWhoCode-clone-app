package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(long postId,CommentDTO commentDTO);

    List<CommentDTO> getCommentsByPostId(long postId);
}
