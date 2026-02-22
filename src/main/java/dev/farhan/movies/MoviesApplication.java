package dev.farhan.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*class for controllers*/
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	/*get*/
	@GetMapping("/")
	public String Rootapi(){
		return "shahia tayba ";
	}

	/* get avec paramètre dans le chemin */
	@GetMapping("/{name}")
	public String Rootapi(@PathVariable String name) {
		return "shahia tayba " + name;
	}

}
