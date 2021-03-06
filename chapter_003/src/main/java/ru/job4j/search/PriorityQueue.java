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
        boolean addLisst = false;
        if (tasks.size() != 0) {
            int index = 0;
            for (var iTask : tasks) {
                if (iTask.getPriority() > task.getPriority()) {
                    tasks.add(index, task);
                    addLisst = true;
                    break;
                }
                index++;
            }
            if (!addLisst) {
                tasks.addLast(task);
            }
        } else {
            tasks.add(0, task);
        }

    }

    public Task take() {
        var res = this.tasks.poll();
        return res;
    }

}