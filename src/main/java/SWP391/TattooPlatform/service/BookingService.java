package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.repository.BookingRepository;
import SWP391.TattooPlatform.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
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
        if(bookingRepository.findBookingByBookingIDAndArtistEmailAndTattooLoverEmail(bookingID,artistEmail,tattooLoverEmail) == null) {
            return  null;

        }
        return bookingRepository.findBookingByBookingIDAndArtistEmailAndTattooLoverEmail(bookingID,artistEmail,tattooLoverEmail);

    }

    public Booking addBooking(Booking b) {
        return bookingRepository.save(b);
    }

    public Booking updateBooking(String bookingID, String artistEmail,
                                 String tattooLoverEmail, String time, String date,
                                 String customerName, String customerPhoneNumber, float totalPrice) {
        bookingRepository.updateBooking(bookingID,artistEmail.trim(),tattooLoverEmail.trim(),time,date,customerName,customerPhoneNumber,totalPrice);
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
