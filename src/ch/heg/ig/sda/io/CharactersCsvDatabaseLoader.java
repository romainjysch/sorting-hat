package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.business.Character;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import static ch.heg.ig.sda.io.FileDatabaseUtils.findColumnIndex;

public class CharactersCsvDatabaseLoader extends CharactersDatabaseLoader {

    public CharactersCsvDatabaseLoader(final String filepath) {
        super(filepath);
    }

    public void process() {
        this.characters = loadCleanDatabase(filepath);
    }

    private Collection<Character> loadCleanDatabase(final String filename){
        List<String[]> cleanedDatabase = ParserUtils.parseCSV(filename);
        return parseDocumentsDatabase(cleanedDatabase);
    }

    private Collection<Character> parseDocumentsDatabase(List<String[]> cleanedDatabase){
        int firstNameColumnIndex = findColumnIndex(cleanedDatabase.get(0), CharacterCsvConstant.FIRSTNAME.getColumnName());
        int lastNameColumnIndex = findColumnIndex(cleanedDatabase.get(0), CharacterCsvConstant.LASTNAME.getColumnName());
        int genderColumnIndex = findColumnIndex(cleanedDatabase.get(0), CharacterCsvConstant.GENDER.getColumnName());
        int jobColumnIndex = findColumnIndex(cleanedDatabase.get(0), CharacterCsvConstant.JOB.getColumnName());
        int bloodStatusColumnIndex = findColumnIndex(cleanedDatabase.get(0), CharacterCsvConstant.BLOODSTATUS.getColumnName());

        int notFoundColumnIndex = -1;

        int startIndex = 1; // Skip header

        // The size is known in advance, prevent ArrayList unnecessary grow
        Collection<Character> characters = new ArrayList<>(cleanedDatabase.size() - 1);

        for (int i = startIndex; i < cleanedDatabase.size(); i++) {
            Character character = null;

            if(cleanedDatabase.get(i)[jobColumnIndex].equals("Student")){
                // Instanciation en tant que Student, pour pouvoir caster par la suite
                // Ce n'est pas possible de caster une instance de type Character en Student
                // L'inverse est possible
                character = new Student();
            }
            else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Professor")){
                // Instanciation en tant que Professor, pour pouvoir caster par la suite
                // Ce n'est pas possible de caster une instance de type Character en Professor
                if (cleanedDatabase.get(i)[jobColumnIndex].contains("Potions"))
                    character = new Professor("Potions");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Dark"))
                    character = new Professor("Dark Arts");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Divination"))
                    character = new Professor("Divination");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Muggle"))
                    character = new Professor("Muggle Studies");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Creatures"))
                    character = new Professor("Care of Magical Creatures");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Herbology"))
                    character = new Professor("Herbology");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Charms"))
                    character = new Professor("Charms");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Transfiguration"))
                    character = new Professor("Transfiguration");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("History"))
                    character = new Professor("History or Magic");
                else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Arithmancyat"))
                    character = new Professor("Arithmancyat");
                else
                    character = new Professor("Other");
            }
            else if (cleanedDatabase.get(i)[jobColumnIndex].contains("Founder")){
                // Instanciation en tant que Founder, pour pouvoir caster par la suite
                // Ce n'est pas possible de caster une instance de type Character en Founder
                switch (cleanedDatabase.get(i)[lastNameColumnIndex]) {
                    case "Gryffindor" : character = new Founder("Sword of Gryffindor");
                        break;
                    case "Ravenclaw" :  character = new Founder("Ravenclaw's Diadem");
                        break;
                    case "Hufflepuff" : character = new Founder("Hufflepuff's Cup");
                        break;
                    case "Slytherin" :  character = new Founder("Slytherin's Locket");
                        break;
                }
            }
            else {
                continue; // Passe à l'itération suivante de la boucle, car le caractère
                // ne respecte pas les conditions requises pour être instancié
                // comme étudiant, professeur ou fondateur. On ne traite donc pas ces données.
            }

            try {
                if(firstNameColumnIndex != notFoundColumnIndex) {
                    character.setFirstName(cleanedDatabase.get(i)[firstNameColumnIndex]);
                }
                if(lastNameColumnIndex != notFoundColumnIndex) {
                    character.setLastName(cleanedDatabase.get(i)[lastNameColumnIndex]);
                }
                // Getting valueOf Gender enumeration
                if(genderColumnIndex != notFoundColumnIndex) {
                    character.setGender(Gender.valueOf(cleanedDatabase.get(i)[genderColumnIndex]));
                }
                if(jobColumnIndex != notFoundColumnIndex) {
                    character.setJob(cleanedDatabase.get(i)[jobColumnIndex]);
                }
                // Getting valueOf BloodStatus enumeration
                if(bloodStatusColumnIndex != notFoundColumnIndex) {
                    character.setBloodStatus(BloodStatus.valueOf(cleanedDatabase.get (i)[bloodStatusColumnIndex]));
                }
            } catch (NullPointerException e) {
                System.out.println("Une exception NullPointerException a été détectée.");
            }

            characters.add(character);

        }

        return characters;

    }

    /**
     * Parse data by a separator.
     * @param data Data to parse
     * @param separator Separator
     * @return Parsed data
     */
    private static List<String> parse(final String data, final String separator){
        List<String> elements = new ArrayList<>();
        if(data != null && data.length() > 0) {
            for(String element : data.split(separator)){
                elements.add(element.trim());
            }
        }
        return elements;
    }
}