package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Feedback;
import org.modelmapper.internal.bytebuddy.description.type.TypeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    Feedback save(Feedback fb);
    List<Feedback> findAll();
    List<Feedback> findAllByArtistEmail(String email);
    Feedback findByBookingDetailID(String id);
    @Query(value = "SELECT f FROM Feedback f JOIN Artist a ON f.artistEmail = a.email WHERE a.email = :email")
    List<Feedback> findAllByStudioManagerEmail(@Param("email") String email);


}
