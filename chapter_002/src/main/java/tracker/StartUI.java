package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цилк программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
           } else if (SHOW.equals(answer)) {
                this.showItem();
           } else if (EDIT.equals(answer)) {
                this.editItem();
           } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findById();
            } else if (FINDNAME.equals(answer)) {
                this.findByName();
           } else if (EXIT.equals(answer)) {
                exit = true;
           }
        }
    }
    public void showItem() {
        if (tracker.getPosition() > 0) {
            Item[] items = this.tracker.findAll();
            for (int i = 0; i != items.length; i++) {
                System.out.println(items[i].getName());
            }
        } else {
            System.out.println("Нет заявок");
        }
    }
    public void editItem() {
        if (tracker.getPosition() > 0) {
            String id = this.input.ask("Enter ID for change");
            System.out.println("--------------------------");
            String name = this.input.ask("Enter item name");
            String desc = this.input.ask("Enter descritpion name");
            Item item = new Item(name, desc, 20190802);
            if (this.tracker.replace(id, item)) {
                System.out.println("Edit succes");
            }
        } else {
            System.out.println("Нет заявок");
        }
    }
    public void deleteItem() {
        if (tracker.getPosition() > 0) {
            String id = this.input.ask("Введите ID заявки для удаления");
            if (this.tracker.delete(id)) {
                System.out.println("Заявка удалена");
            } else {
                System.out.println("Нет заявок");
            }
        }
    }
    public void findById() {
        if (tracker.getPosition() > 0) {
            String id = this.input.ask("Введите ID заявки для поиска");
            Item item = this.tracker.findById(id);
                System.out.println(item.getName() + " найден");
        } else {
            System.out.println("Нет заявок");
        }
    }
    public void findByName() {
        if (tracker.getPosition() > 0) {
            String name = this.input.ask("Введите имя заявки для поиска");
            Item[] item = this.tracker.findByName(name);
            for (int i = 0; i != item.length; i++) {
                System.out.println("найдено совпадающее имя " + item[i].getName() + " ID " + item[i].getId());
            }
        } else {
            System.out.println("Нет заявок");
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------New item--------------");
        String name = this.input.ask("New item name");
        String desc = this.input.ask("New desc");
        Item item = new Item(name, desc, 20190802);
       this.tracker.add(item);
       System.out.println("------------ Item with getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Menu.\n" + "0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" +  "5. Find items by name\n" +  "6. Exit Program\n" +  "Select:");
    }

    /**
     * Запускт программы.
     * @param args
     */
    /*public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }*/
}
