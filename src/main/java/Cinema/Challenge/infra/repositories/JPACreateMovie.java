package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPACreateMovie implements ICreateRepository<Movie> {
    @Autowired
    MovieJPARepository movieJPARepository;
    @Override
    public void create(Movie data) throws MovieAlreadyExist {
        Optional<List<Movie>> movies = this.movieJPARepository.findByTitle(data.getTitle());
        if(movies.isPresent()) {
            throw new MovieAlreadyExist();
        }
        this.movieJPARepository.save(data);
    }
}
