package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
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
        List<Movie> response = sut.findAll();
        verify(movieJPARepository, times(1)).findAll();
        assertEquals(response, movieJPARepository.findAll());
    }
    @Test
    public void should_be_able_to_find_movie_by_title() {
       String title = "real_title";
       Optional<List<Movie>> response = sut.findByTitle(title);
       verify(movieJPARepository, times(1)).findByTitle(title);
       assertEquals(response, movieJPARepository.findByTitle(title));
       if (response.isPresent()) {
           assertEquals(response.get().get(1).getTitle(), movies.get(1).getTitle());
           assertEquals(response.get().size(), movies.size());
       }
    }
}
