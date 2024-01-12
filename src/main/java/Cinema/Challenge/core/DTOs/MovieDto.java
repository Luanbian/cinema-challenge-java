package Cinema.Challenge.core.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record MovieDto(
        @NotNull(message = "O título não pode ser nulo")
        @NotBlank(message = "O título não pode estar em branco")
        String title,
        @NotNull(message = "A sinopse não pode ser nula")
        @NotBlank(message = "A sinopse não pode estar em branco")
        String synopsis,
        Optional<String> releaseDate
) { }
