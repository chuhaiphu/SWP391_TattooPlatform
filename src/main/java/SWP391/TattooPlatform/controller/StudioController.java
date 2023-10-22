package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Studio;
import SWP391.TattooPlatform.service.StudioService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    @GetMapping("/list")
    public List<Studio> getALlStudio() {
        return service.getStudioList();
    }
    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/studio-list.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }
//    @GetMapping("/list")
//    public ResponseEntity<?> getALlStudio() {
//        return service.findAllStudio();
//    }
    @GetMapping("/service/{serviceName}")
    public ResponseEntity<?> getAllStudioByServiceName(@PathVariable String serviceName) {
        return service.findStudioByServiceName(serviceName);
    }
    @GetMapping("/studioID/{studioID}")
    public ResponseEntity<?> getStudioByStudioID(@PathVariable String id) {
        return service.findStudioByID(id);
    }
//    @GetMapping("/view-studio?studioName={studioName}")
//    public ResponseEntity<?> getStudioByName(@PathVariable String studioName){
//
//    }
    @GetMapping("/manager/{email}")
    public ResponseEntity<?> getStudioByEmail(@PathVariable String email) {
        Studio studio = service.findStudioByEmail(email);
        if (studio != null) {
            return ResponseEntity.ok(studio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
