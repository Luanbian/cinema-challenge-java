package Cinema.Challenge.core.DTOs;

import java.util.Optional;

public record MovieDto(
        String title,
        String synopsis,
        Optional<String> releaseDate
) { }
