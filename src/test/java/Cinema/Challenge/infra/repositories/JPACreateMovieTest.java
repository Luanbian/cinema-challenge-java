package Cinema.Challenge.infra.repositories;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.MovieJPARepository;
import static org.junit.jupiter.api.Assertions.*;

import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JPACreateMovieTest {
    @InjectMocks
    public JPACreateMovie sut;
    @Mock
    public MovieJPARepository movieJPARepository;

    @Test
    public void should_be_able_to_save_movie() {
        Movie movie = Movie.create(
                "fake_title",
                "fake_sinopsys",
                Optional.of("fake_release")
        );
        when(movieJPARepository.findByTitle(movie.getTitle())).thenReturn(List.of());
        sut.create(movie);
        verify(movieJPARepository, times(1)).save(movie);
    }
    @Test
    public void should_throw_if_movie_already_exists() {
        Movie existingMovie = Movie.create(
                "fake_title",
                "fake_sinopsys",
                Optional.of("fake_release")
        );
        when(movieJPARepository.findByTitle(existingMovie.getTitle()))
                .thenReturn(Collections.singletonList(Movie.create("a", "b", Optional.empty())));
        assertThrows(MovieAlreadyExist.class, () -> sut.create(existingMovie));
        verify(movieJPARepository, never()).save(existingMovie);
    }
}
