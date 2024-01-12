package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import Cinema.Challenge.data.interfaces.ICreate;
import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CreateMovie implements ICreate<Movie, MovieDto> {
    @Autowired
    ICreateRepository<Movie> repository;

    @Override
    public Movie perform(MovieDto data) {
        String _title = data.title();
        String _synopsis = data.synopsis();
        Optional<String> _releaseDate = data.releaseDate();
        Movie movie = Movie.create(_title, _synopsis, _releaseDate);
        this.repository.create(movie);
        return movie;
    }
}
