package ru.khekk.bst.ui;

import java.util.NoSuchElementException;
import java.util.function.Function;

public class Option<T> {
    private final String command;
    private final Function<Object, ?> function;
    private final boolean requiresParam;
    private final String description;

    public Option(String command, Function<Object, ?> function, String description, boolean requiresParam) {
        this.command = command;
        this.function = function;
        this.description = description;
        this.requiresParam = requiresParam;
    }

    public void run(Object obj) {
        try {
            System.out.println(function.apply(obj));
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        System.out.println();
    }

    public String getCommand() {
        return command;
    }

    public boolean isRequiresParam() {
        return requiresParam;
    }

    @Override
    public String toString() {
        return command + ". - " + description;
    }
}
