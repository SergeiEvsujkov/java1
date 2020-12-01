package lesson1;

import javax.xml.transform.SourceLocator;
import java.util.Scanner;
//задача 1
public class Main {

    public static void main(String[] args) {
        //задача 2
        byte byteVal = 11;
        short shortVal = 1200;
        int intVal = 1786453276;
        long longVal = -8736524367483762534L;
        float floatVal = 14.45f;
        double doubleVal = -444433333333333.345;
        char charVal = 239;
        boolean booleanVal = true;

        calculate(); //задача 3
        System.out.println("Переменная от 10 до 20 включительно: " + task10and20()); //задача 4
        isPositiveOrNegative(); //задача 5
        System.out.println("Положительное ли число? " + isNegative()); //задача 6
        greetings(); //задача 7
        yearTest(); //задача 8
    }

    public static void calculate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите переменную A:");
        float a = in.nextFloat();
        System.out.println("Введите переменную B:");
        float b = in.nextFloat();
        System.out.println("Введите переменную C:");
        float c = in.nextFloat();
        System.out.println("Введите переменную D:");
        float d;
        do {
            d = in.nextFloat();
            if (d == 0) {
                System.out.println("Переменная D не должна равняться 0. Введите заново:");
            }
        } while (d == 0);
        float result = (a * (b + (c / d)));
        System.out.println(result);
    }

    private static boolean task10and20() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите переменную x1 :");
        float x1;
        // проверяем условие целочисленности для х1
        do {
            x1 = in.nextFloat();
            float x1Test = x1 % 1;
            if (x1Test != 0) {
                System.out.println("Введите целочисленное x1 заново:");
            }
        } while (x1 % 1 != 0);

        System.out.println("Введите переменную x2 :");
        float x2;
        // проверяем условие целочисленности для х2
        do {
            x2 = in.nextFloat();
            float x2Test = x2 % 1;
            if (x2Test != 0) {
                System.out.println("Введите целочисленное x2 заново:");
            }
        } while (x2 % 1 != 0);

        float sumX1X2 = x1 + x2;
        return (sumX1X2 >= 10 & sumX1X2 <= 20);
    }

    public static void isPositiveOrNegative() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число:");
        float x;
        // проверяем условие целочисленности х
        do {
            x = in.nextFloat();
            float xTest = x % 1;
            if (xTest != 0) {
                System.out.println("Введите целочисленное x заново:");
            }
        } while (x % 1 != 0);

        if (x >= 0) {
            System.out.println("Число является положительным");
        } else {
            System.out.println("Число является отрицательным");
        }
    }

    public static boolean isNegative() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число:");
        float x;
        // проверяем условие целочисленности х
        do {
            x = in.nextFloat();
            float xTest = x % 1;
            if (xTest != 0) {
                System.out.println("Введите целочисленное x заново:");
            }
        } while (x % 1 != 0);
        //in.close();
        return (x >= 0);
    }

    public static void greetings(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Ваше имя:");
        String name = in.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    public static void yearTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите проверяемый год:");
        float year = in.nextFloat();
        if (year < -45) {
            System.out.println("До 45 года до нашей эры все года были обычные.");
        } else if (year >= -45 && year <= -9 && (year % 3 == 0)) {
                System.out.println("Это были первые високосные года, когда они повторялись через 3 года.");
        } else if ((year >=8 && (year % 4 == 0) && (year % 100 != 0)) || (year >=8 && (year % 4 == 0) && (year % 400 == 0))) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
        in.close();// теперь можно закрыть сканер
    }
}
