import person.Person;
import person.PersonBuilder;

public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Донских")
                .setAge(43)
                .build();

        Person son = mom.newChildBuilder()
                .setName("Дамир")
                .setSurname(mom.getSurname())
                .setAge(15)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder()
                    .setName("NoName")
                    .setSurname("NoSurname")
                    .setAge(-100)
                    .build();

        }  catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

