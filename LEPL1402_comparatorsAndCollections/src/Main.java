import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("Guillaume",20));
        persons.add(new Person("John",50));
        persons.add(new Person("Guillaume",10));
        persons.add(new Person("John",10));
        persons.add(new Person("Luc",5));

        sortPerson(persons);
        System.out.println(persons);
    }
    public static void sortPerson(ArrayList<Person> persons){
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                if (person.name==t1.name){
                    return person.age-t1.age;
                }
                return person.name.compareTo(t1.name);
            }
        });
    }
}
