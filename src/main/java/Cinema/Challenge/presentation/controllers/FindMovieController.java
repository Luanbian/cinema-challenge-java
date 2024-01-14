package Cinema.Challenge.presentation.controllers;

import Cinema.Challenge.data.interfaces.IFind;
import Cinema.Challenge.domain.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FindMovieController {
    private final IFind<Movie> find;

    @Autowired
    public FindMovieController(IFind<Movie> find) {
        this.find = find;
    }

    @GetMapping(value = "/movies")
    public ResponseEntity handle(@RequestParam("title") Optional<String> title) {
        List<Movie> movies = this.find.perform(title);
        return ResponseEntity.ok(movies);
    }
}
