package Cinema.Challenge.presentation.Exceptions;

public class MovieAlreadyExist extends RuntimeException {
    public MovieAlreadyExist () {
        super("Filme já cadastrado no sistema");
    }

    public MovieAlreadyExist(String message) {
        super(message);
    }
}
