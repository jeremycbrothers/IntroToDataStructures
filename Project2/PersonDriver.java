public class PersonDriver {
    public static void main(String[] args) {
        final int SIZE = 4;
        Person[] personArray = new Person[SIZE];
        personArray[0] = new Person("name", 20);
        personArray[1] = new UniversityMember("name2", 20, 001);
        personArray[2] = new Student("name3", 20, 002, 3.2);
        personArray[3] = new Professor("name4", 20, 003, "officeLocation");
    }
}