package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JPACreateMovie implements ICreateRepository<Movie> {
    @Autowired
    MovieJPARepository movieJPARepository;
    @Override
    public void create(Movie data) {
        this.movieJPARepository.save(data);
    }
}
