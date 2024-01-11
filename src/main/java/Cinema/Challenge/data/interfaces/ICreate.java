package Cinema.Challenge.data.interfaces;

public interface ICreate<T, Dto> {
        T perform(Dto data);
}
