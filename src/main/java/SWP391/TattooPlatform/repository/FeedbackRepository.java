package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Feedback;
import org.modelmapper.internal.bytebuddy.description.type.TypeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    Feedback save(Feedback fb);
    List<Feedback> findAll();
    List<Feedback> findAllByArtistEmail(String email);
    List<Feedback> findAllByTattooLoverEmail(String email);
    Feedback findByBookingDetailID(String id);

    Feedback findByFeedbackID(String id);

    @Modifying
    @Transactional
    @Query(value = "update  Feedback  f set f.description = :description, " +
            "f.artistRating = :artistRating where  f.feedbackID = :feedbackID")
    void update(@Param("feedbackID") String feedbackID,
                @Param("description") String description,
                @Param("artistRating") int artistRating
                );


}
