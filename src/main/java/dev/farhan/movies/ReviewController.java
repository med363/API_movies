package dev.farhan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // Indique que cette classe est un contrôleur REST (API)
@RequestMapping("/api/v1/reviews")  // Toutes les URLs de ce contrôleur commencent par /api/v1/movies
public class ReviewController {

    @Autowired  // Injection automatique du service de gestion des critiques
    private ReviewService reviewService;

    /**
     * Endpoint pour ajouter une critique à un film
     * Méthode HTTP : POST
     * URL : /api/v1/movies
     * Corps de la requête : JSON avec les champs "reviewBody" et "imdbId"
     *
     * @param payload Map contenant les données de la requête (reviewBody et imdbId)
     * @return ResponseEntity contenant la critique créée et le statut HTTP 201 (CREATED)
     */
    @PostMapping  // Mappe les requêtes POST vers cette méthode
    public ResponseEntity<Review> addReview(@RequestBody Map<String, String> payload) {

        // Extraction des données du payload JSON
        String reviewBody = payload.get("reviewBody");  // Correction: "reviewBody" au lieu de "reviewbody"
        String imdbId = payload.get("imdbId");

        // Appel du service pour créer la critique et l'associer au film
        Review createdReview = reviewService.createReview(reviewBody, imdbId);

        // Retourne la critique créée avec le statut HTTP 201 (Created)
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}