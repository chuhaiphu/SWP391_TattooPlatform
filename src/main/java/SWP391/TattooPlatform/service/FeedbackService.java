package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
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
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbackListByArtistEmail(String email){
        if(feedbackRepository.findAllByArtistEmail(email).isEmpty()) {
            return null;
        }
        return feedbackRepository.findAllByArtistEmail(email);
    }
    public List<Feedback> getFeedbackListByTattooLoverEmail(String email){
        if(feedbackRepository.findAllByTattooLoverEmail(email).isEmpty()) {
            return null;
        }
        return feedbackRepository.findAllByTattooLoverEmail(email);
    }
    //    public Artist updateArtistRating(String email) {
//
//        if (email != null) {
//            List<Feedback> feedbackList = feedbackRepository.findAllByArtistEmail(email);
//
//            if (!feedbackList.isEmpty()) {
//                float totalRating = feedbackList.stream().mapToDouble(Feedback::getRating).sum();
//                float averageRating = totalRating / feedbackList.size();
//                artistRepository.updateArtistByRate(email, averageRating);
//            }
//        } else {
//            return null;
//        }
//        return artistRepository.findArtistByEmail(email);
//    }
//    public Feedback deleteArtist(String email) throws Exception{
//        artistRepository.deleteArtistByEmail(email);
//        Artist artist = artistRepository.findArtistByEmail(email);
//        if(artist == null) {
//            return null;
//        }else {
//            throw new Exception();
//        }
//    }

}
