package ru.khekk.bst.task;

import java.util.Objects;
import java.util.function.Predicate;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private final T elem;
    private final Tree<T> left;
    private final Tree<T> right;

    public BinaryTree(T elem) {
        this(elem, new EmptyTree<>(), new EmptyTree<>());
    }

    public BinaryTree(T elem, Tree<T> left, Tree<T> right) {
        Objects.requireNonNull(elem);
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    @Override
    public int size() {
        return left.size() + right.size() + 1;
    }

    @Override
    public Tree<T> clean() {
        return new EmptyTree<>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Tree<T> filterWithAccumulator(Predicate<T> predicate, Tree<T> accumulator) {
        if (predicate.test(elem)) {
            return left.filterWithAccumulator(predicate, right.filterWithAccumulator(predicate, accumulator.add(elem)));
        } else {
            return left.filterWithAccumulator(predicate, right.filterWithAccumulator(predicate, accumulator));
        }
    }

    @Override
    public Tree<T> add(T element) {
        Tree<T> result;
        switch (element.compareTo(elem)) {
            case -1:
                result = new BinaryTree<>(elem, left.add(element), right);
                break;
            case 0:
                result = this;
                break;
            case 1:
                result = new BinaryTree<>(elem, left, right.add(element));
                break;
            default:
                throw new IllegalStateException("Cannot reach this");
        }
        return result;
    }

    @Override
    public Tree<T> remove(T element) {
        Tree<T> result;
        switch (element.compareTo(elem)) {
            case -1:
                result = new BinaryTree<>(elem, left.remove(element), right);
                break;
            case 0:
                result = left.union(right);
                break;
            case 1:
                result = new BinaryTree<>(elem, left, right.remove(element));
                break;
            default:
                throw new IllegalStateException("Cannot reach this");
        }
        return result;
    }

    @Override
    public Tree<T> union(Tree<T> that) {
        return left.union(right.union(that.add(elem)));
    }

    @Override
    public T get() {
        return elem;
    }

    @Override
    public String toString() {
        return left.toString() + "[" + elem.toString() + "]" + right.toString();
    }
}
