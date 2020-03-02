package ru.job4j.stream.anketa;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    public List<Address> collectUnique(List<Profile> profiles) {
        return collect(profiles).stream()
                .sorted(new AddressCompare())
                .distinct()
                .collect(Collectors.toList());
    }
}
