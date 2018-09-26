/**
 * @author : Jeremy Brothers
 * @version: 9/21/2018
 * Title: Project 2
 * Description: This class extends the UniversityMember class
 *              it adds an office location. It includes functions to see 
 *              if objects of any type match  match with this class.
 */

public class Professor extends UniversityMember {
    private String officeLocation = "";

    /**
     * Constructor that calls Person constructor and passes the name, age,
     * and id number.
     * @param name: the teachers name
     * @param age: the teachers age
     * @param idNumber: the teachers id number
     * @param officeLocation: the teachers offic location
     */
    public Professor(String name, int age, String idNumber, String officeLocation) { 
        super(name, age, idNumber);
        this.officeLocation = officeLocation;
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
        Professor professor = (Professor) object;
        return officeLocation.equals(professor.officeLocation);
     }

    @Override
    /**
     * This function generates a number to compare against
     * @return hash - the hash number
     */
    public int hashCode() { 
        int hash = 11;
        hash = 31 * super.hashCode();
        hash = 31 * officeLocation.hashCode();
        return hash;
    }

    @Override
    /**
     * calls parents toString method and concantonates the private members of this
     * class
     * @return studentData: a string that will display the member data
     */
    public String toString() { 
        final String professorData = super.toString() + "Office Location: " + officeLocation + "\n";
        return professorData;
    }

    /**
     * Sets the teachers office location
     * @param gpa: theteachers office location
     */
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
    
    /**
     * Returns the teachers office location
     * @return gpa: the teachers office location
     */
    public String getOfficeLocation() { return officeLocation; }
}