package ca.alisina.movies.Service;

import ca.alisina.movies.Repository.ReviewRepository;
import ca.alisina.movies.Model.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String ImdbId) {
        Review review = repository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("ImdbId").is(ImdbId))
                .apply(new Update().push("ReviewIds").value(review))
                .first();
        return review;
    }
//
//    public List<Review> findAllReviews() {
//        return repository.findAll();
//    }
//
//    public Optional<Review> findById(ObjectId id) {
//        return repository.findById(id);
//    }
}