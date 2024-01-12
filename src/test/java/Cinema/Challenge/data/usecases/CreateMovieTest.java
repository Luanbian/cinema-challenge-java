package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import static org.junit.jupiter.api.Assertions.*;

import Cinema.Challenge.domain.entities.Movie;
import InMemory.Movie.CreateInMemory;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CreateMovieTest {
    private final CreateMovie sut;

    public CreateMovieTest () {
        CreateInMemory repository = new CreateInMemory();
        this.sut = new CreateMovie(repository);
    }

    @Test
    public void should_be_able_to_create_movie_with_correct_params() {
        MovieDto data = new MovieDto(
                "Title_test",
                "synopsis_test",
                Optional.of("release_test")
        );
        Movie result = this.sut.perform(data);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getCreatedAt());
        assertEquals("Title_test", result.getTitle());
        assertEquals("synopsis_test", result.getSynopsis());
        assertEquals("release_test", result.getReleaseDate());
    }
}
