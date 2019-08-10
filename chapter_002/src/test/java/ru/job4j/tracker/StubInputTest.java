package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StubInputTest {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream out = System.out;

    @Before
    public void beforeCheckList() {
        System.setOut(new PrintStream(baos));
    }

    @After
    public void afterCheckList() {
        System.setOut(out);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item add = tracker.add(new Item("test", "test", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});   //создаём StubInput с последовательностью действий
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        //   создаём StartUI и вызываем метод init()
        assertThat(baos.toString(), is(add.toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
/*
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name1", "desc", 20190804));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "1"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        System.out.println(item.getName());
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.

        assertThat(item.getName(), is("test name"));
    }*/
}
