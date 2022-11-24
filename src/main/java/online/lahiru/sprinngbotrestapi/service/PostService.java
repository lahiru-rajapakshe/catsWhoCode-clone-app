package online.lahiru.sprinngbotrestapi.service;

import online.lahiru.sprinngbotrestapi.payload.PostDTO;
import online.lahiru.sprinngbotrestapi.payload.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
     PostDTO createPost(PostDTO postDTO);

     PostResponse getAllPosts(int pageNo, int pageSize,String sortBy);

     PostDTO getPostById(long id);


     PostDTO updatePost(PostDTO postDTO, long id);

     void deletePostById(long id);
}
