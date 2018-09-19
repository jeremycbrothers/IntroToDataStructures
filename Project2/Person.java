public class Person {
    private String name = "";
    private int age = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        Person p = (Person) object;
        return age == p.age && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 31 * hash * age;
        hash = 31 * hash * name.hashCode(); 
        return hash;
    }

    @Override
    public String toString() { 
        final String personData = "Name: " + name + "\n" + "Age: " + age + "\n";
        return personData;
     }
}