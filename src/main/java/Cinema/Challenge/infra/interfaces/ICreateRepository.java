package Cinema.Challenge.infra.interfaces;

public interface ICreateRepository<T> {
    void create(T data);
}
