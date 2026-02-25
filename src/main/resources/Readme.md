1. REQUÊTE HTTP:
   GET /api/v1/movies

2. CONTROLLER (MovieController):
   @GetMapping
   public ResponseEntity<List<Movies>> getAllMovies() {
   // Délègue au service
   return movieService.getAllMovies();
   }

3. SERVICE (MovieService):
   public List<Movies> getAllMovies(){
   // Logique métier (si nécessaire)
   return movieRepository.findAll();  // Appelle le repository
   }

4. REPOSITORY (MovieRepository):
   public interface MovieRepository extends MongoRepository<Movies, ObjectId> {
   // Spring Data MongoDB génère automatiquement:
   // - la requête MongoDB
   // - la connexion à la base
   // - le mapping des résultats
   }

5. BASE DE DONNÉES (MongoDB):
   db.movies.find({})

6. RÉPONSE (remonte la chaîne inverse):
   Repository retourne List<Movies>
   Service retourne List<Movies>
   Controller formate en JSON

7. RÉPONSE HTTP:
   Status: 200 OK
   Body: [{...}, {...}] (JSON)

┌─────────────────┐
│   CONTROLLER    │  ← Reçoit les requêtes HTTP
│  @RestController│    Dépend du SERVICE
└────────┬────────┘
│ appelle
▼
┌─────────────────┐
│     SERVICE     │  ← Contient la logique métier
│    @Service     │    Dépend du REPOSITORY
└────────┬────────┘
│ utilise
▼
┌─────────────────┐
│   REPOSITORY    │  ← Interface avec la DB
│ @Repository     │    Hérite de MongoRepository
└────────┬────────┘
│ interroge
▼
┌─────────────────┐
│  BASE DE DONNÉES│  ← MongoDB
│    (MongoDB)    │
└─────────────────┘