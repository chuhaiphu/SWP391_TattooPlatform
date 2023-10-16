package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.repository.BookingDetailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {
    final BookingDetailRepository bookingDetailRepository;
    public BookingDetailService(BookingDetailRepository bookingDetailRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
    }

    public ResponseEntity<?> getAllDetail() {
        List<BookingDetail> list = bookingDetailRepository.findAll();
        if(list.isEmpty()) {
            return ResponseUtils.error((RuntimeException) list, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtils.get(list,HttpStatus.OK);
    }
}
