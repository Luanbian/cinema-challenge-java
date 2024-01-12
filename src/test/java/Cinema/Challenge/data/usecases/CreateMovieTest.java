package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import static org.junit.jupiter.api.Assertions.*;

import Cinema.Challenge.domain.entities.Movie;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CreateMovieTest {
    @Test
    public void should_be_able_to_create_movie_with_correct_params() {
        CreateMovie sut = new CreateMovie();
        MovieDto data = new MovieDto(
                "Title_test",
                "synopsis_test",
                Optional.of("release_test")
        );
        Movie result = sut.perform(data);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getCreatedAt());
        assertEquals("Title_test", result.getTitle());
        assertEquals("synopsis_test", result.getSynopsis());
        assertEquals("release_test", result.getReleaseDate());
    }
}
