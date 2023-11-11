package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Booking;
import SWP391.TattooPlatform.model.BookingDetail;
import SWP391.TattooPlatform.model.Studio;
import SWP391.TattooPlatform.repository.BookingDetailRepository;
import SWP391.TattooPlatform.repository.BookingRepository;
import SWP391.TattooPlatform.repository.StudioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingDetailService {
    final BookingDetailRepository bookingDetailRepository;
    final BookingRepository bookingRepository;

    final StudioRepository studioRepository;
    public BookingDetailService(BookingDetailRepository bookingDetailRepository, BookingRepository bookingRepository
                                , StudioRepository studioRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingRepository = bookingRepository;
        this.studioRepository = studioRepository;

    }

//    public ResponseEntity<?> getBookingDetailByBookingID(String id) {
//        List<BookingDetail> bookingDetails = new ArrayList<>();
//        for(BookingDetail b : bookingDetailRepository.findAll()) {
//            if(b.getBookingID().equals(id)) {
//                bookingDetails.add(b);
//            }
//        }
//        return ResponseUtils.get(bookingDetails,HttpStatus.OK);
//    }


    public ResponseEntity<?> getStudioByBookingDetailID(String bookingDetailID) {
        BookingDetail bookingDetail = bookingDetailRepository.findBookingDetailByBookingDetailID(bookingDetailID);
        if(bookingDetail != null) {
            Studio studio = studioRepository.findStudioByStudioID(bookingDetail.getSlot().getStudioID());
            return ResponseUtils.get(studio,HttpStatus.OK);
        }
        return ResponseUtils.error("Not found studio",HttpStatus.NOT_FOUND);

    }
    public List<BookingDetail> getBookingDetailByBookingID(String id) {
        List<BookingDetail> bookingDetails = new ArrayList<>();
        for(BookingDetail b : bookingDetailRepository.findAll()) {
            if(b.getBookingID().equals(id)) {
                bookingDetails.add(b);
            }
        }
        return bookingDetails;
    }


    public ResponseEntity<?> getAllDetail() {
        List<BookingDetail> list = bookingDetailRepository.findAll();
        if(list.isEmpty()) {
            return ResponseUtils.error((RuntimeException) list, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtils.get(list,HttpStatus.OK);
    }
}
