package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.repository.ArtistRepository;
import SWP391.TattooPlatform.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

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

}
