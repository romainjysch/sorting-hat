package ch.heg.ig.sda.business;

import ch.heg.ig.sda.ICharactersAnalyzer;
import ch.heg.ig.sda.CharactersAnalyzer;
import java.util.*;

public class Hogwarts implements IHogwarts{

    private SortedSet<Student> tmpStudents; // Pour implémenter TreeSet et y stocker de manière temporaire les nouveaux élèves
    private Set<Professor> professors; // Pour implémenter HashSet et y stocker les professeurs
    private Map<String, Founder> founders; // Pour implémenter HashMap et y stocker les fondateurs

    private House gryffindor;
    private House ravenclaw;
    private House hufflepuff;
    private House slytherin;

    // Constructeur Hogwarts, qui est appelé depuis la classe Main :
    public Hogwarts(String charactersFilePath) {

        try {
            // Load du fichier CSV de caractères dans une Collection de type Character :
            Collection<Character> characters = loadCharacters(charactersFilePath);

            // Création de différentes structures afin d'y stocker des élèves, professeurs et fondateurs :
            createStructures(characters);

            // Création des quatre maisons, dans lesquelles le Choixpeau magique va attribuer des élèves :
            createHouses();
        } catch (IllegalArgumentException e) {
            System.out.println("L'URL absolue du fichier CSV n'est pas correct.");
        }

    }

    // Application concrète de la méthode loadCharacters :
    @Override
    public Collection<Character> loadCharacters(String charactersFilePath) {
        ICharactersAnalyzer analyzer = new CharactersAnalyzer(); // Instancie un objet de type CharacterAnalyzer
        analyzer.loadCharacters(charactersFilePath);
        Collection<Character> characters;
        characters = analyzer.getCharacters();
        return characters;
    }

