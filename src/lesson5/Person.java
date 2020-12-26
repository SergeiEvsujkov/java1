package lesson5;

import java.sql.SQLOutput;

public class Person {
    String name;
    String post;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Person(String name, String post, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printInfo(){
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + post);
        System.out.println("еMail: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }
}

