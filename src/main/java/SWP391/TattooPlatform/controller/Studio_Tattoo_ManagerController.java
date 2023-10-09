package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
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

    @GetMapping
    public Object getAllManagers () {
        return ResponseUtils.get(studioTattooManagerService.managerList(), HttpStatus.OK);
    }

}
