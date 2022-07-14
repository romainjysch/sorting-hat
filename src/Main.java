import ch.heg.ig.sda.business.Hogwarts;
import ch.heg.ig.sda.business.HouseName;

public class Main {

    public static void main(String[] args) {

        // Insérer l'URL absolue vers le fichier Characters.csv :
        String charactersFilePath = "Insert path to the project here/Harry-Potter_Sorting-Hat/data/Characters.csv";

        // Instancie l'école avec le fichier CSV dans le constructeur :
        Hogwarts hogwarts = new Hogwarts(charactersFilePath);

        // Affiche la cérémonie du Choixpeau magique :
        System.out.println(hogwarts.sortingHat());

        // Décommenter afin d'afficher des informations sur chaque maison :
        /*
        System.out.println(hogwarts.showHouse(HouseName.Gryffindor));
        System.out.println(hogwarts.showHouse(HouseName.Ravenclaw));
        System.out.println(hogwarts.showHouse(HouseName.Hufflepuff));
        System.out.println(hogwarts.showHouse(HouseName.Slytherin));
        */

    }

}