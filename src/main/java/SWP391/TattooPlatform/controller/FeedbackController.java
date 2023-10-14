package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.service.ArtistService;
import SWP391.TattooPlatform.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    //-------------------------------GET-------------------------------
    @GetMapping("/allFeedback")
    public Object getAllFeedback () {
        return  ResponseUtils.get(feedbackService.getFeedbackList(), HttpStatus.OK);
    }

    @GetMapping("/allFeedback/Artist/{artistEmail}")
    public Object getAllFeedbackByArtistEmail (@PathVariable String email) {
        return  ResponseUtils.get(feedbackService.getFeedbackListByArtistEmail(email), HttpStatus.OK);
    }

    @GetMapping("/allFeedback/TattooLovers/{tattooLoverEmail}")
    public Object getAllFeedbackByTattooLoverEmail (@PathVariable String email) {
        return  ResponseUtils.get(feedbackService.getFeedbackListByTattooLoverEmail(email), HttpStatus.OK);
    }

    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/addFeedback")
    public ResponseEntity<?> saveRole(@RequestBody Feedback feedback) {
        return ResponseUtils.get(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
    }

}
