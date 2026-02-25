package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
/*fix root*/
@RequestMapping("/api/v1/movies")
public class MovieController {
    /*inject svc in controller*/
    @Autowired
    private MovieService movieService;
    /*get all*/
    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<List<Movies>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    /*pull data from databse so we need service so we will create repository*/

    /*get by id*/
    @GetMapping("{/id}")
    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable ObjectId id) {
return new ResponseEntity<Optional<Movies>>(movieService.getSingleMovie(id), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movies>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }
}
