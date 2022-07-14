package ch.heg.ig.sda;

import ch.heg.ig.sda.business.Character;

import java.util.Collection;

public interface ICharactersAnalyzer {

    void loadCharacters(String filepath);

    Collection<Character> getCharacters();
}