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




    @GetMapping()
    public ResponseEntity<?> listOfDetail() {
        return bookingDetailService.getAllDetail();
    }


}
