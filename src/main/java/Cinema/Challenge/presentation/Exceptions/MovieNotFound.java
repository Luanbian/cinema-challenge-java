package Cinema.Challenge.presentation.Exceptions;

public class MovieNotFound extends RuntimeException {
    public MovieNotFound () {
        super("Titulo não encontrado no sistema");
    }

    public MovieNotFound (String message) {
        super(message);
    }
}
