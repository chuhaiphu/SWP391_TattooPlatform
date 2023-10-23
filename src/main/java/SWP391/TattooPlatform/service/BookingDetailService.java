package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Booking;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.repository.BookingDetailRepository;
import SWP391.TattooPlatform.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {
    final BookingDetailRepository bookingDetailRepository;
    final BookingRepository bookingRepository;
    public BookingDetailService(BookingDetailRepository bookingDetailRepository, BookingRepository bookingRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingRepository = bookingRepository;
    }




    public ResponseEntity<?> getAllDetail() {
        List<BookingDetail> list = bookingDetailRepository.findAll();
        if(list.isEmpty()) {
            return ResponseUtils.error((RuntimeException) list, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtils.get(list,HttpStatus.OK);
    }
}
