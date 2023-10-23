package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Studio;
import SWP391.TattooPlatform.service.StudioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/studio")
public class StudioController {
    final StudioService service;
    public StudioController (StudioService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Studio> getALlStudioList() {
        return service.getStudioList();
    }
    @GetMapping("/service-list")
    public List<Studio> getStudioByServiceNameList(@RequestParam String serviceName) {
        return service.getStudioByServiceNameList(serviceName);
    }
    @GetMapping()
    public ResponseEntity<?> getALlStudio() {
        return service.findAllStudio();
    }
    @GetMapping("/{serviceName}")
    public ResponseEntity<?> getAllStudioByServiceName(@RequestParam String serviceName) {
        return service.findStudioByServiceName(serviceName);
    }
    @GetMapping("/name")
    public Studio getServiceByStudioName(@RequestParam String studioName) {
        return service.getStudioByStudioName(studioName);
    }
    @GetMapping("/studioService/{studioID}")
    public ResponseEntity<?> getServiceByStudioID(@PathVariable String studioID) {
        return service.findStudioByID(studioID);
    }
}
