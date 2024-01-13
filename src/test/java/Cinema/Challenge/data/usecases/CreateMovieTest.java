package Cinema.Challenge.data.usecases;

import Cinema.Challenge.core.DTOs.MovieDto;
import static org.junit.jupiter.api.Assertions.*;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;
import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
@ExtendWith(MockitoExtension.class)
public class CreateMovieTest {
    @InjectMocks
    public CreateMovie sut;
    @Mock
    public ICreateRepository<Movie> repository;

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
    @Test
    public void should_throw_if_movie_already_exists() {
        MovieDto data = new MovieDto(
                "Title_test",
                "synopsis_test",
                Optional.of("release_test")
        );
        doThrow(new MovieAlreadyExist()).when(repository).create(any(Movie.class));
        assertThrows(MovieAlreadyExist.class, () -> sut.perform(data));
    }
}
