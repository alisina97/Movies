package ca.alisina.movies.Service;

import ca.alisina.movies.Model.Movie;
import ca.alisina.movies.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(String id) {
        return movieRepository.findByImdbId(id);
    }
}