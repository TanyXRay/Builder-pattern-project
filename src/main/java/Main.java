import persons.*;

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
    }
}

