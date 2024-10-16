package ca.alisina.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;  // Inject MovieRepository

    @Autowired
    private MovieService service;        // Inject MovieService (if used for additional logic)
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = repository.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}