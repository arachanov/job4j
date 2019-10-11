package ru.job4j.tracker;
import java.util.*;
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();
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
        this.items.add(this.position++, item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                this.items.add(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                //System.arraycopy(this.items, i + 1, this.items, i, this.items.size() - (i + 1));
                this.items.remove(i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
       // return Arrays.copyOf(this.items, this.position);
        return items.toArray(new Item[items.size()]);
    }

    public Item[] findByName(String key) {
        Item[] equalName = new Item[position];
        int pos = 0;
            for (int i = 0; i < this.position; i++) {
                if (this.items.get(i).getName().equals(key)) {
                    equalName[pos] = this.items.get(i);
                    pos++;
                }
            }
            return Arrays.copyOf(equalName, pos);
        }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i != position; i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = items.get(i);
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
