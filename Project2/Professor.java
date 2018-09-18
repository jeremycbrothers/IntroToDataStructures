public class Professor extends UniversityMember {
    private String officeLocation = "";

    public Professor(String name, int age, String idNumber, String officeLocation) { 
        super(name, age, idNumber);
        this.officeLocation = officeLocation;
    }

    public boolean equals() { return true; }

    public int hashCode() { return 0; }

    public String toString() { 
        final String professorData = super.toString() + "Office Location: " + officeLocation + "\n";
        return professorData;
    }

    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
    public String getOfficeLocation() { return officeLocation; }
}