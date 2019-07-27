package ru.job4j.jobs;

public class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        Diagnose health = new Diagnose();
        if (pacient.getAge() > 50) {
            health.isGood();
      }
         return health;
    }
}