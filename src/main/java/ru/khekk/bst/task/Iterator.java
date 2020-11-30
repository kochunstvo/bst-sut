package ru.khekk.bst.task;

import java.util.function.Predicate;

public class Iterator<T extends Comparable<T>> {

    private final Tree<T> root;
    private Tree<T> currentPointer;

    public Iterator(Tree<T> tree) {
        this.root = tree;
        this.currentPointer = findMinimalElement(root, elem -> elem.compareTo(root.get()) < 0);
    }

    public Iterator<T> root() {
        return root.iterator();
    }

    public boolean hasNext() {
        return !calculateNext().isEmpty();
    }

    public T get() {
        return currentPointer.get();
    }

    public void next() {
        currentPointer = calculateNext();
    }

    private Tree<T> calculateNext() {
        Tree<T> tree = root.filter(elem -> elem.compareTo(currentPointer.get()) > 0);
        return findMinimalElement(tree, elem -> elem.compareTo(tree.get()) < 0);
    }

    private Tree<T> findMinimalElement(Tree<T> tree, Predicate<T> predicate) {
        Tree<T> filtered = tree.filter(predicate);
        if (filtered.isEmpty()) {
            return tree;
        } else {
            return findMinimalElement(filtered, elem -> elem.compareTo(filtered.get()) < 0);
        }
    }
}
