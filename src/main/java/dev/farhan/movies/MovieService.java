package dev.farhan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Cette annotation indique que cette classe est un Service Spring
// Un Service contient la logique métier de l'application
public class MovieService {

    @Autowired  // Cette annotation permet l'injection automatique de dépendance
    // Spring va créer et injecter automatiquement une instance de MovieRepository
    private MovieRepository movieRepository;  // Repository pour accéder aux données des films

    /**
     * Méthode qui devrait retourner la liste de tous les films
     * Actuellement, cette méthode est vide et ne retourne rien
     * Elle devra être implémentée pour utiliser movieRepository et retourner List<Movies>
     */
    public List<Movies> getAllMovies(){
        return movieRepository.findAll();//findAll is a method desc in MongoRepositoryclass
    }

    /* get by id method*/
    /**
     * Récupère un film spécifique par son identifiant
     * @param id L'identifiant unique du film (au format ObjectId de MongoDB)
     * @return Un Optional contenant le film s'il est trouvé, ou Optional.empty() si aucun film ne correspond
     */
    public Optional<Movies> getSingleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    /*find by imdbId*/
    public Optional<Movies> getSingleMovie(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}