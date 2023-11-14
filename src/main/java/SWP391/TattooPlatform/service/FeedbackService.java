package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.repository.ArtistRepository;
import SWP391.TattooPlatform.repository.FeedbackRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class FeedbackService {

    final ArtistRepository artistRepository;
    final FeedbackRepository feedbackRepository;

    public FeedbackService(ArtistRepository artistRepository, FeedbackRepository feedbackRepository) {
        this.artistRepository = artistRepository;
        this.feedbackRepository = feedbackRepository;
    }


    public List<Feedback> getFeedbackList() {
        if(feedbackRepository.findAll().isEmpty()) {
            return null;
        }
        return feedbackRepository.findAll();
    }

    public Feedback addFeedback(Feedback feedback)
    {
        Artist artist = artistRepository.findArtistByEmail(feedback.getArtistEmail());
        float newRating = feedback.getArtistRating();
        float totalRatings = artist.getRate() + newRating;
        int numberOfRatings = artist.getNumberOfRatings() + 1;
        float averageRating = totalRatings / numberOfRatings;
        artist.setRate(averageRating);
        artist.setNumberOfRatings(numberOfRatings);
        artistRepository.save(artist);
        return feedbackRepository.save(feedback);
    }
    public List<Feedback> findAllFeedbackByStudioID(String id){
        if(feedbackRepository.findAllFeedbackByStudioID(id) == null){
            return Collections.emptyList();
        }
        return feedbackRepository.findAllFeedbackByStudioID(id);
    }
    public List<Feedback> getFeedbackListByArtistEmail(String email){
        if(feedbackRepository.findAllByArtistEmail(email).isEmpty()) {
            return null;
        }
        return feedbackRepository.findAllByArtistEmail(email);
    }
    public Feedback getFeedbackByBookingDetailID(String id) {
        if (feedbackRepository.findByBookingDetailID(id) == null) {
            return null;
        }
        return feedbackRepository.findByBookingDetailID(id);
    }

    public void updateFeedback(String id, String description, int artistRating) {
        Feedback f = feedbackRepository.findByFeedbackID(id);
        Artist artist = artistRepository.findArtistByEmail(f.getArtistEmail());
        float rateF =  f.getArtistRating();
        if (artist != null) {
            float rate = artist.getRate();
            int n = artist.getNumberOfRatings();
            float finalRate = (rate*n - rateF +  artistRating)/n ;
            artist.setRate(finalRate);
            artistRepository.save(artist);
        }
        feedbackRepository.update(id, description, artistRating);


    }

    public ResponseEntity<?> getFeedbackByFeedbackID(String id) {
        Feedback f = feedbackRepository.findByFeedbackID(id);
        if(f != null) {
            return ResponseUtils.get(f,HttpStatus.OK);
        }
        return ResponseUtils.error("not found this Feedback",HttpStatus.NOT_FOUND);
    }



}
