package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в коллекцию пользователей и счетов.
     *
     * @param user добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет новый счет пользователю
     *
     * @param passport id пользователя
     * @param account  acc для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream().filter(
                user -> user.getPassport().equals(passport)).findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> list = users.get(user);
        return list.stream().filter(
                account -> account.getRequisite().equals(requisite)).findFirst().orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String s, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, s);
        if (accountSrc != null && accountDest != null) {
            if (!(accountSrc.getBalance() < amount)) {
                accountSrc.setBalance(accountSrc.getBalance() - amount);
                accountDest.setBalance(accountDest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}