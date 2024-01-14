package Cinema.Challenge.presentation.controllers;

import Cinema.Challenge.data.interfaces.IFind;
import Cinema.Challenge.domain.entities.Movie;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FindMovieControllerTest {
    @InjectMocks
    public FindMovieController sut;
    @Mock
    public IFind<Movie> find;

    public List<Movie> movies = new ArrayList<>();

    @BeforeEach
    public void setup() {
        movies.add(Movie.create("fake_title", "fake_synopsis", Optional.empty()));
        movies.add(Movie.create("real_title", "real_synopsis", Optional.of("release_date")));
    }
    @Test
    public void should_return_ok_if_success() {
        Optional<String> title = Optional.empty();
        when(find.perform(title)).thenReturn(movies);
        ResponseEntity response = sut.handle(title);
        verify(find, times(1)).perform(title);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
