package dev.farhan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
