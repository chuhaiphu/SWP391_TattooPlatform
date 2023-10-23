package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.BookingStatus;
import SWP391.TattooPlatform.repository.BookingStatusRepository;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingStatusService {
    final BookingStatusRepository bookingStatusRepository;

    public BookingStatusService (BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    public BookingStatus findStatusByStatusID(String statusID) {
        return bookingStatusRepository.findBookingStatusByStatusID(statusID);
    }

    public List<BookingStatus> findAll() {
        return bookingStatusRepository.findAll();
    }

    public ResponseEntity<?> addStatusForBooking(BookingStatus bookingStatus)  {
        if(bookingStatusRepository.findBookingStatusByStatusID(bookingStatus.getStatusID()) == null) {
            return ResponseUtils.get(bookingStatusRepository.save(bookingStatus),HttpStatus.CREATED);
        }
        return ResponseUtils.error("Not allow duplicate", HttpStatus.BAD_REQUEST);


    }


}
