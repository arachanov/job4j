package ru.job4j.review;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BankTest {
    @Test
    public void addUserTest() {
        Bank bank = new Bank();
        User user1 = new User("252200000", "Leo");
        User user2 = new User("252201001", "Luis");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), new Account(1000000, "1977"));
        bank.addAccountToUser(user2.getPassport(), new Account(10, "1985"));
        boolean result = bank.transferMoney(user1.getPassport(), "1977", user2.getPassport(), "1985", 1000);
        assertThat(result, is(true));
    }
}
