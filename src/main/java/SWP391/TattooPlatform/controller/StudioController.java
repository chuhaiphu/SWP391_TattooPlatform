package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Studio;
import SWP391.TattooPlatform.service.StudioService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RestController
@RequestMapping("/studio")
public class StudioController {
    final StudioService service;
    public StudioController (StudioService service) {
        this.service = service;
    }
    @GetMapping("")
    public String loadStudioHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/studio-list.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @GetMapping("/list")
    public List<Studio> getALlStudio() {
        return service.getStudioList();
    }
//    @GetMapping("/list")
//    public ResponseEntity<?> getALlStudio() {
//        return service.findAllStudio();
//    }

//    @GetMapping("/service")
//    public ResponseEntity<?> getAllStudioByServiceName(@RequestParam String serviceName) {
//        return service.findStudioByServiceName(serviceName);
//    }

    @GetMapping("/{serviceName}")
    public ResponseEntity<?> getAllStudioByServiceName(@RequestParam String serviceName) {
        return service.findStudioByServiceName(serviceName);
    }

    @GetMapping("/id/{studioID}")
    public Studio getStudioByID(@PathVariable String studioID) {
        return service.findStudioByStudioID(studioID);
    }

    @GetMapping("/service-list")
    public List<Studio> getAllStudioByServiceNameList(@RequestParam String serviceName) {
        return service.getStudioByServiceNameList(serviceName);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAllStudioByStudioName(@RequestParam String studioName) {
        return service.findAllStudioByStudioName(studioName);
    }

    @GetMapping("/studioService/{studioID}")
    public ResponseEntity<?> getServiceByStudioID(@PathVariable String studioID) {
        return service.findStudioByID(studioID);
    }
}
