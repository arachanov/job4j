package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() != 0) {
            for (int index = 0; index < tasks.size(); index++) {
                if (task.getPriority() < tasks.get(index).getPriority()) {
                    tasks.add(index, task);
                    break;
                }
            }

        } else {
            tasks.add(0, task);
        }

    }

    public Task take() {
        Task res = this.tasks.poll();
        return res;
    }

}