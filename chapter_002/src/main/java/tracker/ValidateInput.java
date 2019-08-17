package ru.job4j.tracker;

import ru.job4j.tracker.ConsoleInput;
import tracker.MenuOutException;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
