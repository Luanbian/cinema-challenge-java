package Cinema.Challenge.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "movie")
@Table(name = "Movie")
@Data
@EqualsAndHashCode(of = "id")
public class Movie {
    public UUID id;
    public LocalDateTime createdAt;
    public String title;
    public String synopsis;
    public String releaseDate;

    private Movie(String _title, String _synopsis, String _releaseDate) {
        id = UUID.randomUUID();
        createdAt = LocalDateTime.now();
        title = _title;
        synopsis = _synopsis;
        releaseDate = _releaseDate;
    }

    public static Movie create(String _title, String _synopsis, String _releaseDate) {
        return new Movie(_title, _synopsis, _releaseDate);
    }
}
