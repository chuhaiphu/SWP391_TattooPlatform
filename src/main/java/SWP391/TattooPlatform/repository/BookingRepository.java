package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Booking;
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
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAll();




    Booking findBookingByBookingID(@Param("bookingID") String bookingID);



    Booking findBookingByBookingIDAndTattooLoverEmail (@Param("bookingID") String bookingID,
                                                                     @Param("tattooLoverEmail") String tattooLoverEmail);


    Booking save(Booking booking);

    @Modifying
    @Transactional
    @Query("UPDATE  Booking b set " +
            "b.tattooLoverEmail = :tattooLoverEmail," +
            "b.customerName = :customerName," +
            "b.customerPhoneNumber = :customerPhoneNumber," +
            "b.totalPrice = :totalPrice" +
            " where " +
            " b.bookingID = :bookingID" )
    void updateBooking(@Param("bookingID") String bookingID,
                       @Param("tattooLoverEmail") String tattooLoverEmail,
                       @Param("customerName") String customerName,
                       @Param("customerPhoneNumber") String customerPhoneNumber,
                       @Param("totalPrice") float totalPrice
                   );


    @Modifying
    @Transactional
    @Query("delete from Booking b where b.bookingID = :bookingID")
    void delete(@Param("bookingID") String bookingID);
}


