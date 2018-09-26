/**
 * @author : Jeremy Brothers
 * @version: 9/21/2018
 * Title: Project 2
 * Description: This class defines a basic person with a name
 *              and age. It includes functions to see 
 *              if objects of any type match with this class.
 */

public class Person {
    private String name = "";
    private int age = 0;

    /**
     * Constructor that takes a name and an age used to deffine an basic person
     * @param name the persons name
     * @param age the persons age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Sets the persons name
     * @param name - the persons name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the persons name
     * @return name: the name of the person
     */
    public String getName() { return name; }
    
    /**
     * Sets the person age
     * @param age the persons age
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Gets the age of the person
     * @return age - the age of the person
     */
    public int getAge() { return age; }

    @Override
    /**
     * Returns true if the in comming object's name and age match an instance of
     * this class
     * @return true if ages match, false otherwise
     */
    public boolean equals(Object object) {
        Person p = (Person) object;
        return age == p.age && name.equals(p.name);
    }

    @Override
    /**
     * This function generates a number to compare against
     * @return hash - the hash number
     */
    public int hashCode() {
        int hash = 11;
        hash = 31 * hash * age;
        hash = 31 * hash * name.hashCode(); 
        return hash;
    }

    @Override
    /**
     * calls parents toString method and concantonates the private members of this
     * class
     * @return studentData: a string that will display the member data
     */
    public String toString() { 
        final String personData = "Name: " + name + "\n" + "Age: " + age + "\n";
        return personData;
     }
}