    // Création de différentes structures afin d'y stocker des élèves, professeurs et fondateurs :
    public void createStructures(Collection<Character> characters) {
        // Instanciation de trois structures de données :
        //  1. TreeSet d'étudiants dans le but de les trier par ordre alphabétique et également gérer l'unicité grâce à la redéfinition de equals() et hashCode()
        //  2. HashSet d'enseignants car ils n'ont pas besoin d'être triés, mais nous souhaitons gérer l'unicité grâce à la redéfinition de equals() et hashCode()
        //  3. HashMap de fondateurs pour accéder à leur Valeur grâce à une Clé de type String
        tmpStudents = new TreeSet<Student>(new SortStudents()); // Instanciation de la classe CompareStudent dans le constructeur pour définir comme le TreeSet sera trié
        professors = new HashSet<Professor>();
        founders = new HashMap<String, Founder>();

        // Ajout des différents caractères dans les trois structures de données fraichement créées :
        try {
            for(Character character : characters) {
                if(character instanceof Student){
                    tmpStudents.add((Student) character);
                }
                else if(character instanceof Professor) {
                    professors.add((Professor) character);
                }
                else if(character instanceof Founder) {
                    founders.put(character.getLastName(),(Founder) character);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Suite à la mauvaise URL, un NullPointerException est levé.");
        }

    }

    // Création des quatre maisons, dans lesquelles le Choixpeau magique va attribuer des élèves :
    public void createHouses(){
        // Création de variables temporaires de type Professor afin de les utiliser dans le constructeur de House :
        Professor tmpDirGryffindor = null;
        Professor tmpDirRavenClaw = null;
        Professor tmpDirHufflepuff = null;
        Professor tmpDirSlytherin = null;

        // Boucle parcourant le HashSet de Professor afin de sélectionner les quatre directeurs de maison :
        for(Professor professor : professors) {
            if(professor.getFirstName().equals("Minerva") && professor.getLastName().equals("McGonagall"))
                tmpDirGryffindor = professor;
            else if(professor.getFirstName().equals("Filius") && professor.getLastName().equals("Flitwick"))
                tmpDirRavenClaw = professor;
            else if(professor.getFirstName().equals("Pomona") && professor.getLastName().equals("Sprout"))
                tmpDirHufflepuff = professor;
            else if(professor.getFirstName().equals("Severus") && professor.getLastName().equals("Snape"))
                tmpDirSlytherin = professor;
        }

        // Instanciation des quatre maisons via la constructeur de la classe House :
        gryffindor = new House(HouseName.Gryffindor, tmpDirGryffindor, founders.get("Gryffindor"));
        ravenclaw = new House(HouseName.Ravenclaw, tmpDirRavenClaw, founders.get("Ravenclaw"));
        hufflepuff = new House(HouseName.Hufflepuff, tmpDirHufflepuff, founders.get("Hufflepuff"));
        slytherin = new House(HouseName.Slytherin, tmpDirSlytherin, founders.get("Slytherin"));

    }

    // Application concrète de la méthode sortingHat() :
    public String sortingHat() {
        try {
            // Création et construction d'un StringBuilder pour la cérémonie :
            StringBuilder sb = new StringBuilder();
            sb.append("— Bienvenue à Poudlard, dit le professeur McGonagall. Le banquet de début d'année va bientôt commencer, mais avant que vous preniez place dans la Grande Salle, vous allez être répartis dans les différentes maisons. Cette partition constitue une cérémonie très impor...\n");
            sb.append("\nÀ la grande stupéfaction des élèves, le Choixpeau interrompit McGonagall et se mit à chanter :\n" + "\n");
            sb.append("Je n'suis pas d'une beauté suprême\n" +
                    "\n" +
                    "Mais faut pas s'fier à ce qu'on voit\n" +
                    "\n" +
                    "Je veux bien me manger moi-même\n" +
                    "\n" +
                    "Si vous trouvez plus malin qu'moi\n" +
                    "\n" +
                    "Les hauts-d'forme, les chapeaux splendides\n" +
                    "\n" +
                    "Font pâl'figure auprès de moi\n" +
                    "\n" +
                    "Car à Poudlard, quand je décide,\n" +
                    "\n" +
                    "Chacun se soumet à mon choix.\n" +
                    "\n" +
                    "Rien ne m'échapp'rien ne m'arrête\n" +
                    "\n" +
                    "Le Choixpeau a toujours raison\n" +
                    "\n" +
                    "Mettez-moi donc sur votre tête\n" +
                    "\n" +
                    "Pour connaître votre maison.\n" +
                    "\n" +
                    "Si vous allez à Gryffondor\n" +
                    "\n" +
                    "Vous rejoindrez les courageux,\n" +
                    "\n" +
                    "Les plus hardis et les plus forts\n" +
                    "\n" +
                    "Sont rassemblés en ce haut lieu.\n" +
                    "\n" +
                    "Si à Poufsouffle vous allez,\n" +
                    "\n" +
                    "Comme eux vous s'rez juste et loyal\n" +
                    "\n" +
                    "Ceux de Poufsouffle aiment travailler\n" +
                    "\n" +
                    "Et leur patience est proverbiale.\n" +
                    "\n" +
                    "Si vous êtes sage et réfléchi\n" +
                    "\n" +
                    "Serdaigle vous accueillera peut-être\n" +
                    "\n" +
                    "Là-bas, ce sont des érudits\n" +
                    "\n" +
                    "Qui ont envie de tout connaître.\n" +
                    "\n" +
                    "Vous finirez à Serpentard\n" +
                    "\n" +
                    "Si vous êtes plutôt malin,\n" +
                    "\n" +
                    "Car ceux-là sont de vrais roublards\n" +
                    "\n" +
                    "Qui parviennent toujours à leurs fins.\n" +
                    "\n" +
                    "Sur ta tête pose-moi un instant\n" +
                    "\n" +
                    "Et n'aie pas peur, reste serein\n" +
                    "\n" +
                    "Tu seras en de bonnes mains\n" +
                    "\n" +
                    "Car je suis un chapeau pensant !\n" +
                    "\n");
            sb.append("Je vous remercie Choixpeau... Soupira le professeur McGonagall. Elle cria ensuite : \n");
            sb.append("- Quand j'appellerai votre nom, vous mettrez le chapeau sur votre tête et vous vous assiérez sur le tabouret. Je commence : \n");

            // Parcours du TreeSet de nouveaux élèves. En d'autres termes, le Choixpeau magique entre en action :
            for (Student newStudent : tmpStudents) {

                sb.append("\n- " + newStudent.getFirstName() + " " + newStudent.getLastName() + " !");

                if (newStudent.getLastName().equals("Weasley")) {
                    sb.append("\n- Argh, encore un Weasley ! Évidemment, GRYFFONDOR ! Dit le Choixpeau.\n");
                    gryffindor.students.add(newStudent);
                } else if (newStudent.isPureBloodOrHalfBlood() && newStudent.isAmbitiousOrNerve()) {
                    sb.append("\n- SERPENTARD ! Chuchota le Choixpeau.\n");
                    slytherin.students.add(newStudent);
                } else if (newStudent.isIntelligenceOrWisdom()) {
                    sb.append("\n- SERDAIGLE ! Cria le Choixpeau.\n");
                    ravenclaw.students.add(newStudent);
                } else if (newStudent.isBraveryOrCourage()) {
                    sb.append("\n- GRYFFONDOR ! S'exclama le Choixpeau.\n");
                    gryffindor.students.add(newStudent);
                } else if (newStudent.isJustOrPatience()) {
                    sb.append("\n- POUFSOUFFLE ! Souffla le Choixpeau.\n");
                    hufflepuff.students.add(newStudent);
                } else { // Va entrer dans ce else, tous les élèves qui sont isAmbitiousOrNerve() et de sang MuggleBorn
                    // Comme Serpentard n'accepte pas les sangs de bourbe, ces élèves sont ajoutés dans une autre maison de manière aléatoire :
                    Random random = new Random();
                    int randomBetween1And3 = random.nextInt(3) + 1;
                    switch (randomBetween1And3) {
                        case 1:
                            gryffindor.students.add(newStudent);
                            sb.append("\n- GRYFFONDOR ! S'exclama le Choixpeau.\n");
                            break;
                        case 2:
                            ravenclaw.students.add(newStudent);
                            sb.append("\n- SERDAIGLE ! Cria le Choixpeau.\n");
                            break;
                        case 3:
                            hufflepuff.students.add(newStudent);
                            sb.append("\n- POUFSOUFFLE ! Souffla le Choixpeau.\n");
                            break;
                    }
                }

            }

            tmpStudents.clear(); // Permet de vider le TreeSet temporaire, une fois que tous les élèves se sont vus attribuer une maison
            return sb.toString();

        } catch (NullPointerException e) {
            return "Une exception NullPointerException a été détectée.";
        }
    }

    // Application concrète de la méthode showHouse() :
    @Override
    public String showHouse(HouseName houseName) {

        House house = null;

        // Nous avons utilisé un objet de type HouseName en paramètre, car c'est plus propre pour appeler une maison
        // Ce switch permet de matcher le HouseName demandé avec une House :
        switch (houseName) {
            case Gryffindor : house = this.gryffindor;
                break;
            case Ravenclaw : house = this.ravenclaw;
                break;
            case Hufflepuff : house = this.hufflepuff;
                break;
            case Slytherin : house = this.slytherin;
                break;
        }

        // Création et construction d'un StringBuilder pour afficher les informations d'une maison :
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(house.getHouseName()).append(" :");
        sb.append("\nFondateur : ").append(house.getFounder());
        sb.append("\nDirecteur : ").append(house.getDirector());
        sb.append("\n");
        sb.append("\nListe des élèves : ");
        sb.append(house.students);

        return sb.toString();

    }

}