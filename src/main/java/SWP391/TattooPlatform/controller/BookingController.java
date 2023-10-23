package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Booking;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.model.BookingRequest;
import SWP391.TattooPlatform.service.BookingService;
import SWP391.TattooPlatform.service.SlotService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {
    final BookingService bookingService;
    final SlotService slotService;

    public BookingController(BookingService bookingService , SlotService slotService) {
        this.bookingService = bookingService;
        this.slotService = slotService;
    }

//    @GetMapping("/{bookingID}")
//    public ResponseEntity<?> getBookingByID(@PathVariable(name = "bookingID") String bookingID) {
//        return ResponseUtils.get(bookingService.getBookingByID(bookingID), HttpStatus.OK);
//    }
//    @GetMapping()
//    public ResponseEntity<?> getBooking() {
//        return ResponseUtils.get(bookingService.findall(), HttpStatus.OK);
//    }
@GetMapping("/list")
public List<Booking> getBookingList(){
    return bookingService.findall();
}
    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/booking.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }
    @GetMapping("get/{tattooLoverEmail}")
    public ResponseEntity<?> getBookingByTattooLoverEmail(@PathVariable String tattooLoverEmail) {
        return bookingService.getBookingByTattooLoverEmail(tattooLoverEmail);
    }

    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody BookingRequest bookingRequest ) {
        Booking booking = bookingRequest.getBooking();
        bookingService.addBooking(booking);
        String id = booking.getBookingID();
        addBookingDetail(bookingRequest.getBookingDetails(),id);
       return  new ResponseEntity<>("Bookings created successfully", HttpStatus.CREATED);
    }


    public void addBookingDetail(@RequestBody List<BookingDetail> bookingDetails, String id ) {
        bookingService.addBookingDetail(bookingDetails,id);



    }

    @PutMapping("/{bookingID}")
    public  ResponseEntity<?> updateBooking(@PathVariable (name = "bookingID") String bookingID,
                                            @RequestParam String tattooLoverEmail
                                           ,  @RequestParam String customerName,
                                            @RequestParam String customerPhoneNumber, @RequestParam float totalPrice){
        return ResponseUtils.get(bookingService.
                updateBooking(bookingID,tattooLoverEmail,customerName,customerPhoneNumber,totalPrice),HttpStatus.OK);
    }

    @DeleteMapping("/{bookingID}")
    public  ResponseEntity<?> deleteBooking(@PathVariable (name = "bookingID") String bookingID) throws Exception{
        return ResponseUtils.get(bookingService.deleteBooking(bookingID),HttpStatus.OK);
    }


}
