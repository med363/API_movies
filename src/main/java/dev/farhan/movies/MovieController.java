package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3001")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * GET - Récupérer tous les films
     * URL: /api/v1/movies
     */
    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    /**
     * GET - Récupérer un film par son ObjectId (ID technique MongoDB)
     * URL: /api/v1/movies/id/{objectId}
     * Exemple: /api/v1/movies/id/67a0225aef0a89d1b0b7d3ae
     */
    @GetMapping("/id/{id}")  // ✅ Chemin unique avec préfixe "id/"
    public ResponseEntity<Optional<Movies>> getMovieById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(movieService.getSingleMovie(id), HttpStatus.OK);
    }

    /**
     * GET - Récupérer un film par son imdbId (ID métier)
     * URL: /api/v1/movies/{imdbId}
     * Exemple: /api/v1/movies/tt1375666
     */
    @GetMapping("/{imdbId}")  // ✅ Un seul chemin pour imdbId
    public ResponseEntity<Optional<Movies>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }

    /**
     * POST - Créer un nouveau film
     * URL: /api/v1/movies
     */
    @PostMapping
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
        try {
            Movies createdMovie = movieService.createMovie(movie);
            return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * DELETE - Supprimer un film par son ObjectId
     * URL: /api/v1/movies/id/{id}
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