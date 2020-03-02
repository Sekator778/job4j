package ru.job4j.stream.anketa;

import java.util.Comparator;

public class AddressCompare implements Comparator<Address> {

    @Override
    public int compare(Address o1, Address o2) {
        int rsl =  o1.getCity().compareTo(o2.getCity());
        if (rsl == 0) {
            rsl = o1.getStreet().compareTo(o2.getStreet());
        }
        if (rsl == 0) {
            rsl = o1.getHome() - o2.getHome();
        }
        return rsl;
    }
}
