package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import Cinema.Challenge.data.interfaces.ICreate;
import Cinema.Challenge.domain.entities.Movie;

import java.util.Optional;

public class CreateMovie implements ICreate<Movie, MovieDto> {
    @Override
    public Movie perform(MovieDto data) {
        String _title = data.title();
        String _synopsis = data.synopsis();
        Optional<String> _releaseDate = data.releaseDate();
        Movie movie = Movie.create(_title, _synopsis, _releaseDate);
        return movie;
    }
}
