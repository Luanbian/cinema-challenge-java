package Cinema.Challenge.data.interfaces;

import java.util.List;
import java.util.Optional;

public interface IFind<T> {
    List<T> perform(Optional<String> title);
}
