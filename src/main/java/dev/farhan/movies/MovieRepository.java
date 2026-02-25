package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*that interface is a repository*/
@Repository
public interface MovieRepository extends MongoRepository<Movies, ObjectId> {
    /*searchby imdbid also*/
    Optional<Movies> findByImdbId(String imdbId);
}
