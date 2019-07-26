package ru.job4j.tracker;

import ru.job4j.jobs.*;

public class Tracker {
    public String imya() {
        Programmer prog = new Programmer("Salim", "Arachanov", "job4j", 25072019);
        String name = prog.getName();
       return name;
    }
}