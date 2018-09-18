public class UniversityMember extends Person {
    private String idNumber = 0;

    public UniversityMember(String name, int age, String idNumber) { 
        super(name, age); 
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object objcet) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != objcet.getClass()) return false;
        if(!super.equals(obj)) return false;
        return idNumber.equals(um.idNumber);
     }

    @Override
    public int hashCode() { return 0; }

    @Override
    public String toString() { 
        final String umData = super.toString() + "idNumber:" + idNumber + "\n";
        return umData;
    }

    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    public String getIdNumber() { return idNumber; }
}