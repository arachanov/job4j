package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param keeps object reference.
     */
    private Input input;
    /**
     * @param keeps object reference.
     */
    private Tracker tracker;
    /**
     * @param keeps array type UserAction reference.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Construction.
     * @param input object type Input.
     * @param tracker object type Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method to get menu array.
     * @return array length
     */
    public int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Method fills array.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItem(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    /**
     *
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
           if (action != null) {
                System.out.print(action.info());
            }
        }
    }

    class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name:");
            String desc = input.ask("Enter description:");
            tracker.add(new Item(name, desc, 25082019));
        }
    }

    private class ShowItem implements UserAction {
        private int num;
        private String str;
        public ShowItem(int num, String str) {
            this.num = num;
            this.str = str;
        }
        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.print(item);
            }
        }

        @Override
         public String info() {
            return String.format("%s. %s", num, str);
        }
    }

    private class UpdateItem implements UserAction {
        private int num;
        private String str;
        public UpdateItem(int num, String str) {
            this.num = num;
            this.str = str;
        }

        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------------- Edit item -----------------");
            String id = input.ask("Please, provide ID item for edit: ");
            String name = input.ask("Please, provide item new name: ");
            String desc = input.ask("Please, provide item new desc: ");
            Item result = new Item(name, desc, 1511313);

            if (tracker.replace(id, result)) {
                System.out.println("--------------- Item changed --------------");
            } else {
                System.out.println("----------- Item doesn't changed ----------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", num, str);
        }
    }

    private class DeleteItem implements UserAction {
        private int num;
        private String str;
        public DeleteItem(int num, String str) {
            this.num = num;
            this.str = str;
        }

        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------- Delete item ----------------");
            String id = input.ask("Please, provide ID item for delete: ");
            if (id != null && tracker.delete(id)) {
                System.out.println("--------------- Item delete ---------------");
            } else {
                System.out.println("------------ Item didn't delete -----------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", num, str);
        }
    }

    private class FindItemById implements UserAction {
        private int num;
        private String str;
        public FindItemById(int num, String str) {
            this.num = num;
            this.str = str;
        }

        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, provide ID item for search: ");
            Item result = tracker.findById(id);
            if (result != null) {
                System.out.print(result);
            } else {
                System.out.println("------------- Item didn't find ------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", num, str);
        }
    }

    private class FindItemsByName implements UserAction {
        private int num;
        private String str;
        public FindItemsByName(int num, String str) {
            this.num = num;
            this.str = str;
        }
        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, provide name item for search: ");
            Item[] result = tracker.findByName(name);
            for (Item item : result) {
                System.out.print(item);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", num, str);
        }
    }

    private class ExitProgram implements UserAction {
        private int num;
        private String str;
        public ExitProgram(int num, String str) {
            this.num = num;
            this.str = str;
        }

        @Override
        public int key() {
            return num;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. %s", num, str);
        }
    }
}