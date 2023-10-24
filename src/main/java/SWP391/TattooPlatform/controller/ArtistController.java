package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.service.ArtistService;

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
@RequestMapping("/view-artist")
public class ArtistController {



    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }


    //-------------------------------GET-------------------------------
//    @GetMapping("/allArtist")
//    public Object getAllRoles () {
//        return  ResponseUtils.get(artistService.getListArtist(),HttpStatus.OK);
//    }

    @GetMapping("/list")
    public List<Artist> getArtists(){
        return artistService.getListArtist();
    }
    @GetMapping("")
    public String loadServiceHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/view-artist.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }



    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/add-artist")
    public ResponseEntity<?> saveRole(@RequestBody Artist email) {
        return ResponseUtils.get(artistService.addArtist(email), HttpStatus.CREATED);
    }

    //-------------------------------UPDATE/PUT-------------------------------
    @PutMapping("/update-artist/{email}")
    public ResponseEntity<?> updateRole(@PathVariable String email, @RequestParam String fullName,
                                        @RequestParam String phoneNumber, @RequestParam String address) throws Exception {
        return ResponseUtils.get(artistService.updateArtistInformation(email, fullName, phoneNumber, address),HttpStatus.OK);
    }
    @PutMapping("/updateArtistAccount/")
    public ResponseEntity<?> updateRole(@RequestParam String email, @RequestParam String username, @RequestParam String password  ) throws Exception {
        return ResponseUtils.get(artistService.updateArtistAccount(email, username, password),HttpStatus.OK);
    }

    //-------------------------------DELETE-------------------------------
    @DeleteMapping("/deleteArtist/")
    public ResponseEntity<?> deleteRole(@RequestParam String email) throws Exception {
        return ResponseUtils.get(artistService.deleteArtist(email), HttpStatus.OK);
    }
}

