package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Voucher;
import SWP391.TattooPlatform.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping( "/vouchers")
public class VoucherController {
    final VoucherService voucherService;

    @Autowired
    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }


    //-------------------------------GET-------------------------------
//    @GetMapping("/allVoucher")
//    public Object getAllFeedback () {
//        return  ResponseUtils.get(voucherService.getVoucherList(), HttpStatus.OK);
//    }
    @GetMapping("/view-list")
    public List <Voucher> voucherList(){
        return voucherService.getVoucherList();
    }
    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/view-voucher.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @GetMapping("/allVoucher/startDate/{date}")
    public Object getAllFeedbackByArtistEmail (@PathVariable String date) {
        return  ResponseUtils.get(voucherService.getVoucherListByStartDate(date), HttpStatus.OK);
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
