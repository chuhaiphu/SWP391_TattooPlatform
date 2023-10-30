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


    @GetMapping("/{serviceName}")
    public ResponseEntity<?> getAllStudioByServiceName(@PathVariable String serviceName) {
        return service.findStudioByServiceName(serviceName);
    }

    @GetMapping("/name/{studioName}")
    public ResponseEntity<?> getAllStudioByStudioName(@PathVariable String studioName) {
        return service.findAllStudioByStudioName(studioName);
    }



    @GetMapping("/id/{studioID}")
    public Studio getStudioByID(@PathVariable String studioID) {
        return service.findStudioByStudioID(studioID);
    }
    @GetMapping("/service-list")
    public List<Studio> getAllStudioByServiceNameList(@RequestParam String serviceName) {
        return service.getStudioByServiceNameList(serviceName);
    }
    @GetMapping("/studioService/{studioID}")
    public ResponseEntity<?> getServiceByStudioID(@PathVariable String studioID) {
        return service.findStudioByID(studioID);
    }
}
