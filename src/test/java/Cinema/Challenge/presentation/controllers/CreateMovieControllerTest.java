package Cinema.Challenge.presentation.controllers;

import Cinema.Challenge.core.DTOs.MovieDto;
import Cinema.Challenge.data.interfaces.ICreate;
import Cinema.Challenge.domain.entities.Movie;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateMovieControllerTest {
    @InjectMocks
    public CreateMovieController sut;

    @Mock
    public ICreate<Movie, MovieDto> create;

    @Test
    public void should_be_able_to_return_ok_if_success() {
        MovieDto movieDto = new MovieDto(
                "fake_title",
                "fake_sinopsys",
                Optional.of("fake_release")
        );
        Movie movie = Movie.create(
                "fake_title",
                "fake_sinopsys",
                Optional.of("fake_release")
        );
        when(create.perform(movieDto)).thenReturn(movie);
        ResponseEntity response = sut.handle(movieDto);
        verify(create, times(1)).perform(movieDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movie, response.getBody());
    }
}
