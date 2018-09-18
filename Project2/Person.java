public class Person {
    private String name = "";
    private int age = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object object) { return true; }

    public int hashCode() { return 0; }

    public String toString() { 
        final String personData = "Name: " + name + "\n" + "Age: " + age + "\n";
        return personData;
     }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
}