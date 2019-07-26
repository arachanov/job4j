package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import ru.job4j.jobs.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

@Ignore
public class TrackerTest {
    @Test
    public void proffesionTest() {
        Tracker track = new Tracker();
        String result = track.imya();
        assertThat(result, is("Salim"));
    }
    @Test
    public void checkDiagnose() {
        Pacient pacient = new Pacient("Steev", 55);
        Doctor doc = new Doctor();
        assertThat(doc.heal(pacient), is(false));
    }
}