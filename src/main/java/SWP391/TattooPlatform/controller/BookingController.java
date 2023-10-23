package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Booking;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.model.BookingRequest;
import SWP391.TattooPlatform.model.Slot;
import SWP391.TattooPlatform.service.BookingService;
import SWP391.TattooPlatform.service.SlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{bookingID}")
    public ResponseEntity<?> getBookingByID(@PathVariable(name = "bookingID") String bookingID) {
        return bookingService.getBookingData(bookingID);
    }
    @GetMapping()
    public ResponseEntity<?> getBooking() {
        return ResponseUtils.get(bookingService.findall(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody BookingRequest bookingRequest ) {
        Booking booking = bookingRequest.getBooking();
        bookingService.addBooking(booking);
        String id = booking.getBookingID();
        addBookingDetail(bookingRequest.getBookingDetails(),id);

    //    setSlotForBookingDetail(bookingRequest.getDate(), bookingRequest.getStart_time(),"check");

       return  new ResponseEntity<>("Bookings created successfully", HttpStatus.CREATED);
    }

//    public void setSlotForBookingDetail(String date, String startTime, String studioID) {
//        slotService.addNewSlot(date,startTime,studioID);
//    }


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
