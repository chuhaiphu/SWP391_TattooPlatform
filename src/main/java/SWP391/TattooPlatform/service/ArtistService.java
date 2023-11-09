package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.repository.ArtistRepository;
import SWP391.TattooPlatform.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ArtistService {
    final ArtistRepository artistRepository;


    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    public List<Artist> getListArtist() {
        if(artistRepository.findAll().isEmpty()) {
            return null;
        }
        return artistRepository.findAll();
    }

    public List<Artist> getAvailableArtistsBySlotIDAndStudioID(String slotID,String studioID) {
        if(artistRepository.findAvailableArtistsBySlotIDAndStudioID(slotID, studioID).isEmpty()) {
            return null;
        }
        return artistRepository.findAvailableArtistsBySlotIDAndStudioID(slotID, studioID);
    }
    public Artist addArtist(Artist artist)
    {
        if(artistRepository.findArtistByEmail(artist.getEmail()) == null){
            return artistRepository.save(artist);
        }
        return null;
    }

    public Artist updateArtistInformation(String email
            , String fullName, String phoneNumber, String address ) throws Exception {

        artistRepository.updateArtist(email, fullName, phoneNumber, address);
        return artistRepository.findArtistByEmail(email);
    }

    public Artist updateArtistAccount(String email, String username, String password){
        artistRepository.updateArtistByUsernameAndPassword(email, username, password);
        return artistRepository.findArtistByEmail(email);
    }
    public Artist deleteArtist(String email) throws Exception{
        artistRepository.deleteArtistByEmail(email);
        Artist artist = artistRepository.findArtistByEmail(email);
        if(artist == null) {
            return null;
        }else {
            throw new Exception();
        }
    }
    public boolean emailExists(String email) {
        // Use your JPA repository to check if an artist with the given email exists
        Artist artist = artistRepository.findArtistByEmail(email);
        return artist != null;
    }

}
