package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/*fix root*/
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3001")
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
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movies>>(movieService.getSingleMovie(id), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movies>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }

    /**
     * POST - Créer un nouveau film
     * URL: /api/v1/movies
     * Méthode: POST
     * Corps: JSON avec les données du film
     *
     * Exemple de requête:
     * {
     *     "imdbId": "tt1234567",
     *     "title": "Inception",
     *     "releaseDate": "2010-07-16",
     *     "trailerlink": "https://youtube.com/watch?v=YoHD9XEInc0",
     *     "poster": "https://image.url/poster.jpg",
     *     "genres": ["Action", "Sci-Fi"],
     *     "backdrops": ["url1", "url2"],
     *     "reviewIds": []
     * }
     */
    @PostMapping
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
        try {
            Movies createdMovie = movieService.createMovie(movie);
            return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Remplacer new ResponseEntity<>(null, HttpStatus.CONFLICT) par:
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
            // OU avec body null explicite:
            // return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    /**
     * DELETE - Supprimer un film par son ObjectId
     * URL: /api/v1/movies/id/{id}
     * Méthode: DELETE
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable ObjectId id) {
        boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return new ResponseEntity<>("Film supprimé avec succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Film non trouvé", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE - Supprimer un film par son imdbId
     * URL: /api/v1/movies/{imdbId}
     * Méthode: DELETE
     */
    @DeleteMapping("/{imdbId}")
    public ResponseEntity<String> deleteMovieByImdbId(@PathVariable String imdbId) {
        boolean deleted = movieService.deleteMovieByImdbId(imdbId);
        if (deleted) {
            return new ResponseEntity<>("Film supprimé avec succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Film non trouvé", HttpStatus.NOT_FOUND);
        }
    }
}

