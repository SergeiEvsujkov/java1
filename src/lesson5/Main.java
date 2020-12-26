package lesson5;

public class Main {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "8923123121", 30000, 30);
        persArray[1] = new Person("Sidorov Sidor", "Driver", "sidor@mailbox.com", "8923123331", 35000, 25);
        persArray[2] = new Person("Sergeev Sergei", "Developer", "sergei@mailbox.com", "8923143333", 38000, 43);
        persArray[3] = new Person("Petrov Petr", "Manager", "petrov@mailbox.com", "8923165435", 40000, 42);
        persArray[4] = new Person("Andreev Andrey", "Manager", "andrey@mailbox.com", "8923175335", 50000, 19);

        for (Person person : persArray) {
            if (person.age > 40) {
                person.printInfo();
            }

        }

    }
}
