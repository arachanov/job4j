package tracker;

import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Random;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }


    private final Item[] items = new Item[100];
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    public int getPosition() {
        return position;
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - (i + 1));
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] equalName = new Item[position];
        int pos = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                equalName[pos] = this.items[i];
                pos++;
            }
        }
        return Arrays.copyOf(equalName, pos);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для задаявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
