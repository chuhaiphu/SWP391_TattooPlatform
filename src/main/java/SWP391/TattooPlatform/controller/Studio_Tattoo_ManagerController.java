package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import SWP391.TattooPlatform.service.Studio_Tattoo_ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/manager")
public class Studio_Tattoo_ManagerController {

    final Studio_Tattoo_ManagerService studioTattooManagerService;

    public Studio_Tattoo_ManagerController(Studio_Tattoo_ManagerService studioTattooManagerService) {
        this.studioTattooManagerService = studioTattooManagerService;
    }

    @GetMapping()
    public Object getAllManagers () {
        return ResponseUtils.get(studioTattooManagerService.managerList(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addStudioTattooManager(@RequestBody Studio_Tattoo_Manager manager){
        return ResponseUtils.get(studioTattooManagerService.addStudioTattooManager(manager),HttpStatus.CREATED);
    }

    @PutMapping("/{managerEmail}")
    public ResponseEntity<?> updateStudioTattooManager(@PathVariable String managerEmail,
                                                       @RequestParam String newFullName,
                                                       @RequestParam String newPhoneNumber,
                                                       @RequestParam String newStatusID,
                                                       @RequestParam String newSystemStaffEmail,
                                                       @RequestParam String newUsername,
                                                       @RequestParam String newPassword,
                                                       @RequestParam String statusID)throws Exception{
        return ResponseUtils.get(studioTattooManagerService.updateStudioTattooManager(managerEmail, newFullName,newPhoneNumber, newStatusID, newSystemStaffEmail, newUsername, newPassword,statusID), HttpStatus.OK);
    }

    @DeleteMapping("/{managerEmail}")
    public ResponseEntity<?> deleteStudioTattooManager(@PathVariable String managerEmail)throws Exception{
        return ResponseUtils.get(studioTattooManagerService.deleteStudioTattooManager(managerEmail),HttpStatus.OK);
    }
}
