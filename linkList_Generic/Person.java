import java.sql.Struct;

public class Person implements Comparable<Person> {
    String name;
    String id;
    int byear;

    public Person(String name, String id, int byear) {
        this.byear = byear;
        this.id = id;
        this.name = name;
    }

    public int getByear() {
        return byear;
    }
     public String toString(){
        return "name:"+name+" id:"+id+" year of birth:"+byear+"\n";

     }
    public int compareTo(Person P) {

        if (byear > P.getByear()) return -1;
        else return 1;
    }
}


