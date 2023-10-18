package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Post;
import SWP391.TattooPlatform.repository.PostRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPostList(){
        if (postRepository.findAll().isEmpty()) return null;
        else return postRepository.findAll();
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(String postID,
                           String postTitle,
                           String authorName,
                           String updateDate,
                           String thumbnailLink,
                           String description,
                           String briefInfo,
                           String status){
        postRepository.updatePost(postID, postTitle, authorName, updateDate, thumbnailLink, description, briefInfo, status);
        return postRepository.findPostByPostID(postID);
    }

    public Post deletePost(String postId) throws Exception{
        postRepository.deletePostByPostID(postId);
        if (postRepository.findPostByPostID(postId) == null) return null;
        else throw new Exception();
    }
}
