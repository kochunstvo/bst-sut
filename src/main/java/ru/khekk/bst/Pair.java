package ru.khekk.bst;

public class Pair<T, E> {

    private final T first;
    private final E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public static <T, E> Pair<T, E> of(T first, E second) {
        return new Pair<>(first, second);
    }

    public T first() {
        return first;
    }

    public E second() {
        return second;
    }
}
