package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Booking;
import SWP391.TattooPlatform.model.Service;
import SWP391.TattooPlatform.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/booking")
public class BookingController {
    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{bookingID}")
    public ResponseEntity<?> getBookingByID(@PathVariable(name = "bookingID") String bookingID) {
        return ResponseUtils.get(bookingService.getBookingByID(bookingID), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> getBooking() {
        return ResponseUtils.get(bookingService.findall(), HttpStatus.OK);
    }


    @GetMapping(" /{bookingID}&{tattooLoverEmail}&{artistEmail} ")
    public ResponseEntity<?> getBookingByAll(@PathVariable(name = "tattooLovetEmail")  String tattooLoverEmail,
                                             @PathVariable(name = "artistEmail") String artistEmail ,
                                             @PathVariable (name = "bookingID") String bookingID) {
        return ResponseUtils.get(bookingService.
                findBookingByBookingIDAndArtistEmailAndTattooLoverEmail(bookingID,artistEmail,tattooLoverEmail),HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        return ResponseUtils.get(bookingService.addBooking(booking) , HttpStatus.CREATED);
    }

    @PutMapping("/{bookingID}")
    public  ResponseEntity<?> updateBooking(@PathVariable (name = "bookingID") String bookingID, @RequestParam String artistEmail,
                                            @RequestParam String tattooLoverEmail, @RequestParam String time ,
                                            @RequestParam String date,  @RequestParam String customerName,
                                            @RequestParam String customerPhoneNumber, @RequestParam float totalPrice){
        return ResponseUtils.get(bookingService.
                updateBooking(bookingID,artistEmail,tattooLoverEmail,time,date,customerName,customerPhoneNumber,totalPrice),HttpStatus.OK);
    }

    @DeleteMapping("/{bookingID}")
    public  ResponseEntity<?> deleteBooking(@PathVariable (name = "bookingID") String bookingID) throws Exception{
        return ResponseUtils.get(bookingService.deleteBooking(bookingID),HttpStatus.OK);
    }


}
