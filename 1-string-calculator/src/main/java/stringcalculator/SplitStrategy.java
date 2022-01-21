package stringcalculator;

public interface SplitStrategy<T> {
    public T[] split(T raw);
}
