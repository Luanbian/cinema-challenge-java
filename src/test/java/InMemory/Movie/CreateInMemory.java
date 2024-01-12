package InMemory.Movie;

import Cinema.Challenge.domain.entities.Movie;
import Cinema.Challenge.infra.interfaces.ICreateRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateInMemory implements ICreateRepository<Movie> {
    private List<Movie> movie;

    public CreateInMemory() {
        this.movie = new ArrayList<>();
    }

    @Override
    public void create(Movie data) {
        this.movie.add(data);
    }
}
