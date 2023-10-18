package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.BookingDetail;
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
public interface BookingDetailRepository extends JpaRepository<BookingDetail,Long> {

    List<BookingDetail> findAll();

    BookingDetail save(BookingDetail bookingDetail);

    BookingDetail findBookingDetailByBookingDetailID(String bookingDetailID);

    @Modifying
    @Transactional
    @Query("UPDATE  BookingDetail b set  b.bookingID = :bookingID where b.bookingDetailID = :bookingDetailID" )

    void updateBookingDetail( String bookingID, String bookingDetailID );





}
