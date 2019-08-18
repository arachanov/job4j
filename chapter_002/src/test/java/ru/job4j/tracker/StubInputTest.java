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
    private static final String MENU = "0. Add new Item" + "1. Show all items" + "2. Edit item" + "3. Delete item" + "4. Find item by Id" +  "5. Find items by name" +  "6. Exit Program";

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
        Input input = new StubInput(new String[]{"1", "y"});   //создаём StubInput с последовательностью действий
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        //   создаём StartUI и вызываем метод init()
        assertThat(baos.toString(), is(MENU + add.toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    /*
    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item add = tracker.add(new Item("test", "test", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", add.getName(), "y"});   //создаём StubInput с последовательностью действий
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        //   создаём StartUI и вызываем метод init()
        assertThat(baos.toString(), is(MENU + add.toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void testFindId() {
        Tracker tracker = new Tracker();
        Item add = tracker.add(new Item("test", "test", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", add.getId(), "y"});   //создаём StubInput с последовательностью действий
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        //   создаём StartUI и вызываем метод init()
        assertThat(baos.toString(), is(MENU + add.toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }*/
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
