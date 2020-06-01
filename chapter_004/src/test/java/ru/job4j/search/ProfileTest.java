package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Is.*;

public class ProfileTest {
    @Test
    public void findAddress() {
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Moscow", "Arbat", 99, 100)));
        profile.add(new Profile(new Address("Moscow", "Arbat", 199, 1100)));
        profile.add(new Profile(new Address("Krasnodar", "Red", 78, 56)));
        profile.add(new Profile(new Address("Krasnodar", "Red", 178, 156)));
        profile.add(new Profile(new Address("Kazan", "Gagarin", 55, 61)));
        profile.add(new Profile(new Address("Kazan", "Gagarin", 155, 161)));
        List<Address> chechList = new ArrayList<>();
        chechList.add(new Address("Kazan", "Gagarin", 55, 61));
        chechList.add(new Address("Krasnodar", "Red", 78, 56));
        chechList.add(new Address("Moscow", "Arbat", 99, 100));
        List<Address> result = Profiles.sortAddress(profile);
        assertThat(chechList.equals(result), is(true));
    }
}
