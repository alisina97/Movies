package ca.alisina.movies.Controller;

import ca.alisina.movies.Model.Movie;
import ca.alisina.movies.Model.Review;
import ca.alisina.movies.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService service;
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getOneMovie(@PathVariable String ImdbId) {
        return new ResponseEntity<Optional<Movie>>(service.findById(ImdbId), HttpStatus.OK);
    }
}