package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.model.BookingStatus;
import SWP391.TattooPlatform.repository.BookingDetailRepository;
import SWP391.TattooPlatform.repository.BookingRepository;
import SWP391.TattooPlatform.model.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    final BookingRepository bookingRepository;
    final BookingDetailRepository bookingDetailRepository;

    final BookingDetailService bookingDetailService;

    public BookingService(BookingRepository bookingRepository, BookingDetailRepository bookingDetailRepository, BookingDetailService bookingDetailService) {
        this.bookingRepository = bookingRepository;
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingDetailService = bookingDetailService;
    }

    public Booking getBookingByID(String bookingID) {
        if(bookingRepository.findBookingByBookingID(bookingID) == null) {
            return null;
        }
        return bookingRepository.findBookingByBookingID(bookingID);
    }

    public List<Booking> findall() {
        return bookingRepository.findAll();
    }



    public Booking findBookingByBookingIDAndArtistEmailAndTattooLoverEmail ( String bookingID,
                                                                           String artistEmail,
                                                                             String tattooLoverEmail) {
        if(bookingRepository.findBookingByBookingIDAndTattooLoverEmail(bookingID,tattooLoverEmail) == null) {
            return  null;

        }
        return bookingRepository.findBookingByBookingIDAndTattooLoverEmail(bookingID,tattooLoverEmail);

    }


    public ResponseEntity<?> addBooking(Booking b, BookingDetail bd) {

        if(bookingRepository.findBookingByBookingID(b.getBookingID()) != null) {
            return ResponseUtils.error("not allow duplicate ID", HttpStatus.BAD_REQUEST);
        }else {
            bookingRepository.save(b);
            bd.setBookingID("1");
            bookingDetailRepository.save(bd);
            bookingDetailRepository.updateBookingDetail(b.getBookingID(), "1");

            return ResponseUtils.get(bookingRepository.findBookingByBookingID(b.getBookingID()),HttpStatus.CREATED);
        }

    }

    public Booking updateBooking(String bookingID,
                                 String tattooLoverEmail, String time, String date,
                                 String customerName, String customerPhoneNumber, float totalPrice) {
        bookingRepository.updateBooking(bookingID,tattooLoverEmail.trim(),time,date,customerName,customerPhoneNumber,totalPrice);
        return bookingRepository.findBookingByBookingID(bookingID);
    }

    public Booking deleteBooking(String bookingID) throws Exception {
        bookingRepository.delete(bookingID);
        if( bookingRepository.findBookingByBookingID(bookingID) == null) {
            return null;
        }else {
            throw new Exception();
        }
    }



}
