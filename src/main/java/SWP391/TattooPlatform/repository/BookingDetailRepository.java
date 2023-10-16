package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface BookingDetailRepository extends JpaRepository<BookingDetail,Long> {

    List<BookingDetail> findAll();

    BookingDetail save(BookingDetail bookingDetail);

    BookingDetail findBookingDetailByBookingDetailID(String bookingDetailID);





}
