public class UniversityMember extends Person {
    private String idNumber = "";

    public UniversityMember(String name, int age, String idNumber) { 
        super(name, age); 
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        UniversityMember um = (UniversityMember) object;
        return idNumber.equals(um.idNumber);
     }

    @Override
    public int hashCode() { 
        int hash = 7;
        hash = 31 * super.hashCode();
        hash = 31 * idNumber.hashCode();
        return hash;
    }

    @Override
    public String toString() { 
        final String umData = super.toString() + "idNumber:" + idNumber + "\n";
        return umData;
    }

    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public String getIdNumber() { return idNumber; }
}