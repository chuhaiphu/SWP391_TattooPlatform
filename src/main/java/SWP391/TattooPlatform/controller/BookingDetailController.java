package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.service.BookingDetailService;
import SWP391.TattooPlatform.service.BookingService;
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

    @GetMapping("/studio/{bookingDetailId}")
    public ResponseEntity<?> getStudioByBookingDetailID(@PathVariable String bookingDetailId) {
        return bookingDetailService.getStudioByBookingDetailID(bookingDetailId);
    }


    @GetMapping("/{bookingID}")
    public List<BookingDetail> getBookingDetailByBookingID(@PathVariable String bookingID) {
        return bookingDetailService.getBookingDetailByBookingID(bookingID);
    }

    @GetMapping("/listAll/{email}")
    public  ResponseEntity<?> getBookingDetailByManagerEmail(@PathVariable String email) {
        return bookingDetailService.getBookingDetailByManagerEmail(email);
    }

    @GetMapping("/list/{email}")
    public  ResponseEntity<?> getBookingDetailByArtistEmail(@PathVariable String email) {
        return bookingDetailService.getBookingDetailByArtistEmail(email);
    }

    @GetMapping("/get/{bookingDetailID}")
    public ResponseEntity<?> getBookingDetailByBookingDetailID(@PathVariable String bookingDetailID) {
        return bookingDetailService.getBookingDetailByBookingDetailID(bookingDetailID);
    }


    @GetMapping()
    public ResponseEntity<?> listOfDetail() {
        return bookingDetailService.getAllDetail();
    }


}
