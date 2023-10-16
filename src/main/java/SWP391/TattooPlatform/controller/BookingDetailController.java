package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.service.BookingDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookingDetail")
public class BookingDetailController {
    final BookingDetailService bookingDetailService;
    public BookingDetailController(BookingDetailService bookingDetailService) {
        this.bookingDetailService = bookingDetailService;
    }

    @GetMapping()
    public ResponseEntity<?> listOfDetail() {
        return bookingDetailService.getAllDetail();
    }
}
