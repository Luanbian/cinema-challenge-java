package Cinema.Challenge.infra.interfaces;

import Cinema.Challenge.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieJPARepository extends JpaRepository<Movie, UUID> {}
