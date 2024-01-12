package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import Cinema.Challenge.data.interfaces.ICreate;
import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;
import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateMovie implements ICreate<Movie, MovieDto> {
    private final ICreateRepository<Movie> repository;

    @Autowired
    public CreateMovie(ICreateRepository<Movie> repository) {
        this.repository = repository;
    }

    @Override
    public Movie perform(MovieDto data) {
        try {
            String _title = data.title();
            String _synopsis = data.synopsis();
            Optional<String> _releaseDate = data.releaseDate();
            Movie movie = Movie.create(_title, _synopsis, _releaseDate);
            this.repository.create(movie);
            return movie;
        } catch (MovieAlreadyExist ex) {
            throw new MovieAlreadyExist(ex.getMessage());
        }
    }
}
