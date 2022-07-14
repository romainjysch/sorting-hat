package ch.heg.ig.sda.business;

import java.util.Collection;

// Cette interface définit le cahier des charges de l'application de manière abstraite :
public interface IHogwarts {

    // Load du fichier CSV de caractères dans une Collection de type Character :
    Collection<Character> loadCharacters(String charactersFilePath);

    // Cérémonie du Choixpeau magique et attribution des maisons aux élèves :
    String sortingHat();

    // Afficher, pour une maison demandée, son fondateur, son directeur et la liste de ses élèves :
    String showHouse (HouseName houseName);

}
