package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (!list.contains(account)) {
            list.add(account);
        } else {
            System.out.println("This account is present");
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()
        ) {
            if (user.getPassport().equals(passport)) {
                return user;
            } else {
                System.out.println("no find User");
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account acc : list
        ) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            } else {
                System.out.println("no find Account");
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, dеstRequisite);
        if (!(accountSrc.getBalance() < amount)) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}