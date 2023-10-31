package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Service;
import SWP391.TattooPlatform.service.TattooServiceService;
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
@RequestMapping("/service")
public class TattooServiceController {
    final TattooServiceService tattooService;
    @Autowired
    public TattooServiceController(TattooServiceService tattooServiceService) {
        this.tattooService = tattooServiceService;
    }
//    @GetMapping()
//    public Object getAllService () {
//        return  ResponseUtils.get(tattooService.tattooServiceList(), HttpStatus.OK);
//    }
    @GetMapping("/view-list")
    public List<Service> getServiceList(){
        return tattooService.tattooServiceList();
    }
    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/view-service.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @PostMapping("/add-service")
    public ResponseEntity<?> saveService(@RequestBody Service ts) {
        return ResponseUtils.get(tattooService.addService(ts),HttpStatus.CREATED);
    }

    @PutMapping("/{serviceID}")
    public ResponseEntity<?> updateService(@PathVariable String serviceID,
                                           @RequestParam String serviceName, @RequestParam String description,
                                           @RequestParam float price, @RequestParam String linkImage) throws Exception {
        return ResponseUtils.get(tattooService.updateService(serviceID,serviceName ,description,price,linkImage), HttpStatus.OK);
    }

    @DeleteMapping("/{serviceID}")
    public ResponseEntity<?> deleteService(@PathVariable String serviceID) throws Exception {
        return ResponseUtils.get(tattooService.deleteService(serviceID),HttpStatus.OK);
    }



}
