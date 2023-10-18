package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {
    List<BookingStatus> findAll();

    BookingStatus findBookingStatusByStatusID(@Param("statusID") String statusID);

    BookingStatus save(BookingStatus bookingStatus);

    @Modifying
    @Transactional
    @Query("update BookingStatus bs set bs.statusDate = :statusDate , " +
            "bs.description = :description where bs.statusID = :statusID")
    void update(@Param("statusID") String statusID ,
                @Param("description") String description , @Param("statusDate") String statusDate);


}
