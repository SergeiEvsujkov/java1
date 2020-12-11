package lesson6;

import java.util.Random;

public class Main {


    public static int resultRun = 250;
    public static double resultJump = 2.1;
    public static int resultSwim = 11;


    public static void main(String[] args) {

        Cat cat = new Cat("Барсик", "белый", 3);
        System.out.println(cat);
        cat.viewProperties(resultRun, resultJump,resultSwim);
        System.out.println();

        Dog dog = new Dog("Мухтар", "черный", 4);
        System.out.println(dog);
        dog.viewProperties(resultRun, resultJump,resultSwim);
        System.out.println();

        Cat cat1 = new Cat("Васька", "рыжий", 0);
        System.out.println(cat1);
        cat1.viewProperties(resultRun, resultJump,resultSwim);



    }

}
