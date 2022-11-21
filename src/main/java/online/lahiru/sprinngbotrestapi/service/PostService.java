package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.PostDTO;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}
