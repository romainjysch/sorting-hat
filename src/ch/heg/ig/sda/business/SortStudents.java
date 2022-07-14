package ch.heg.ig.sda.business;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class SortStudents implements Comparator<Student> {

    // Méthode qui va comparer nos deux objets de type Student
    // Utilisation de la library Guava de Google avant de faciliter l'écriture de cette méthode
    @Override
    public int compare(Student stu1, Student stu2) {

        // Deuxième version, plus optimale suite aux conseils du prof :
        return ComparisonChain.start().compare(stu1.getLastName(), stu2.getLastName())
                .compare(stu1.getFirstName(), stu2.getFirstName())
                .compare(stu1.getGender(), stu2.getGender())
                .compare(stu1.getJob(), stu2.getJob())
                .compare(stu1.getBloodStatus(), stu2.getBloodStatus())
                .compare(stu1.getValor(), stu2.getValor())
                .result();


        // Première version :
        /*
        if (stu1.getLastName().compareTo(stu2.getLastName()) != 0) { // Si pas le même lastName
            return stu1.getLastName().compareTo(stu2.getLastName());
        }
        else if (stu1.getFirstName().compareTo(stu2.getFirstName()) != 0) { // Si pas le même lastName et firstName
            return stu1.getFirstName().compareTo(stu2.getFirstName());
        }
        else if (stu1.getGender().compareTo(stu2.getGender()) != 0) { // ...
            return stu1.getGender().compareTo(stu2.getGender());
        }
        else if (stu1.getJob().compareTo(stu2.getJob()) != 0) {
            return stu1.getJob().compareTo(stu2.getJob());
        }
        else if (stu1.getBloodStatus().compareTo(stu2.getBloodStatus()) != 0) {
            return stu1.getBloodStatus().compareTo(stu2.getBloodStatus());
        }
        else if (stu1.getValor().compareTo(stu2.getValor()) != 0) {
            return stu1.getValor().compareTo(stu2.getValor());
        }
        else {
            return 0;
        }
        */

    }
}
