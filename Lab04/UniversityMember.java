/**
 * @author : Jeremy Brothers
 * @version: 9/21/2018
 * Title: Project 2
 * Description: This class extends the Person class
 *              it adds an id number. It includes functions to see 
 *              if objects of any type match with this class.
 */

public class UniversityMember extends Person {
    private String idNumber = "";

    /**
     * Constructor that calls Person constructor and passes the name, and age.
     * @param name: the members name
     * @param age: the members age
     * @param idNumber: the members id number
     */
    public UniversityMember(String name, int age, String idNumber) { 
        super(name, age); 
        this.idNumber = idNumber;
    }

    @Override
    /**
     * This function examines the incomming object against an instance of this class
     * it retruns true if the objects match, else they return false
     * @param object - an object that will be examined against an instance of this class
     * @return true if the gpa values match, else false.
     */
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        UniversityMember um = (UniversityMember) object;
        return idNumber.equals(um.idNumber);
     }

    @Override
    /**
     * This function generates a number to compare against
     * @return hash - the hash number
     */
    public int hashCode() { 
        int hash = 7;
        hash = 31 * super.hashCode();
        hash = 31 * idNumber.hashCode();
        return hash;
    }

    @Override
    /**
     * calls parents toString method and concantonates the private members of this
     * class
     * @return studentData: a string that will display the member data
     */
    public String toString() { 
        final String umData = super.toString() + "idNumber:" + idNumber + "\n";
        return umData;
    }

    /**
     * Sets the members id number
     * @param gpa: the members id numbere
     */
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    /**
     * Returns the members id number
     * @return gpa: the members id number
     */
    public String getIdNumber() { return idNumber; }
}