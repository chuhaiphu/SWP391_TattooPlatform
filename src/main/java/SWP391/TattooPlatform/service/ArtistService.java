package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.repository.ArtistRepository;
import SWP391.TattooPlatform.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

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

    public Artist addArtist(Artist artist)
    {
        return artistRepository.save(artist);
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
    public Artist updateArtistRating(String email, FeedbackRepository feedbackRepository) {

        if (email != null) {
            List<Feedback> feedbackList = feedbackRepository.findAllByArtistEmail(email);

            if (!feedbackList.isEmpty()) {
                double totalRating = feedbackList.stream().mapToDouble(Feedback::getRating).sum();
                double averageRating = totalRating / feedbackList.size();
                artistRepository.updateArtistByRate(email, (float) averageRating);
            }
        } else {
            return null;
        }
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

}
