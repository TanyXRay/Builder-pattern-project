package persons;

import utils.AgeIsZeroException;

import java.util.Objects;

/**
 * Класс, описывающий человека
 */
public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (age == 0) {
            try {
                throw new AgeIsZeroException("Возраст со значением 0!");
            } catch (AgeIsZeroException e) {
                e.printStackTrace();
            }
        }
        return age;
    }

    public String getAddress() {
        if (address == null) {
            throw new NullPointerException("Адрес не указан!");
        }
        return address;
    }

    /**
     * Метод проверки возраста
     *
     * @return true, если возраст человека известен, false, если нет
     */
    private boolean hasAge() {
        return age != 0;
    }

    /**
     * Метод увеличения возраста на единицу с момента создания объекта,
     * если возраст человека известен
     */
    public void happyBirthday() {
        if (!hasAge()) {
            try {
                throw new AgeIsZeroException("Возраст со значением 0!");
            } catch (AgeIsZeroException e) {
                e.printStackTrace();
            }
        }
        age += 1;
    }

    /**
     * Метод проверки города проживания
     *
     * @return true, если город проживания известен, false, если нет
     */
    private boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String address) {
        if (!hasAddress()) {
            this.address = address;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", age=" + age +
               ", city='" + address + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getAddress(), person.getAddress());
    }
}
