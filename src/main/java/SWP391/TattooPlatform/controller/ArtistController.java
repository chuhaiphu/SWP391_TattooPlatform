package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.service.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/artist")
public class ArtistController {



    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }


    //-------------------------------GET-------------------------------
    @GetMapping("/allArtist")
    public Object getAllRoles () {
        return  ResponseUtils.get(artistService.getListArtist(),HttpStatus.OK);
    }

    @GetMapping("/allArtist/{studioID}")
    public Object getAllArtistByStudioID (@PathVariable String studioID) {
        return  ResponseUtils.get(artistService.findAllArtistByStudioID(studioID),HttpStatus.OK);
    }
    @GetMapping("/available/{studioID}/{slotID}")
    public Object getAvailableArtistsBySlotID (@PathVariable String slotID,@PathVariable String studioID ) {
        return  ResponseUtils.get(artistService.getAvailableArtistsBySlotIDAndStudioID(slotID, studioID),HttpStatus.OK);
    }

    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/addArtist")
    public ResponseEntity<?> saveRole(@RequestBody Artist email) {
        return ResponseUtils.get(artistService.addArtist(email), HttpStatus.CREATED);
    }

    //-------------------------------UPDATE/PUT-------------------------------
    @PutMapping("/updateArtistInfomation/")
    public ResponseEntity<?> updateRole(@RequestParam String email, @RequestParam String fullName,
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
