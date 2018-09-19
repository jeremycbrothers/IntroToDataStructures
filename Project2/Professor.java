public class Professor extends UniversityMember {
    private String officeLocation = "";

    public Professor(String name, int age, String idNumber, String officeLocation) { 
        super(name, age, idNumber);
        this.officeLocation = officeLocation;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        Professor professor = (Professor) object;
        return officeLocation.equals(professor.officeLocation);
     }

    @Override
    public int hashCode() { 
        int hash = 7;
        hash = 31 * super.hashCode();
        // hash = 31 * idNumber.hashCode();
        return hash;
    }

    @Override
    public String toString() { 
        final String professorData = super.toString() + "Office Location: " + officeLocation + "\n";
        return professorData;
    }

    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
    public String getOfficeLocation() { return officeLocation; }
}