package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Voucher;
import SWP391.TattooPlatform.service.EmailService;
import SWP391.TattooPlatform.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping( "/vouchers")
public class VoucherController {
    final VoucherService voucherService;
    final EmailService emailService;

    @Autowired
    public VoucherController(VoucherService voucherService, EmailService emailService) {
        this.voucherService = voucherService;
        this.emailService = emailService;
    }


    //-------------------------------GET-------------------------------
    @GetMapping("/allVoucher")
    public Object getAllFeedback () {
        return  ResponseUtils.get(voucherService.getVoucherList(), HttpStatus.OK);
    }

    @GetMapping("/allVoucher/startDate/{date}")
    public Object getAllFeedbackByArtistEmail (@PathVariable String date) {
        return  ResponseUtils.get(voucherService.getVoucherListByStartDate(date), HttpStatus.OK);
    }



    @GetMapping("/send-email")
    public String sendEmail(    // Different "from" email address
                                @RequestParam String to,
                                @RequestParam(required = false) String [] cc,
                                @RequestParam String subject,
                                @RequestParam String body)  {
        return emailService.sendEmail(to,cc,subject,body);
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
    @PostMapping("/addVoucher")
    public ResponseEntity<?> saveRole(@RequestBody Voucher voucher) {
        return ResponseUtils.get(voucherService.addVoucher(voucher), HttpStatus.CREATED);
    }
}
