package ru.khekk.bst;

import org.junit.Before;
import org.junit.Test;
import ru.khekk.bst.task.EmptyTree;
import ru.khekk.bst.task.Iterator;
import ru.khekk.bst.task.Tree;

public class BinaryTreeTest {

    private Tree<Integer> testTree = new EmptyTree<>();

    @Before
    public void setUp() throws Exception {
        testTree = testTree.add(5).add(2).add(9).add(1).add(4).add(3).add(7).add(8).add(6);
    }

    @Test
    public void shouldAddSeveralIntegersIntoTree() {

        testTree = testTree.remove(4);

        System.out.println("Whole tree: " + testTree);

        System.out.println("Size is: " + testTree.size());

        Iterator<Integer> iterator = testTree.iterator();

        System.out.println("First number is: " + iterator.get());
        System.out.println("Iterator 'hasNext()': " + iterator.hasNext());

        iterator.next();

        System.out.println("Second number is: " + iterator.get());
        System.out.println("Iterator 'hasNext()': " + iterator.hasNext());

        iterator.next();

        System.out.println("Third number is: " + iterator.get());
        System.out.println("Iterator 'hasNext()': " + iterator.hasNext());

        iterator.next();
        iterator.next();
        iterator.next();

        System.out.println("Three times 'next()' number is: " + iterator.get());
        System.out.println("Iterator 'hasNext()': " + iterator.hasNext());

        iterator.next();
        iterator.next();
        iterator.next();

        System.out.println("Last number is: " + iterator.get());

        System.out.println("Iterator 'hasNext()': " + iterator.hasNext());
    }
}
