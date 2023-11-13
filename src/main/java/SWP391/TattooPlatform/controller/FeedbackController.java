package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.service.ArtistService;
import SWP391.TattooPlatform.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    //-------------------------------GET-------------------------------
    @GetMapping("")
    public String loadBookingPageHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/feedback.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @GetMapping("/allFeedback")
    public Object getAllFeedback () {
        return  ResponseUtils.get(feedbackService.getFeedbackList(), HttpStatus.OK);
    }

    @GetMapping("/allFeedback/Artist")
    public Object getAllFeedbackByArtistEmail (@RequestParam String email) {
        return  ResponseUtils.get(feedbackService.getFeedbackListByArtistEmail(email), HttpStatus.OK);
    }

    @GetMapping("/{bookingDetailId}")
    public Object getFeedbackByDetailID (@PathVariable String bookingDetailId) {
        return  ResponseUtils.get(feedbackService.getFeedbackByBookingDetailID(bookingDetailId), HttpStatus.OK);
    }

    //-------------------------------POST/ADD-------------------------------
    @PostMapping("/addFeedback")
    public ResponseEntity<?> saveRole(@RequestBody Feedback feedback) {
        return ResponseUtils.get(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
    }

}
