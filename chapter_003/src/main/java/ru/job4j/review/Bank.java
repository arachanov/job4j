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

    private Account getActualAccount(User user, String requisite) {
        /*ArrayList<Account> list = this.treemap.get(user);
        Account result = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).reqs.equals(requisite)) {
                result = list.get(i);
                break;
            }
        }*/
        return this.treemap.get(user).stream().filter(x -> x.reqs.equals(requisite)).findAny().get();
    }

    private User findFromPassport(String passport) {
        /*User result = null;
        for (User us : this.treemap.keySet()) {
            if (us.getPassport().equals(passport)) {
                result = us;
                break;
            }
        }
        return result;*/
       return this.treemap.keySet().stream().filter(x -> x.getPassport().equals(passport)).findAny().get();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        Account source = getActualAccount(findFromPassport(srcPassport), srcRequisite);
        Account destination = getActualAccount(findFromPassport(destPassport), dstRequisite);
        if (source != null && destination != null) {
           return source.transfer(destination, amount);
       } else {
            System.out.println("Перевод не выполнен! Такого пользователя не существует");
            return false;
        }
    }


    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}