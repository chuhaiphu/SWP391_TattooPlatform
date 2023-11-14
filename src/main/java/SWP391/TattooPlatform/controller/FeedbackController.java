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

    @GetMapping("/allFeedback/{studioID}")
    public Object getAllFeedbackByStudioID(@PathVariable String studioID) {
        return  ResponseUtils.get(feedbackService.findAllFeedbackByStudioID(studioID), HttpStatus.OK);
    }
    @GetMapping("/allFeedback/Artist")
    public Object getAllFeedbackByArtistEmail (@RequestParam String email) {
        return  ResponseUtils.get(feedbackService.getFeedbackListByArtistEmail(email), HttpStatus.OK);
    }

    @GetMapping("/allFeedback/TattooLovers")
    public Object getAllFeedbackByTattooLoverEmail (@RequestParam String email) {
        return  ResponseUtils.get(feedbackService.getFeedbackListByTattooLoverEmail(email), HttpStatus.OK);
    }
    @GetMapping("/allFeedback/BookingDetailID/")
    public Object getFeedbackByDetailID (@RequestParam String id) {
        return  ResponseUtils.get(feedbackService.getFeedbackByBookingDetailID(id), HttpStatus.OK);
    }

    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/addFeedback")
    public ResponseEntity<?> saveRole(@RequestBody Feedback feedback) {
        return ResponseUtils.get(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
    }

}
