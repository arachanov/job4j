package ru.job4j.review;




import java.util.*;


public class Bank {
    private Map<User, ArrayList<Account>> treemap = new HashMap<>();

    public void addUser(User user) {
        this.treemap.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.treemap.forEach((user, accounts) -> {
            if (user.getPassport() == passport) {
                accounts.add(account);
            }
        });
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.treemap.forEach((user, accounts) -> {
            if (user.getPassport() == passport) {
                accounts.remove(account);
            }
        });
    }

    public List<Account> getUserAccounts(String passport) {
        return this.treemap.get(passport);
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Set<User> users = this.treemap.keySet();
        for (User user : users) {
            if (user.getPassport() == srcPassport) {
                for (int i = 0; i != this.treemap.get(user).size(); i++) {
                   if ((this.treemap.get(user).get(i).reqs == srcRequisite) & this.treemap.get(user).get(i).values >= amount) {
                       for (User user1 : users) {
                           if (user1.getPassport() == destPassport) {
                               for (int j = 0; j < this.treemap.get(user1).size(); j++) {
                                   if (this.treemap.get(user1).get(j).reqs == dstRequisite) {
                                       result = this.treemap.get(user).get(i).transfer(this.treemap.get(user1).get(j), amount);
                                       break;
                                   }
                               }
                           }
                       }
                   }
                }
            }
        }
        return result;
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                                 User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }
    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}