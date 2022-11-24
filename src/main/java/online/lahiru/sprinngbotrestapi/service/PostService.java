package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
     PostDTO createPost(PostDTO postDTO);

     List<PostDTO> getAllPosts();

     PostDTO getPostById(long id);


     PostDTO updatePost(PostDTO postDTO, long id);
}
