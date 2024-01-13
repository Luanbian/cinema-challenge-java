package Cinema.Challenge.infra.interfaces;

import Cinema.Challenge.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovieJPARepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByTitle(String title);
}
