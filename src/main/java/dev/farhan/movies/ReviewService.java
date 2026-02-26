package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service  // Indique que cette classe est un Service Spring (logique métier)
public class ReviewService {

    @Autowired  // Injection automatique du repository pour les critiques
    private ReviewReposiory reviewReposiory;

    /* Utilisation de MongoTemplate pour des opérations plus complexes
       sans passer par le repository standard */
    @Autowired  // Injection automatique de MongoTemplate pour des requêtes avancées
    private MongoTemplate mongoTemplate;

    /**
     * Crée une nouvelle critique et l'associe à un film
     * @param reviewBody Le contenu texte de la critique
     * @param imdbId L'identifiant IMDb du film concerné
     * @return La critique créée et sauvegardée
     */
    public Review createReview(String reviewBody, String imdbId) {

        // 1. Créer et sauvegarder la nouvelle critique dans la collection "reviews"
        //    Le repository s'occupe de l'insertion en base de données
        Review review = reviewReposiory.insert(new Review(reviewBody));

        // 2. Récupérer l'ID de la critique créée
        ObjectId reviewId = review.getId();  // Récupère l'ObjectId généré par MongoDB

        // 3. Mettre à jour le film correspondant pour y ajouter l'ID de cette critique
        //    MongoTemplate permet de faire une mise à jour plus complexe
        mongoTemplate.update(Movies.class)  // On cible la collection des films
                .matching(Criteria.where("imdbId").is(imdbId))  // On cherche le film avec cet imdbId
                .apply(new Update().push("reviewIds").value(reviewId))  // ✅ CORRECTION: On ajoute SEULEMENT l'ID de la critique au tableau reviewIds
                .first();  // On applique la mise à jour au premier (et unique) film trouvé

        // 4. Retourner la critique créée
        return review;
    }
}