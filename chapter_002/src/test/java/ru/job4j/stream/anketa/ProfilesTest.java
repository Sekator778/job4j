package ru.job4j.stream.anketa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    Address address0 = new Address("Boston", "1 avenue", 23, 8);
    Address address1 = new Address("Kalyga", "Krulova", 4, 1);
    Address address2 = new Address("Harkov", "Tolstogo", 23, 8);
    Address address21 = new Address("Harkov", "Tolstogo", 23, 8);
    Address address3 = new Address("Moskov", "Levaya", 7, 67);
    Address address31 = new Address("Moskov", "Levaya", 7, 67);
    Profile profile0 = new Profile(address0);
    Profile profile1 = new Profile(address1);
    Profile profile2 = new Profile(address2);
    Profile profile21 = new Profile(address21);
    Profile profile3 = new Profile(address3);
    Profile profile31 = new Profile(address31);
    private final List<Profile> profiles = new ArrayList<>(Arrays.asList(
            profile0,
            profile1,
            profile2,
            profile21,
            profile3,
            profile31
    ));
    @Test
    public void getListAdress() {
        List<Address> result = new Profiles().collect(profiles);
        List<Address> expected = new ArrayList<>(Arrays.asList(
                address0,
                address1,
                address2,
                address21,
                address3,
                address31
        ));
        assertThat(result, is(expected));
    }

    @Test
    public void getListAdressUnique() {
        List<Address> result = new Profiles().collectUnique(profiles);
        List<Address> expected = new ArrayList<>(Arrays.asList(
                address0,
                address2,
                address1,
                address3
        ));
        assertThat(result, is(expected));
    }



}
