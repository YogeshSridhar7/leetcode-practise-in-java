import java.io.*;

public class SerializationDemo implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Address address;
    private Person person;

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public void writerObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        oos.writeObject(address.getHouseNumber());
    }
    public static void main(String[] args) {

    }


//    @Test
//    public void whenSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassCastException{
//        Person person = new Person();
//        person.setAge(20);
//        person.setName("Joe");
//
//        FileOutputStream fileOutputStream = new FileOutputStream("myFile.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(person);
//        objectOutputStream.flush();
//        objectOutputStream.close();
//
//        FileInputStream fileInputStream = new FileInputStream("myFile.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Person p2 = (Person) objectInputStream.readObject();
//        objectInputStream.close();
//
//        assertTrue(p2.getAge() == person.getAge());
//        assertTrue(p2.getName().equals(person.getName()));
//
//    }
}

class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    static String country = "ITALY";
    private int age;
    private String name;
    transient int height;


    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Person.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Address{
    private int houseNumber;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
