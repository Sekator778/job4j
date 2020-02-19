package ru.job4j.oop.profession;

public class Doctor extends Profession {
    public String namePacient;
    public String diagnose;

    public String getDiagnose(String namePacient) {
        return diagnose + this.getName();
    }

}
