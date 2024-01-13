package Cinema.Challenge.infra.interfaces;

import java.util.List;

public interface IFindRepository<T> {
    List<T> findAll();
    List<T> findByTitle(String title);
}
