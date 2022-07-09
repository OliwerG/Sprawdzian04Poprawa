package zadanie01;

public class MinMax<T extends Comparable<T>> {
    private T min;
    private T max;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}

