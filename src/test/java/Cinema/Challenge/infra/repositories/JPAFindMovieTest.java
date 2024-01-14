package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
import static org.junit.jupiter.api.Assertions.*;

import Cinema.Challenge.presentation.Exceptions.MovieNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JPAFindMovieTest {
    @InjectMocks
    public JPAFindMovie sut;

    @Mock
    public MovieJPARepository movieJPARepository;

    public List<Movie> movies = new ArrayList<>();
    @BeforeEach
    public void setup() {
        movies.add(Movie.create("fake_title", "fake_synopsis", Optional.empty()));
        movies.add(Movie.create("real_title", "real_synopsis", Optional.of("release_date")));
    }
    @Test
    public void should_be_able_to_list_all_movies() {
        when(movieJPARepository.findAll()).thenReturn(movies);
        List<Movie> response = sut.findAll();
        verify(movieJPARepository, times(1)).findAll();
        assertEquals(response, movieJPARepository.findAll());
        assertEquals(movieJPARepository.findAll().size(), response.size());
    }
    @Test
    public void should_be_called_with_correct_param() {
        String title = "real_title";
        List<Movie> filtered = movies.stream().filter(t -> t.getTitle().equals(title)).toList();
        when(movieJPARepository.findByTitle(title)).thenReturn(filtered);
        sut.findByTitle(title);
        verify(movieJPARepository, times(1)).findByTitle(title);
        assertEquals(movieJPARepository.findByTitle(title).get(0).getTitle(), title);
    }
    @Test
    public void should_return_empty_list_if_movie_not_be_found() {
        String invalidTitle = "invalid_title";
        List<Movie> empty = Collections.emptyList();
        when(movieJPARepository.findByTitle(invalidTitle)).thenReturn(empty);
        List<Movie> response = sut.findByTitle(invalidTitle);
        assertEquals(response, empty);
    }
}
