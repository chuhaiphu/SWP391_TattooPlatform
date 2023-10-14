package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Feedback;
import org.modelmapper.internal.bytebuddy.description.type.TypeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findAll();
    List<Feedback> findAllByArtistEmail(String email);
    List<Feedback> findAllByTattooLoverEmail(String email);
//    @Query(value = "SELECT f.feedbackID, stm.studioManagerEmail, f.rating, f.description FROM Feedback f JOIN BookingDetail bd ON f.bookingDetailID = bd.bookingDetailID " +
//                                            "JOIN Booking b ON bd.bookingID = b.bookingID " +
//                                            "JOIN Service s ON b.serviceID = s.serviceID " +
//                                            "JOIN Studio_Tattoo_Manager stm ON s.tattooManagerEmail = stm.studioManagerEmail WHERE stm.studioManagerEmail = :email")
//    List<Feedback> findAllByStudioManagerEmail(@Param String email);

    //CREATE FEEDBACK
    Feedback save(Feedback fb);


}
