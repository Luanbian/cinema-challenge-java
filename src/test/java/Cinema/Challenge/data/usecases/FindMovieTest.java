package Cinema.Challenge.data.usecases;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.IFindRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindMovieTest {
    @InjectMocks
    public FindMovie sut;

    @Mock
    public IFindRepository<Movie> repository;

    public List<Movie> movies = new ArrayList<>();

    @BeforeEach
    public void setup() {
        movies.add(Movie.create("fake_title", "fake_synopsis", Optional.empty()));
        movies.add(Movie.create("real_title", "real_synopsis", Optional.of("release_date")));
    }

    @Test
    public void should_be_able_to_list_all_movies_if_title_not_passed() {
        Optional<String> title = Optional.empty();
        when(repository.findAll()).thenReturn(movies);
        List<Movie> response = sut.perform(title);
        verify(repository, times(1)).findAll();
        verify(repository, never()).findByTitle(title.toString());
        assertEquals(response, repository.findAll());
    }
    @Test
    public void should_be_able_to_list_by_title_if_title_passed() {
        String title = "real_title";
        List<Movie> filtered = movies.stream().filter(t -> t.getTitle().equals(title)).toList();
        when(repository.findByTitle(title)).thenReturn(filtered);
        List<Movie> response = sut.perform(Optional.of(title));
        verify(repository, times(1)).findByTitle(title);
        verify(repository, never()).findAll();
        assertEquals(response, repository.findByTitle(title));
    }
}
