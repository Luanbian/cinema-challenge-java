package Cinema.Challenge.infra.interfaces;

import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;

public interface ICreateRepository<T> {
    void create(T data) throws MovieAlreadyExist;
}
