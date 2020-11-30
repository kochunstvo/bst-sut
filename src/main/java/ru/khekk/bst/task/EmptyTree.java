package ru.khekk.bst.task;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class EmptyTree<T extends Comparable<T>> implements Tree<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Tree<T> clean() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Tree<T> add(T element) {
        return new BinaryTree<T>(element);
    }

    @Override
    public Tree<T> remove(T element) {
        return this;
    }

    @Override
    public Tree<T> union(Tree<T> that) {
        return that;
    }

    @Override
    public T get() {
        throw new NoSuchElementException();
    }

    @Override
    public Tree<T> filterWithAccumulator(Predicate<T> predicate, Tree<T> accumulator) {
        return accumulator;
    }

    @Override
    public String toString() {
        return "";
    }
}
