package Cinema.Challenge.data.usecases;

import Cinema.Challenge.data.interfaces.IFind;
import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.IFindRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FindMovie implements IFind<Movie> {
    private final IFindRepository<Movie> repository;
    @Autowired
    public FindMovie(IFindRepository<Movie> repository) {
        this.repository = repository;
    }
    @Override
    public List<Movie> perform(Optional<String> title) {
        if (title.isPresent()) {
            return repository.findByTitle(title.get());
        }
        return repository.findAll();
    }
}
