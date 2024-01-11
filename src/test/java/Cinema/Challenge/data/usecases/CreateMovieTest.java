package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CreateMovieTest {
    @Test
    public void should_be_able_to_create_movie() {
        CreateMovie sut = new CreateMovie();
        MovieDto data = new MovieDto(
                "Title_test",
                "synopsis_test",
                Optional.of("release_test")
        );
        Object result = sut.perform(data);
        assertNotNull(result);
    }
}
