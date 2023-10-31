package SWP391.TattooPlatform.controller;
import SWP391.TattooPlatform.config.*;
import SWP391.TattooPlatform.model.*;
import SWP391.TattooPlatform.repository.*;
import SWP391.TattooPlatform.service.*;
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
@RequestMapping("/tattoolovers")
public class TattooLoversController {
    final TattooLoversService tattooLoversService;
    @Autowired
    public TattooLoversController (TattooLoversService tattooLoversService) {
        this.tattooLoversService = tattooLoversService;
    }
    @GetMapping("/view-list")
    public Object getAllTattoolovers(){
        return ResponseUtils.get(tattooLoversService.getListLovers(),HttpStatus.OK);
    }

    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/view-lover.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveRole(@RequestBody TattooLovers tattooLovers) {
        return ResponseUtils.get(tattooLoversService.addTattooLovers(tattooLovers), HttpStatus.CREATED);
    }
    @PutMapping("/update/{tattooloversemail}")
    public ResponseEntity<?>  updateTattooLovers(@RequestParam String password,
                                                @RequestParam String phonenumber,
                                                 @RequestParam String address,
                                                 @PathVariable String tattooloversemail)    throws Exception {
        return ResponseUtils.get(tattooLoversService.updateTattooLovers(tattooloversemail,password,phonenumber,address),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{tattooloversemail}")
    public ResponseEntity<?> deleteRole(@PathVariable("tattooloversemail") String tattooloversemail) throws Exception {
        return ResponseUtils.get(tattooLoversService.deteleTattooLovers(tattooloversemail), HttpStatus.OK);

    }






}
