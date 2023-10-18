package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Studio_Certificate;
import SWP391.TattooPlatform.service.Studio_CertificateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/certificate")
public class Studio_CertificateController {
    Studio_CertificateService studioCertificateService;

    public Studio_CertificateController(Studio_CertificateService studioCertificateService) {
        this.studioCertificateService = studioCertificateService;
    }

    @GetMapping()
    public Object getAllCertificates(){
        return ResponseUtils.get(studioCertificateService.getCertificateList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCertificate(@RequestBody Studio_Certificate certificate){
        return ResponseUtils.get(studioCertificateService.addStudioCertificate(certificate), HttpStatus.CREATED);
    }

    @PutMapping("/{certificateId}")
    public ResponseEntity<?> updateCertificate(@RequestParam String newName, @RequestParam String newEmail, @PathVariable String certificateId){
        return ResponseUtils.get(studioCertificateService.updateStudioCertificate(newName, newEmail, certificateId), HttpStatus.OK);
    }

    @DeleteMapping("/{certificateId}")
    public ResponseEntity<?> deleteCertificate(@PathVariable String certificateId) throws Exception {
        return ResponseUtils.get(studioCertificateService.deleteStudioCertificate(certificateId), HttpStatus.OK);
    }
}
