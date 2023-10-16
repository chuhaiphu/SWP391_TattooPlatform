package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Post;
import SWP391.TattooPlatform.service.PostService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Object getAllPost(){
        return ResponseUtils.get(postService.getPostList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody Post post){
        return ResponseUtils.get(postService.addPost(post), HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable String postId,
                                        @RequestParam String postTitle,
                                        @RequestParam String authorName,
                                        @RequestParam String updateDate,
                                        @RequestParam String thumbnailLink,
                                        @RequestParam String description,
                                        @RequestParam String briefInfo,
                                        @RequestParam String status){
        return ResponseUtils.get(postService.updatePost(postId, postTitle, authorName, updateDate, thumbnailLink, description, briefInfo, status), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable String postId) throws Exception {
        return ResponseUtils.get(postService.deletePost(postId), HttpStatus.OK);
    }
}
