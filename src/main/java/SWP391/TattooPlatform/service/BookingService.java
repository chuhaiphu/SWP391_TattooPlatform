package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.*;
import SWP391.TattooPlatform.repository.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    final BookingRepository bookingRepository;
    final BookingDetailRepository bookingDetailRepository;



    final BookingStatusRepository bookingStatusRepository;
    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;

    final VoucherRepository voucherRepository;

    final TattooServiceRepository tattooServiceRepository;

    final SlotRepository slotRepository;

    public BookingService(BookingRepository bookingRepository, BookingDetailRepository bookingDetailRepository,
                          BookingStatusRepository bookingStatusRepository, VoucherRepository voucherRepository, SlotRepository slotRepository,
                          Studio_Tattoo_ManagerRepository studioTattooManagerRepository, TattooServiceRepository tattooServiceRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingStatusRepository = bookingStatusRepository;
        this.voucherRepository = voucherRepository;
        this.slotRepository = slotRepository;
        this.studioTattooManagerRepository = studioTattooManagerRepository;
        this.tattooServiceRepository = tattooServiceRepository;
    }


    public List<Booking> findall() {
        return bookingRepository.findAll();
    }

//    public ResponseEntity<?> getBookingByTattooLoverEmail(String email) {
//        List<Booking> bookingList = bookingRepository.findBookingByTattooLoverEmail(email);
//        if(bookingList.isEmpty()) {
//            return ResponseUtils.error(new RuntimeException(),HttpStatus.BAD_REQUEST);
//        }
//        return ResponseUtils.get(bookingList,HttpStatus.OK);
//    }

    public List<Booking> getBookingByTattooLoverEmail(String email) {
        List<Booking> bookingList = bookingRepository.findBookingByTattooLoverEmail(email);
            return bookingList;
    }
//    public ResponseEntity<?> getBookingData(String id) {
//        Booking booking = bookingRepository.findBookingByBookingID(id);
//        List<BookingDetail> bookingDetails = new ArrayList<>();
//        for(BookingDetail b : bookingDetailRepository.findAll()) {
//            if(b.getBookingID().equals(id)) {
//                bookingDetails.add(b);
//            }
//        }
//        return ResponseUtils.get(new BookingRequest(booking,bookingDetails),HttpStatus.OK);
//    }
    public Booking getBookingByID(String bookingID) {
        if(bookingRepository.findBookingByBookingID(bookingID) == null) {
            return null;
        }
        return bookingRepository.findBookingByBookingID(bookingID);
    }


    public ResponseEntity<?> getBookingByStudioManagerEmail(String email) {
        Studio_Tattoo_Manager studioTattooManager = studioTattooManagerRepository.findStudio_Tattoo_ManagerByStudioManagerEmail(email);
        if(studioTattooManager == null) {
            return ResponseUtils.error("Not find this manager", HttpStatus.NOT_FOUND);
        }else{
            List<SWP391.TattooPlatform.model.Service> serviceList = tattooServiceRepository.findServicesByTattooManagerEmail(email);
            List<BookingDetail> listDetail = new ArrayList<>();
            for(SWP391.TattooPlatform.model.Service service : serviceList) {
                List<BookingDetail> bookingDetails = bookingDetailRepository.findBookingDetailsByServiceID(service.getServiceID());
                if(bookingDetails != null) {
                    listDetail.addAll(bookingDetails);
                }
            }
            List<Booking> bookingList = new ArrayList<>();
            Set<String> uniqueBookingIds = new HashSet<>();

            for (BookingDetail bookingDetail : listDetail) {
                String bookingId = bookingDetail.getBookingID();

                if (!uniqueBookingIds.contains(bookingId)) {
                    uniqueBookingIds.add(bookingId);
                    bookingList.add(bookingRepository.findBookingByBookingID(bookingId));
                }
            }

            return ResponseUtils.get(bookingList,HttpStatus.OK);


//            List<Booking> bookingList = new ArrayList<>();
//            for(int i = 0 ; i< listDetail.size(); i++) {
//                boolean bookindIdexist = false;
//                for(int j = 0 ; j <= i;j++) {
//                    if(listDetail.get(j).getBookingID().equals(listDetail.get(i).getBookingID())) {
//                        bookindIdexist = true;
//                        break;
//                    }
//                }
//                if(!bookindIdexist) {
//                    bookingList.add(bookingRepository.)
//                }
//            }

        }


    }
    public Booking findBookingByBookingIDAndArtistEmailAndTattooLoverEmail ( String bookingID,
                                                                           String artistEmail,
                                                                             String tattooLoverEmail) {
        if(bookingRepository.findBookingByBookingIDAndTattooLoverEmail(bookingID,tattooLoverEmail) == null) {
            return  null;

        }
        return bookingRepository.findBookingByBookingIDAndTattooLoverEmail(bookingID,tattooLoverEmail);

    }


    public Booking addBooking(Booking b) {
            b.setTotalPrice((float) 0);
            bookingRepository.save(b);
            return b;
        }

    public void addBookingDetail( List<BookingDetail> bookingDetails , String id) {
        float totalPrice = 0;
        BookingStatus status = bookingStatusRepository.findBookingStatusByStatusName("Pending");
        for(BookingDetail bookingDetail : bookingDetails) {

            bookingDetail.setBookingID(id);
            bookingDetail.setStatusID(status.getStatusID());

            slotRepository.updateSlotStatus(bookingDetail.getSlotID(),1);


            if(bookingDetail.getVoucherID()!=null) {
                Voucher voucher = voucherRepository.findVoucherByVoucherID(bookingDetail.getVoucherID());
                float actualPrice = (bookingDetail.getPrice()*(100 - voucher.getDiscount()))/100;
                bookingDetail.setPrice(actualPrice);
            }
            bookingDetailRepository.save(bookingDetail);
            totalPrice += bookingDetail.getPrice();

        }
//        Booking booking = bookingRepository.findBookingByBookingID(id);
        bookingRepository.updatePrice(totalPrice,id);
        bookingRepository.deleteWhenPrice0();


    }

    public Booking updateBooking(String bookingID,
                                 String tattooLoverEmail,
                                 String customerName, String customerPhoneNumber, float totalPrice) {
        bookingRepository.updateBooking(bookingID,tattooLoverEmail.trim(),customerName,customerPhoneNumber,totalPrice);
        return bookingRepository.findBookingByBookingID(bookingID);
    }

    public Booking deleteBooking(String bookingID) throws Exception {
        bookingRepository.delete(bookingID);
        if( bookingRepository.findBookingByBookingID(bookingID) == null) {
            return null;
        }else {
            throw new Exception();
        }
    }



}
