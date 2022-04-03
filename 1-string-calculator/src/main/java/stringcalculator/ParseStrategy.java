package stringcalculator;

public interface ParseStrategy<T, R> {
    public R parse(T value);
}
