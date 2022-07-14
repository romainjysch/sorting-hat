package ch.heg.ig.sda.business;

import java.util.Objects;

public class Professor extends Character{

    private final String FIELD; // Domaine de compétence pour chaque professeur

    public Professor(String field) {
        super();
        this.FIELD = field;
    }

    public String getField() {
        return FIELD;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + FIELD + ")";
    }

    // Redéfinition de la méthode equals() afin que deux instances qui sont les mêmes pour l'humain soient également les mêmes pour la machine
    // Sinon, deux mêmes objets pour l'humain auront des références différentes pour la machine
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return getFirstName().equals(professor.getFirstName()) &&
                getLastName().equals(professor.getLastName()) &&
                getGender() == professor.getGender() &&
                getJob().equals(professor.getJob())  &&
                getBloodStatus() == professor.getBloodStatus() &&
                getField().equals(professor.getField());
    }

    // Comme equals() a été redéfini, il est nécessaire de faire de même avec la méthode hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGender(), getJob(), getBloodStatus(), getField());
    }

}
