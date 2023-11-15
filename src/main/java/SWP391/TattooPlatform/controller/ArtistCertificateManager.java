package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist_Certificate;
import SWP391.TattooPlatform.service.ArtistCertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/artistCertificate")
public class ArtistCertificateManager {


    final ArtistCertificateService artistCertificateService;

    @Autowired
    public ArtistCertificateManager(ArtistCertificateService artistCertificateService) {
        this.artistCertificateService = artistCertificateService;
    }


    @GetMapping("/allCertificates")
    public Object getAllCertificates () {
        return  ResponseUtils.get(artistCertificateService.getListArtistCertificate(),HttpStatus.OK);
    }

    @PostMapping("/addCertificates")
    public ResponseEntity<?> saveCertificate(@RequestBody Artist_Certificate artistCertificate) {
        return ResponseUtils.get(artistCertificateService.addArtistCertificate(artistCertificate), HttpStatus.CREATED);
    }

    @PutMapping("/updateCertificate/{certificateID}")
    public ResponseEntity<?> updateCertificate(@RequestParam String certificateName, @PathVariable String certificateID) throws Exception {
        return ResponseUtils.get(artistCertificateService.updateArtistCertificate(certificateID,certificateName),HttpStatus.OK);
    }

    @DeleteMapping("/deleteCertificate/{certificateID}")
    public ResponseEntity<?> deleteCertificate(@PathVariable("certificateID") String certificateID) throws Exception {
        return ResponseUtils.get(artistCertificateService.deleteArtistCertificates(certificateID), HttpStatus.OK);

    }
    @GetMapping("/checkCertificate")
    public ResponseEntity<?> checkCertificate(
            @RequestParam String certificateName,
            @RequestParam String artistEmail
    ) {
        boolean certificateExists = artistCertificateService.checkCertificate(certificateName, artistEmail);

        Map<String, Object> response = new HashMap<>();
        response.put("exists", certificateExists);

        return ResponseEntity.ok(response);
    }

}