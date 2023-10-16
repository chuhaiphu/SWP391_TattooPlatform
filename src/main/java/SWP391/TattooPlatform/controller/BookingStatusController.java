package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.BookingStatus;
import SWP391.TattooPlatform.service.BookingStatusService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingStatus")
public class BookingStatusController {
    final BookingStatusService bookingStatusService;

    public BookingStatusController(BookingStatusService bookingStatusService) {
        this.bookingStatusService = bookingStatusService;
    }

    @GetMapping()
    public ResponseEntity<?> getBookingStatus() {
        return ResponseUtils.get(bookingStatusService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{statusID}")
    public ResponseEntity<?> getBookingStatusbyID(@PathVariable(name = "statusID") String statusID) {
        return ResponseUtils.get(bookingStatusService.findStatusByStatusID(statusID),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addBookingStatus(@RequestBody BookingStatus bookingStatus) {
        return bookingStatusService.addStatusForBooking(bookingStatus);
    }

    @PutMapping("/{statusID}")
    public ResponseEntity<?> updateBookingStatus(@PathVariable(name = "statusID") String statusID,
                                                 @Param("description") String description,
                                                 @Param("statusDate") String statusDate) {
        return ResponseUtils.get(bookingStatusService.updateStatusForBooking(statusID,description,statusDate),HttpStatus.OK);
    }

}
