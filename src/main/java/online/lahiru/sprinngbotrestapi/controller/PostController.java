package online.lahiru.sprinngbotrestapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import online.lahiru.sprinngbotrestapi.payload.PostDTO;
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
@Api(value = "CatsWhoCode REST APIs POst Resourse")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post rest API
    @ApiOperation(value = "Create POST REST API")
//    @ApiResponse(va)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    //get all post rest API
    @ApiOperation(value = "Get all POST REST API")

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
    @ApiOperation(value = "Get POST by id REST API")

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostByIdv1(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }




    //update update post API
    @ApiOperation(value = "Update POST REST API")

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO, @PathVariable(name = "id") long id) {
        PostDTO postResponce = postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postResponce, HttpStatus.OK);

    }

    //    delete post rest Api
    @ApiOperation(value = "Delete POST REST API")

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully !", HttpStatus.OK);
    }
}
