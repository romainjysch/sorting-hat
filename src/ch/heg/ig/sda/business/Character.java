package ch.heg.ig.sda.business;

import java.util.Objects;

// Cette classe est abstraite car on ne souhaite pas instancier d'objet Character, mais uniquement instancier les classes qui en héritent :
public abstract class Character {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String job;
    private BloodStatus bloodStatus;

    public Character() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BloodStatus getBloodStatus() {
        return bloodStatus;
    }

    public void setBloodStatus(BloodStatus bloodStatus) {
        this.bloodStatus = bloodStatus;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + gender + ") (" + bloodStatus + ") ";
    }

    // Redéfinition de la méthode equals() afin que deux instances qui sont les mêmes pour l'humain soient également les mêmes pour la machine
    // Sinon, deux mêmes objets pour l'humain auront des références différentes pour la machine
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return getFirstName().equals(character.getFirstName()) &&
                getLastName().equals(character.getLastName()) &&
                getGender() == character.getGender() &&
                getJob().equals (character.getJob()) &&
                getBloodStatus() == character.getBloodStatus();
    }

    // Comme equals() a été redéfini, il est nécessaire de faire de même avec la méthode hashCode() :
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGender(), getJob(), getBloodStatus());
    }

}
