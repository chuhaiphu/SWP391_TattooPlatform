package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.service.BookingDetailService;
import SWP391.TattooPlatform.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingDetail")
public class BookingDetailController {
    final BookingDetailService bookingDetailService;
    final BookingService bookingService;

    public BookingDetailController(BookingDetailService bookingDetailService, BookingService bookingService) {
        this.bookingDetailService = bookingDetailService;
        this.bookingService = bookingService;
    }

//    @GetMapping("/{bookingID}")
//    public ResponseEntity<?> getBookingDetailByBookingID(@PathVariable String bookingID) {
//        return bookingDetailService.getBookingDetailByBookingID(bookingID);
//    }
    @GetMapping("/get/{bookingDetailID}")
    public ResponseEntity<?> getBookingDetailByBookingDetailID(@PathVariable String bookingDetailID) {
        return bookingDetailService.getBookingDetailByBookingDetailID(bookingDetailID);
    }

    @GetMapping("/{bookingID}")
    public List<BookingDetail> getBookingDetailByBookingID(@PathVariable String bookingID) {
        return bookingDetailService.getBookingDetailByBookingID(bookingID);
    }

    @GetMapping("/studio/{bookingDetailId}")
    public ResponseEntity<?> getStudioByBookingDetailID(@PathVariable String bookingDetailId) {
        return bookingDetailService.getStudioByBookingDetailID(bookingDetailId);
    }

    @GetMapping()
    public ResponseEntity<?> listOfDetail() {
        return bookingDetailService.getAllDetail();
    }
    @PutMapping("/updateStatus/{bookingDetailID}")
    public  ResponseEntity<?> updateStatus(@PathVariable String bookingDetailID, @RequestParam String statusID) throws Exception {
        return ResponseUtils.get(bookingDetailService.updateStatus(bookingDetailID, statusID), HttpStatus.OK);
    }

}
