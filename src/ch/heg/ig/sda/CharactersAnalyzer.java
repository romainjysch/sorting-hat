package ch.heg.ig.sda;

import ch.heg.ig.sda.business.Character;
import ch.heg.ig.sda.io.CharactersCsvDatabaseLoader;

import java.util.Collection;

public class CharactersAnalyzer implements ICharactersAnalyzer{

    private Collection<Character> characters;

    @Override
    public void loadCharacters(String filepath) {
        CharactersCsvDatabaseLoader loader = new CharactersCsvDatabaseLoader(filepath);
        loader.process();
        this.characters = loader.getCharacter();
    }

    @Override
    public Collection<Character> getCharacters() {
        return characters;
    }

}