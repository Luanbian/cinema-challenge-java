package Cinema.Challenge.infra.interfaces;

import Cinema.Challenge.domain.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface IFindRepository<T> {
    List<T> findAll();
    Optional<List<T>> findByTitle(String title);
}
