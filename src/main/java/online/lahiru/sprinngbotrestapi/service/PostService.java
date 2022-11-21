package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.PostDTO;
import org.springframework.stereotype.Service;


public interface PostService {
     PostDTO createPost(PostDTO postDTO);
}
