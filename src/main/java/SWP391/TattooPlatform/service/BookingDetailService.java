package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.*;
import SWP391.TattooPlatform.repository.*;
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
    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;

    final TattooServiceRepository tattooServiceRepository;

    final FeedbackRepository feedbackRepository;
    public BookingDetailService(BookingDetailRepository bookingDetailRepository, BookingRepository bookingRepository
                                , StudioRepository studioRepository , FeedbackRepository feedbackRepository , Studio_Tattoo_ManagerRepository studioTattooManagerRepository
                                ,TattooServiceRepository tattooServiceRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingRepository = bookingRepository;
        this.studioRepository = studioRepository;
        this.feedbackRepository = feedbackRepository;
        this.studioTattooManagerRepository = studioTattooManagerRepository;
        this.tattooServiceRepository = tattooServiceRepository;

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

    public ResponseEntity<?> getBookingDetailByManagerEmail(String email) {
       List<SWP391.TattooPlatform.model.Service> serviceList = tattooServiceRepository.findServicesByTattooManagerEmail(email);
        List<BookingDetail> list = new ArrayList<>();
        if(serviceList == null) {
            return ResponseUtils.error("asd",HttpStatus.BAD_REQUEST);
        }
        for(SWP391.TattooPlatform.model.Service se : serviceList) {
            List<BookingDetail> b = bookingDetailRepository.findBookingDetailsByServiceID(se.getServiceID());
            if(b != null) {
                list.addAll(b);
            }
        }

        return ResponseUtils.get(list,HttpStatus.OK);
    }


    public ResponseEntity<?> getBookingDetailByBookingDetailID(String id) {
        BookingDetail bookingDetail = bookingDetailRepository.findBookingDetailByBookingDetailID(id);
        if(bookingDetail != null) {
            return ResponseUtils.get(bookingDetail, HttpStatus.OK);
        }
        return new ResponseEntity("Not found any booking detail ", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<?> getBookingDetailByArtistEmail(String email) {
            List<BookingDetail> bookingDetails = bookingDetailRepository.findBookingDetailsByArtistEmail(email);

            for(BookingDetail bookingDetail : bookingDetails) {
                bookingDetail.getSlot().getDate();
            }
            if(bookingDetails != null) {
                return ResponseUtils.get(bookingDetails, HttpStatus.OK);
            }
        return new ResponseEntity("Not found any booking detail ", HttpStatus.NOT_FOUND);
    }




    public ResponseEntity<?> getAllDetail() {
        List<BookingDetail> list = bookingDetailRepository.findAll();
        if(list.isEmpty()) {
            return ResponseUtils.error((RuntimeException) list, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtils.get(list,HttpStatus.OK);
    }
}
