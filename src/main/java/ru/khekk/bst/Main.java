package ru.khekk.bst;

import ru.khekk.bst.task.BinaryTree;
import ru.khekk.bst.task.EmptyTree;
import ru.khekk.bst.task.Iterator;
import ru.khekk.bst.task.Tree;
import ru.khekk.bst.ui.Option;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Tree<Integer> tree = new EmptyTree<>();
    private static Iterator<Integer> iterator = null;
    private static final List<Option<?>> options = Arrays.asList(
            new Option<>(
                    "e",
                    (nothing) -> {
                        System.exit(0);
                        return 0; //sorry for that
                    },
                    "Exit.",
                    false
            ),
            new Option<>(
                    "0",
                    (nothing) -> tree = defaultTree(),
                    "Use default tree.",
                    false
            ),
            new Option<>(
                    "1",
                    (nothing) -> tree = new EmptyTree<>(),
                    "Use new tree.",
                    false
            ),
            new Option<>(
                    "2",
                    (nothing) -> tree.size(),
                    "Get size of current tree.",
                    false
            ),
            new Option<>(
                    "3",
                    (nothing) -> tree.clean(),
                    "Clean current tree.",
                    false
            ),
            new Option<>(
                    "4",
                    (nothing) -> tree.isEmpty(),
                    "Is current tree empty?",
                    false
            ),
            new Option<Integer>(
                    "5",
                    (element) -> tree = tree.filter(element::equals),
                    "Find element by predicate",
                    true
            ),
            new Option<Integer>(
                    "6",
                    (element) -> tree = tree.add((Integer) element),
                    "Add element",
                    true
            ),
            new Option<Integer>(
                    "7",
                    (element) -> tree = tree.remove((Integer) element),
                    "Remove element",
                    true
            ),
            new Option<>(
                    "8",
                    (nothing) -> iterator = tree.iterator(),
                    "Get iterator",
                    false
            ),
            new Option<>(
                    "8.1",
                    (nothing) -> iterator = iterator.root(),
                    "Place iterator on root",
                    false
            ),
            new Option<>(
                    "8.2",
                    (nothing) -> !iterator.hasNext(),
                    "Whether last element reached",
                    false
            ),
            new Option<>(
                    "8.3",
                    (nothing) -> iterator.get(),
                    "Get value of current iterator pointer",
                    false
            ),
            new Option<>(
                    "8.4",
                    (nothing) -> iterator.next(),
                    "Place iterator at next element",
                    false
            ),
            new Option<>(
                    "8.5",
                    (nothing) -> iterator.prev(),
                    "Place iterator at prev element",
                    false
            )
    );

    public static void main(String[] args) {
        System.out.println("This is the BinaryTree implementation.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            String command = scanner.nextLine();
            Option<?> option = options.stream().filter(it -> it.getCommand().equals(command)).findFirst().get();
            if (option.isRequiresParam()) {
                String element = scanner.nextLine();
                option.run(Integer.valueOf(element));
            } else {
                option.run(null);
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options are: ");
        options.forEach(System.out::println);
    }

    private static Tree<Integer> defaultTree() {
        return new BinaryTree<>(5).add(2).add(9).add(1).add(4).add(3).add(7).add(8).add(6);
    }

}
