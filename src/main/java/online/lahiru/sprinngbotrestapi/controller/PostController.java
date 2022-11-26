package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.payload.PostDTO;
import online.lahiru.sprinngbotrestapi.payload.PostDTOv2;
import online.lahiru.sprinngbotrestapi.payload.PostResponse;
import online.lahiru.sprinngbotrestapi.service.PostService;
import online.lahiru.sprinngbotrestapi.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post rest API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    //get all post rest API
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBY", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    //get post by id rest API
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostByIdv1(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTOv2> getPostByIdv2(@PathVariable(name = "id") long id) {
        PostDTO postDTO = postService.getPostById(id);
        PostDTOv2 postDTOv2 = new PostDTOv2();
        postDTOv2.setId(postDTO.getId());
        postDTOv2.setTitle(postDTO.getTitle());
        postDTOv2.setContent(postDTO.getContent());
        postDTOv2.setDescription(postDTO.getDescription());

        List<String> tags = new ArrayList<>();
        tags.add("java");
        tags.add("spring boot");
        tags.add("Hibernate");

        return ResponseEntity.ok(postDTOv2);
    }


    //update update post API
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO, @PathVariable(name = "id") long id) {
        PostDTO postResponce = postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postResponce, HttpStatus.OK);

    }

    //    delete post rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully !", HttpStatus.OK);
    }
}
