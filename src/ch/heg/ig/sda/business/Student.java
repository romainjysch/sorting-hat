package ch.heg.ig.sda.business;

import java.util.*;

public class Student extends Character {

    // Valeur personnelle de chaque étudiant :
    private final Valor VALOR;
    // Afin de générer une valeur aléatoirement lors du constructeur de cette classe :
    private static final List<Valor> VALUES = Collections.unmodifiableList(Arrays.asList(Valor.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public Student() {
        super();
        this.VALOR = randomValor();
    }

    private static Valor randomValor() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public Valor getValor() {
        return VALOR;
    }

    // Les 5 prochaines méthodes permettent d'utiliser la notion d'encapsulation lors de l'utilisation de la méthode sortingHat() de la classe Hogwarts :
    public boolean isPureBloodOrHalfBlood() {
        if (this.getBloodStatus() == BloodStatus.PureBlood || this.getBloodStatus() == BloodStatus.HalfBlood)
            return true;
        else
            return false;
    }

    public boolean isBraveryOrCourage() {
        if (this.getValor() == Valor.Bravery || this.getValor() == Valor.Courage)
            return true;
        else
            return false;
    }

    public boolean isIntelligenceOrWisdom() {
        if (this.getValor() == Valor.Intelligence || this.getValor() == Valor.Wisdom)
            return true;
        else
            return false;
    }

    public boolean isJustOrPatience() {
        if (this.getValor() == Valor.Just || this.getValor() == Valor.Patience)
            return true;
        else
            return false;
    }

    public boolean isAmbitiousOrNerve() {
        if (this.getValor() == Valor.Ambitious || this.getValor() == Valor.Nerve)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + "(" + VALOR + ")";
    }

    // Redéfinition de la méthode equals() afin que deux instances qui sont les mêmes pour l'humain soient également les mêmes pour la machine
    // Sinon, deux mêmes objets pour l'humain auront des références différentes pour la machine
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getFirstName().equals(student.getFirstName ()) &&
                getLastName().equals(student.getLastName ()) &&
                getGender() == student.getGender() &&
                getJob().equals(student.getJob ()) &&
                getBloodStatus() == student.getBloodStatus() &&
                getValor() == student.getValor();
    }

    // Comme equals() a été redéfini, il est nécessaire de faire de même avec la méthode hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getGender(), getJob(), getBloodStatus(), getValor());
    }

}
