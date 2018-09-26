public class PersonDriver {
    public static void main(String[] args) {
        final int SIZE = 4;
        // Create two Person arrays
        Person[] personArray = new Person[SIZE];
        personArray[0] = new Person("name", 20);
        personArray[1] = new UniversityMember("name2", 20, "001");
        personArray[2] = new Student("name3", 20, "002", 3.2);
        personArray[3] = new Professor("name4", 20, "003", "officeLocation");

        Person[] personArray2 = new Person[SIZE];
        personArray2[0] = new Person("name4", 21);
        personArray2[1] = new UniversityMember("name5", 21, "002");
        personArray2[2] = new Student("name6", 21, "004", 1.2);
        personArray2[3] = new Professor("name4", 20, "003", "officeLocation");

        // Print the arrays
        printPersons(personArray);
        printPersons(personArray2);

        // Check variour elements of each person array
        equals(personArray[0], personArray[0]);
        equals(personArray[0], personArray2[0]);
        equals(personArray2[1], personArray2[1]);
        equals(personArray[3], personArray2[3]);
    }

    /**
     * Prints the contents of the person array
     * @param person : an array of type person.
     */
    public static void printPersons(Person[] person) {
        for(Person element : person) {
            System.out.println(element.toString());
        }
    }

    /**
     * Checks to see if the two person objects are equal to each other
     * @param leftPerson the first person object to compare
     * @param rightPerson the second person object to compare
     */
    public static void equals(Person leftPerson, Person rightPerson) {
        if(leftPerson.equals(rightPerson)) 
            System.out.println("These objects match!");
        else
            System.out.println("Theses objects do not match!");

        checkHashCode(leftPerson, rightPerson);
    }

    /**
     * Checks to see if the two person objects have the same hash code
     * @param leftPerson the first person object to compare
     * @param rightPerson the second person object to compare
     */
    public static void checkHashCode(Person leftPerson, Person rightPerson){
        if(leftPerson.hashCode() != rightPerson.hashCode())
            System.out.println("warning hash codes do not match");
        else
            System.out.println(leftPerson.hashCode() + " matches " + rightPerson.hashCode());
    }

}