package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Post;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Long> {

    //View
    List<Post> findAll();

    //Search
    Post findPostByPostID(String id);

    //Add
    Post save(Post post);

    //Update
    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.postTitle = :newPostTitle," +
            "p.authorName = :newAuthorName, " +
            "p.updateDate = :newUpdateDate, " +
            "p.thumbnailLink = :newThumbnailLink, " +
            "p.description = :newDescription, " +
            "p.briefInfo = :newBriefInfo, " +
            "p.status = :newStatus " +
            "WHERE p.postID = :postID")
    void updatePost(@Param("postID") String postID,
                    @Param("newPostTitle") String postTitle,
                    @Param("newAuthorName") String authorName,
                    @Param("newUpdateDate") String updateDate,
                    @Param("newThumbnailLink") String thumbnailLink,
                    @Param("newDescription") String description,
                    @Param("newBriefInfo") String briefInfo,
                    @Param("newStatus") String status);

    //Delete
    @Modifying
    @Transactional
    void deletePostByPostID(String id);
}
