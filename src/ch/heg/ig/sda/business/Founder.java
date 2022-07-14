package ch.heg.ig.sda.business;

import java.util.Objects;

public class Founder extends Character{

    private final String RELIC;

    // Comme les fondateurs ne sont pas importés avec le CSV, nous allons les créer nous-mêmes
    public Founder(String relic) {
        super();
        this.RELIC = relic;
    }

    public String getRelic() {
        return RELIC;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + RELIC + ")";
    }

    // Redéfinition de la méthode equals() afin que deux instances qui sont les mêmes pour l'humain soient également les mêmes pour la machine
    // Sinon, deux mêmes objets pour l'humain auront des références différentes pour la machine
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Founder)) return false;
        Founder founder = (Founder) o;
        return getFirstName().equals(founder.getFirstName()) &&
                getLastName().equals (founder.getLastName()) &&
                getGender() == founder.getGender() &&
                getJob().equals(founder.getJob())  &&
                getBloodStatus() == founder.getBloodStatus() &&
                getRelic().equals(founder.getRelic());
    }

    // Comme equals() a été redéfini, il est nécessaire de faire de même avec la méthode hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGender(), getJob(), getBloodStatus(), getRelic());
    }

}
