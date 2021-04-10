package generators;

public abstract class Generator<T> {

    public final T generateAndReturnParams(final int code) {
        generateParams(code);
        return buildResponse();
    }
    abstract void generateParams(int code);

    abstract T buildResponse();
}
