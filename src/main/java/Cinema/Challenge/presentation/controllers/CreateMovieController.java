package Cinema.Challenge.presentation.controllers;

import Cinema.Challenge.core.DTOs.MovieDto;
import Cinema.Challenge.data.interfaces.ICreate;
import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CreateMovieController {
    private final ICreate<Movie, MovieDto> create;

    @Autowired
    public CreateMovieController(ICreate<Movie, MovieDto> create) {
        this.create = create;
    }

    @PostMapping(value = "/movies")
    public ResponseEntity handle(@RequestBody @Valid MovieDto movieDto) {
        try {
            Movie movie = this.create.perform(movieDto);
            return ResponseEntity.ok(movie);
        } catch (Exception ex) {
            if (ex instanceof MovieAlreadyExist) {
                return ResponseEntity.badRequest().body(ex.getMessage());
            } else {
                return ResponseEntity.internalServerError().body(ex);
            }
        }
    }
}
