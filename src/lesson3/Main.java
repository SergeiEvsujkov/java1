package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        fieldOfDreams();
    }

    public static void fieldOfDreams() {
        String[] words = {"apple", "apricot", "avocado", "banana", "broccoli", "carrot", "cherry", "garlic", "grape",
                "kiwi", "leak", "lemon", "mango", "melon", "mushroom", "nut", "olive", "orange", "pea", "peanut",
                "pear", "pepper", "pineapple", "potato", "pumpkin"};
        printWords(words);
        String wordRight = computerAnswer(words);
        checkAnswer(wordRight);
    }

    private static void printWords(String[] words) { //выводим все слова в табличку для лучшей видимости
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%15s ", words[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

    }

    private static String computerAnswer(String[] words) { // компьютер случайно выбирает слово
        return words[(int)(Math.random() * 25)];
    }

    private static String answerUser() { //возвращает ответ игрока
        System.out.println();
        System.out.println("Угадайте одно из слов.\nУгаданные буквы будут показаны.:");
        return in.nextLine();
    }

    private static void checkAnswer(String wordRight) { // сравнивает ответы и выводит результат
        String wordUser;
        int attempt = 1;
        do {
            if (attempt != 1) {
                System.out.println("\nНеудача, попробуйте ещё.");
            }
            
            System.out.printf("%d попытка", attempt);
            wordUser = answerUser();
            attempt++;
            for (int i = 0; i < 15; i++) {
                char a;
                char b;
                if (i < wordRight.length()) {
                    a = wordRight.charAt(i);
                } else {
                    a = '#';
                }
                if (i < wordUser.length()) {
                    b = wordUser.charAt(i);
                } else {
                    b = '#';
                }
                if (a == b) {
                    System.out.print(a);
                } else {
                    System.out.print("#");
                }
            }

        } while(!wordRight.equals(wordUser));

        System.out.println("\nВы угадали слово!");

        System.out.println("Сыграем ещё? y/n");
        String repeat = in.nextLine();

        switch (repeat) {
            case "y", "yes", "+", "да", "д" -> fieldOfDreams();
            case "n", "no", "-", "нет", "н" -> {
                System.out.println("Спасибо за игру!");
                in.close();
            }

        }
    }

}
