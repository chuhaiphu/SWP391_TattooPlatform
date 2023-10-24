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

@RestController
@RequestMapping("/tattoolovers")
public class TattooLoversController {
    final TattooLoversService tattooLoversService;
    @Autowired
    public TattooLoversController (TattooLoversService tattooLoversService) {
        this.tattooLoversService = tattooLoversService;
    }

    @GetMapping()
    public String loadLoginHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/my-account.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @GetMapping("/all")
    public Object getAllTattoolovers(){
        return ResponseUtils.get(tattooLoversService.getListLovers(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveRole(@RequestBody TattooLovers tattooLovers) {
        return ResponseUtils.get(tattooLoversService.addTattooLovers(tattooLovers), HttpStatus.CREATED);
    }

//    @PutMapping("/update/{tattooLoverEmail}")
//    public ResponseEntity<?>  updateTattooLovers(@PathVariable String tattooLoverEmail,
//                                                @RequestParam String username,
//                                                 @RequestParam String fullname,
//                                                @RequestParam String password,
//                                                @RequestParam String phonenumber,
//                                                 @RequestParam String address)    throws Exception {
//        return ResponseUtils.get(tattooLoversService.updateTattooLovers(tattooLoverEmail, username, fullname, password, phonenumber, address),HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<?>  updateTattooLovers(@RequestBody TattooLovers tattooLovers) throws Exception {
        return ResponseUtils.get(tattooLoversService.updateTattooLovers(tattooLovers),HttpStatus.OK);
    }

    @GetMapping("/{tattooLoverEmail}")
    public ResponseEntity<?> getTattooLoverByEmail(@PathVariable String tattooLoverEmail) {
        return tattooLoversService.getLoverByEmail(tattooLoverEmail);
    }

    @DeleteMapping("/delete/{tattooloversemail}")
    public ResponseEntity<?> deleteRole(@PathVariable("tattooloversemail") String tattooloversemail) throws Exception {
        return ResponseUtils.get(tattooLoversService.deteleTattooLovers(tattooloversemail), HttpStatus.OK);

    }






}
