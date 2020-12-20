package ru.khekk.bst.task;

import java.util.function.Predicate;

public interface Tree<T extends Comparable<T>> {

    int size();

    Tree<T> clean();

    boolean isEmpty();

    Tree<T> add(T element);

    Tree<T> remove(T element);

    Tree<T> union(Tree<T> that);

    T get();

    default Tree<T> findElement(T element) {
        return filter(element::equals);
    }

    default Tree<T> filter(Predicate<T> predicate) {
        return filterWithAccumulator(predicate, new EmptyTree<>());
    }

    Tree<T> filterWithAccumulator(Predicate<T> predicate, Tree<T> accumulator);

    default Iterator<T> iterator() {
        return new Iterator<>(this);
    }
}
