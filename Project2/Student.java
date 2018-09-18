public class Student extends UniversityMember {
    private float gpa = 0;

    public Student(String name, int age, String idNumber, float gpa) { 
        super(name, age, idNumber);
        this.gpa = gpa;
    }

    public boolean equals() { return true; }

    public int hashCode() { return 0; }

    public String toString() { 
        final String studentData = super.toString() + "Gpa: " + gpa + "\n";
        return studentData; 
    }

    public void setGpa(int gpa) { this.gpa = gpa; }
    public int getGpa() { return gpa; }
}