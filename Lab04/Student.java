/**
 * @author : Jeremy Brothers
 * @version: 9/21/2018
 * Title: Project 2
 * Description: This class extends the UniversityMember class
 *              it adds a gpa. It includes functions to see 
 *              if objects of any type match  match with this class.
 */

public class Student extends UniversityMember {
    private Double gpa = 0.0;

    /**
     * Constructor that calls the constructor for UniversityMemeber using
     * name, age, and idNumber.
     * @param name: a students name
     * @param age: a students age
     * @param idNumber: a students idNumber
     * @param gpa: a students grade point average
     */
    public Student(String name, int age, String idNumber, Double gpa) { 
        super(name, age, idNumber);
        this.gpa = gpa;
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

        // cast the object to be type of student
        Student student = (Student) object;
        return gpa.equals(student.gpa);
     }

    @Override
    /**
     * This function generates a number to compare against
     * @return hash - the hash number
     */
    public int hashCode() { 
        int hash = 11;
        hash = 31 * super.hashCode();
        hash = 31 * gpa.hashCode();
        return hash;
    }

    @Override
    /**
     * calls parents toString method and concantonates the private members of this
     * class
     * @return studentData: a string that will display the student data
     */
    public String toString() { 
        final String studentData = super.toString() + "Gpa: " + gpa + "\n";
        return studentData; 
    }

    /**
     * Sets the students gpa
     * @param gpa: the students grade point average
     */
    public void setGpa(double gpa) { this.gpa = gpa; }

    /**
     * Returns the students gpa
     * @return gpa: the students grade point average
     */
    public double getGpa() { return gpa; }
}