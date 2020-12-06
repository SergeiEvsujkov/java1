package lesson2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задача 1:");
        invertArray();
        System.out.printf("%n%nЗадача 2:%n");
        fillArray();
        System.out.printf("%n%nЗадача 3:%n");
        changeArray();
        System.out.printf("%n%nЗадача 4:%n");
        fillDiagonal();
        System.out.printf("%nЗадача 5:%n");
        maxminArr();
        System.out.printf("%nЗадача 6:%n");
        int[] array = {2, 2, 2, 1, 2, 2, 10, 1}; //массив для задачи 6
        System.out.println(checkBalance(array));
        System.out.printf("%nЗадача 7:%n");
        shiftArray(-1);
    }

    public static void invertArray() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0 -> arr[i] = 1;
                case 1 -> arr[i] = 0;
                default -> System.out.print("Значение, отличное от 0 и 1 -> ");
            }
            System.out.printf("%d ", arr[i]);
        }
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
            System.out.printf("%d ", arr[i]);
        }
    }

    public static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.printf("%d ", arr[i]);
        }
    }

    public static void fillDiagonal() {
        int longArr = 3 + (int) (Math.random() * 9); //генерирует случайный размер двумерного массива от 3 до 10
        int[][] arr = new int[longArr][longArr];

        System.out.printf("Создаём массив со случайным размером:%n%n");
        for (int i = 0; i < longArr; i++) {
            for (int j = 0; j < longArr; j++) {
                arr[i][j] = (int) (Math.random() * 11); // заполняем массив случайными значениями 0-10;
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }

        System.out.printf("%nЭтот же массив с единицами по диагоналям:%n%n");

        for (int i = 0; i < longArr; i++) {
                arr[i][i] = 1; // заполняем первую диагональ 1
            }

        for (int i = 0, j = longArr - 1; i < longArr; i++, j--){
            arr[i][j] = 1; // заполняем превую диагональ 1
        }

        for (int i = 0; i < longArr; i++) {
            for (int j = 0; j < longArr; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void maxminArr() {
        int longArr = 3 + (int) (Math.random() * 9); //генерирует случайный размер массива от 3 до 10
        int[] arr = new int[longArr];
        for (int i = 0; i < longArr; i++) {
            arr[i] = (int) (Math.random() * 11); // заполняем массив случайными значениями 0-10
            System.out.printf("%2d ", arr[i]);
        }
        int maxVal = arr[0];
        int minVal = arr[0];
        for (int i = 1; i < longArr; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        System.out.printf("%n%nМаксимальный элемент массива: %d", maxVal);
        System.out.printf("%nМинимальный элемент массива: %d %n", minVal);
    }

    private static boolean checkBalance(int[] array) {
        int leftSumm = 0;
        int rightSumm = 0;

        for (int i = 0; i < array.length - 1; i++) { // расчитываем сумму, пока не будет равенство или не закончится массив
            leftSumm = 0;
            rightSumm = 0;
            for (int j = 0; j <= i; j++) { //сумма слева
                leftSumm += array[j];
            }
            for (int j = i + 1; j < array.length; j++) { //сумма справа
                rightSumm += array[j];
            }
            if (leftSumm == rightSumm) {
                break; // если сумма совпадает, сразу выходим из цикла, при этом значения записываются
            }
        }
        return (leftSumm == rightSumm); //true, если равенство есть, иначе false
    }

    public static void shiftArray(int n) {
        int longArr = 3 + (int) (Math.random() * 9); //генерирует случайный размер массива от 3 до 10
        int[] arr = new int[longArr];
        for (int i = 0; i < longArr; i++) {
            arr[i] = (int) (Math.random() * 11); // заполняем массив случайными значениями 0-10
            System.out.printf("%2d ", arr[i]);
        }

        if (n < 0) {
            for (int j = n; j < 0; j++) { //двигаем весь массив n раз
                int lastSymbol = arr[arr.length - 1];//сохраняем последний элемент, чтобы он не пропал
                arr[arr.length - 1] = arr[0];
                for (int i = 0; i < longArr - 2; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 2] = lastSymbol;// тут нам пригодился последний элемент
            }
        }

        if (n >= 0) {
            for (int j = 0; j < n; j++) { //двигаем весь массив n раз
                int firstSymbol = arr[0];// сохраняем первый элемент, чтобы он не пропал
                arr[0] = arr[longArr - 1];
                for (int i = longArr - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[1] = firstSymbol;// тут нам пригодился 1 элемент
            }
        }

        System.out.println();
        for (int i = 0; i < longArr; i++) { // печатаем результат
            System.out.printf("%2d ", arr[i]);
            }

    }
}




