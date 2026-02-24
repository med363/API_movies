package dev.farhan.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*entities(table)*/
@Document(collation = "movies")
/*getter/setter*/
@Data
/*CONSTRRUCTORS*/
@AllArgsConstructor
/*constructor no methode*/
@NoArgsConstructor
public class Movies {
    /*unique id*/
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerlink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;


}
