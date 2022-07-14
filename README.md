# Harry Potter Sorting Hat

## Context

During my second year of Bachelor in Business Information Technology, I had a data structures course. At the end of the semester, we did a group project in order to practice what we've learned. We have been evaluated on release 2.0 and the project was realized in several weeks, next to our main job.

## Use cases

The topic of the project was free. Lovers of Harry Potter, we decided to simulate a case concerning the saga. The sorting hat artefact being aged, Hogwarts asked us to develop an application to realize the distribution of the new students into one of the four house. Thanks to our application, he will be able to take a well deserved retirement. Here are some explanations :

- You have to insert the folder path of the project into the Main.java file before running
- The instantiation of the Hogwarts object will do the following things :
  1. A Collection will be created with characters from the CSV file
  2. Differents data structures will be created in order to store Students (TreeSet), Professors (HashSet) and Founders (HashMap)
  3. Thanks to the Collection and according to the job column of the CSV file, each character will be stored in one of the data structures
  4. Last but not least, the four houses will be instantiated with an ArrayList

- The welcome ceremony will be printed and the students will be assigned to an house according to their own value
- If wanted, information about every single house can be displayed

## Instructions for the project

- Present a case that involves one or more data structures
- Only use data structures provided by the java.util package
- The data structure choice must be justified (our Word documentation is not available on this repository)
- An analysis of the complexity must be presented
- A temporal analysis must be presented
- If needed, create your own set of data (a CSV file in our case)

## Resources

- Schoolmates
- Teacher
- Data structures course material
- Oracle Java Documentation https://docs.oracle.com/en/java/index.html
- W3School Java https://www.w3schools.com/java/
- Java, A Beginner's Guide https://www.oreilly.com/library/view/java-a-beginners/9780071606325/
- Stackoverflow Big-O Summary https://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations
- Stackoverflow Compare Objects by Multiple Fields https://stackoverflow.com/questions/369512/how-to-compare-objects-by-multiple-fields
- Collections.sort() in Java https://www.geeksforgeeks.org/collections-sort-java-examples/
- Google Guava https://github.com/google/guava
- Mockaroo https://www.mockaroo.com/
