package ru.job4j.review;




import java.util.*;


public class Bank {
    private Map<User, ArrayList<Account>> treemap = new HashMap<>();
    private User usert;

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

    private int getActualAccount(User user, String requisite) {
        ArrayList<Account> list = this.treemap.get(user);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).reqs.equals(requisite)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean findFromPassport(String passport) {
        boolean result = false;
        for (User us : this.treemap.keySet()) {
            if (Integer.parseInt(passport) == us.hashCode()) {
                usert = us;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        if (findFromPassport(srcPassport)) {
            User src = usert;
            findFromPassport(destPassport);
            User dest = usert;
           return this.treemap.get(src).get(getActualAccount(src, srcRequisite)).transfer(this.treemap.get(dest).get(getActualAccount(dest, dstRequisite)), amount);
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