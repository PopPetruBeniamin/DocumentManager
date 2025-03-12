package Domain;

public abstract class DocumentConverter<T> {
    public abstract String toString(T shape);
    public abstract T fromString(String line);
}
