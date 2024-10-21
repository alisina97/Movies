package ca.alisina.movies.Controller;

import ca.alisina.movies.Model.Review;
import ca.alisina.movies.Service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<List<Review>>(service.findAllReviews(),HttpStatus.OK);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Review>> getOneReview(@PathVariable ObjectId id) {
//        return new ResponseEntity<Optional<Review>>(service.findById(id), HttpStatus.OK);
//    }
}
