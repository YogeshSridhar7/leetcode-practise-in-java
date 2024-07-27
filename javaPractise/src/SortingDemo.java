import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingDemo {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(0,"Arthur","Morgan",40));
        list.add(new Employee(3,"Dutch","Van Der Linde",42));
        list.add(new Employee(2,"Hosea","Matthews",54));
        list.add(new Employee(4,"Lenny","Summers",19));
        list.add(new Employee(1,"Sadie","Adler",30));
        list.add(new Employee(5,"Charles","Smith",30));
        long d =100;
        String s = Long.toString(d);
        System.out.println(s);

        Long.parseLong(s);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new SortByFirstName());
        System.out.println(list);

        Collections.sort(list, new SortByAge());
        System.out.println(list);
    }
}

class Employee implements Comparable{
    private long id;
    private String firstName;
    private String lastName;
    private int age;

    public Employee (long id, String fn, String ln, int age){
        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
    }
    public long getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getAge() {return age;}

    @Override
    public int compareTo(Object o) {

        //return Long.compare(this.id,((Employee)o).id);
        return this.lastName.compareTo(((Employee)o).lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

class SortByFirstName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return (((Employee)o1).getFirstName()).compareTo((((Employee)o2)).getFirstName());
    }
}

class SortByAge implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Employee)o1).getAge(),((Employee)o2).getAge());
    }
}