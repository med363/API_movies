package dev.farhan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewReposiory reviewReposiory;
/* use fast mongo template WITHout use review repository*/
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId) {
         Review review = new Review(reviewBody);
         reviewReposiory.insert(review);

        return review;
    }
}
