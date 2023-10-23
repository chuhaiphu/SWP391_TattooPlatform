package SWP391.TattooPlatform.controller;
import SWP391.TattooPlatform.config.*;
import SWP391.TattooPlatform.model.*;
import SWP391.TattooPlatform.repository.*;
import SWP391.TattooPlatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tattoolovers")
public class TattooLoversController {
    final TattooLoversService tattooLoversService;
    @Autowired
    public TattooLoversController (TattooLoversService tattooLoversService) {
        this.tattooLoversService = tattooLoversService;
    }
    @GetMapping("/all")
    public Object getAllTattoolovers(){
        return ResponseUtils.get(tattooLoversService.getListLovers(),HttpStatus.OK);
    }

    @GetMapping("/{tattooLoverEmail}")
    public ResponseEntity<?> getTattooLoverByEmail(@PathVariable String tattooLoverEmail) {
        return tattooLoversService.getLoverByEmail(tattooLoverEmail);
    }

    @PutMapping("/changePassword/{tattooLoverEmail}")
    public ResponseEntity<?> changePassword(@PathVariable String tattooLoverEmail, @RequestParam String password) {
        return tattooLoversService.changePassword(password,tattooLoverEmail);
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
