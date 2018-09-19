public class Student extends UniversityMember {
    private Double gpa = 0;

    public Student(String name, int age, String idNumber, Double gpa) { 
        super(name, age, idNumber);
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return gpa.equals(student.gpa);
     }

    @Override
    public int hashCode() { 
        int hash = 3;
        hash = 31 * super.hashCode();
        hash = 31 * gpa.hashCode();
        return hash;
    }

    public String toString() { 
        final String studentData = super.toString() + "Gpa: " + gpa + "\n";
        return studentData; 
    }

    public void setGpa(int gpa) { this.gpa = gpa; }
    public int getGpa() { return gpa; }
}