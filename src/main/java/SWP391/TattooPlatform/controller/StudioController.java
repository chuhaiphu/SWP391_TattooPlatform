package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.service.StudioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/studio")
public class StudioController {
    final StudioService service;
    public StudioController (StudioService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getALlStudio() {
        return service.findAllStudio();
    }
    @GetMapping("/{serviceName}")
    public ResponseEntity<?> getAllStudioByServiceName(@RequestParam String serviceName) {
        return service.findStudioByServiceName(serviceName);
    }
}
