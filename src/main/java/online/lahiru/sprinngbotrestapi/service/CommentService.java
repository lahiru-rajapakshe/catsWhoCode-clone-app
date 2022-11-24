package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.CommentDTO;

public interface CommentService {
    CommentDTO createComment(long postId,CommentDTO commentDTO);
}
