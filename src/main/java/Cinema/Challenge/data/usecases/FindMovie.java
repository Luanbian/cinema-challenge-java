package Cinema.Challenge.data.usecases;

import Cinema.Challenge.data.interfaces.IFind;
import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.IFindRepository;
import Cinema.Challenge.presentation.Exceptions.MovieNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FindMovie implements IFind<Movie> {
    private final IFindRepository<Movie> repository;
    @Autowired
    public FindMovie(IFindRepository<Movie> repository) {
        this.repository = repository;
    }
    @Override
    public List<Movie> perform(Optional<String> title) {
        if(title.isEmpty()) {
            return findAllMovies();
        }
        return findByTitle(title.get());
    }

    private List<Movie> findAllMovies() {
        return repository.findAll();
    }

    private List<Movie> findByTitle(String title) throws MovieNotFound {
        List<Movie> movies = repository.findByTitle(title);
        if(!movies.isEmpty()) {
            return movies;
        }
        throw new MovieNotFound();
    }
}
