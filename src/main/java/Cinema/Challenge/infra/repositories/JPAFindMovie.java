package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.IFindRepository;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
import Cinema.Challenge.presentation.Exceptions.MovieNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAFindMovie implements IFindRepository<Movie> {
    private final MovieJPARepository movieJPARepository;

    @Autowired
    public JPAFindMovie(MovieJPARepository movieJPARepository) {
        this.movieJPARepository = movieJPARepository;
    }
    @Override
    public List<Movie> findAll() {
        return movieJPARepository.findAll();
    }

    @Override
    public List<Movie> findByTitle(String title) {
        List<Movie> movies = movieJPARepository.findByTitle(title);
        return movies;
    }
}
