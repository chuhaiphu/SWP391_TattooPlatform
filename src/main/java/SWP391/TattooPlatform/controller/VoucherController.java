package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.model.Voucher;
import SWP391.TattooPlatform.service.FeedbackService;
import SWP391.TattooPlatform.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping( "/vouchers")
public class VoucherController {
    final VoucherService voucherService;

    @Autowired
    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }


    //-------------------------------GET-------------------------------
    @GetMapping("/list")
    public Object getAllFeedback () {
        return  ResponseUtils.get(voucherService.getVoucherList(), HttpStatus.OK);
    }

    @GetMapping("/allVoucher/startDate/{date}")
    public Object getAllFeedbackByArtistEmail (@PathVariable String date) {
        return  ResponseUtils.get(voucherService.getVoucherListByStartDate(date), HttpStatus.OK);
    }
    @GetMapping("/checkVoucher")
    public ResponseEntity<String> checkVoucher(@RequestParam String voucherCode) {
        Voucher voucher = voucherService.getVoucherByVoucherID(voucherCode);
        if (voucher == null) {
            return new ResponseEntity<>("Voucher not found", HttpStatus.NOT_FOUND);
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = LocalDate.parse(voucher.getEndDate());
        if (currentDate.isAfter(endDate)) {
            return new ResponseEntity<>("Voucher has expired", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Voucher is valid");
    }
    @GetMapping("/allFeedback/endDate/{date}")
    public Object getAllFeedbackByTattooLoverEmail (@PathVariable String date) {
        return  ResponseUtils.get(voucherService.getVoucherListByEndDate(date), HttpStatus.OK);
    }

    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/add-voucher")
    public ResponseEntity<?> saveRole(@RequestBody Voucher voucher) {
        return ResponseUtils.get(voucherService.addVoucher(voucher), HttpStatus.CREATED);
    }
}
