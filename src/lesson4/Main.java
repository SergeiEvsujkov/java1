package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int SIZE = 5;
    static final int SIZEFORWIN = 3;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '+';
    static final String EMPTY = " ";
    static int turnsCount;

    static int pointCheckWinRow;
    static int pointCheckWinColumn;

    static int testRow; // переменные, с помощью которой комп проверяет возможный выигрыш
    static int testColumn;// чтобы заблокировать ход или выиграть самому

    static final char[][] MAP = new char[SIZE][SIZE];

    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {
        initMap();

        printMap();

        playGame();
    }

    private static void initMap() {



        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.println();
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
        }
        System.out.println();
    }

    private static void printMapNumbers(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();

        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);

            aiTurn();
            printMap();
            checkEnd(DOT_AI);

        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid = true;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;

            System.out.print("Строка = ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;

            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбик = ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanValidTurn(rowNumber, columnNumber)));
        pointCheckWinRow = rowNumber + 1;
        pointCheckWinColumn = columnNumber + 1;
        MAP[rowNumber][columnNumber] = DOT_HUMAN;
    }

    private static void processingIncorrectInput() {
        in.next();
        System.out.println("Введите число!");
    }

    private static boolean isHumanValidTurn(int rowNumber, int columnNumber) {

        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        } else if (!isCellOccupancy(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку!");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber > SIZE || rowNumber < 0 || columnNumber > SIZE || columnNumber < 0);
    }

    private static boolean isCellOccupancy(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void checkEnd(char symbol) {
        boolean isEnd = false;

        if (checkWin(symbol)) {
            isEnd = true;
            String winMessage;

            if (symbol == DOT_HUMAN) {
                winMessage = "Ура! Вы победили!";
            } else {
                winMessage = "Увы. Вы проиграли.";
            }

            System.out.println(winMessage);
        }

        if (!isEnd && isMapFullByTurnsCount()) {
            System.out.println("Ничья!");
        }
        if (isEnd) {
           System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {  // универсальная проверка условия для поля любого размера и количества символов для победы
        int resultCalc = 0;

// проверяем строку и столбец таблицы в точке последнего ответа
        for (int i = 0; i < SIZE; i++) {
            if (MAP[pointCheckWinRow - 1][i] == symbol) {
                resultCalc++;
                if (resultCalc == SIZEFORWIN) {
                    return true;
                }
            } else {
                resultCalc = 0;
            }

        }
        resultCalc = 0;

        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][pointCheckWinColumn - 1] == symbol) {
                resultCalc++;
                if (resultCalc == SIZEFORWIN) {
                    return true;
                }
            } else {
                resultCalc = 0;
            }
        }
        resultCalc = 0;

// проверяем прямую диагональ таблицы в точке последнего ответа
        if (pointCheckWinRow >= pointCheckWinColumn) {
            int startIndexI = pointCheckWinRow - pointCheckWinColumn;
            for (int i = startIndexI, j = 0; i < SIZE; i++, j++) {
                if (MAP[i][j] == symbol) {
                    resultCalc++;
                    if (resultCalc == SIZEFORWIN) {
                        return true;
                    }
                } else {
                    resultCalc = 0;
                }
            }
        }

        resultCalc = 0;

        if (pointCheckWinRow < pointCheckWinColumn) {
            int startIndexJ = pointCheckWinColumn - pointCheckWinRow;
            for (int i = 0, j = startIndexJ; j < SIZE; i++, j++) {
                if (MAP[i][j] == symbol) {
                    resultCalc++;
                    if (resultCalc == SIZEFORWIN) {
                        return true;
                    }
                } else {
                    resultCalc = 0;
                }
            }
        }

        resultCalc = 0;

// проверяем обратную диагональ таблицы в точке последнего ответа
        if ((pointCheckWinRow + pointCheckWinColumn) < (SIZE + 2)) {
            int startIndexI = pointCheckWinRow + pointCheckWinColumn - 2;
            for (int i = startIndexI, j = 0; i >= 0; i--, j++) {
                if (MAP[i][j] == symbol) {
                    resultCalc++;
                    if (resultCalc == SIZEFORWIN) {
                        return true;

                    }
                } else {
                    resultCalc = 0;
                }
            }
        }

        resultCalc = 0;

        if ((pointCheckWinRow + pointCheckWinColumn) >= (SIZE + 2)) {
            int startIndexJ = pointCheckWinRow + pointCheckWinColumn - SIZE - 1;
            for (int i = SIZE - 1, j = startIndexJ; j < SIZE; i--, j++) {
                if (MAP[i][j] == symbol) {
                    resultCalc++;
                    if (resultCalc == SIZEFORWIN) {
                        return true;
                    }
                } else {
                    resultCalc = 0;
                }
            }
        }

        return false;


    }

    private static boolean isMapFull() {

        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMapFullByTurnsCount() {
        return ++turnsCount == SIZE * SIZE;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера!");

        if (blockTurn(DOT_AI)) {
            rowNumber = testRow;
            columnNumber = testColumn;
        } else if (blockTurn(DOT_HUMAN)) {
                 rowNumber = testRow;
                 columnNumber = testColumn;
            } else {

                do {
                    rowNumber = random.nextInt(SIZE);
                    columnNumber = random.nextInt(SIZE);
                } while (!isCellOccupancy(rowNumber, columnNumber));
        }

        pointCheckWinRow = rowNumber + 1;
        pointCheckWinColumn = columnNumber + 1;

        MAP[rowNumber][columnNumber] = DOT_AI;

    }

    private static boolean blockTurn(char symbol) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellOccupancy(i, j)) {
                    MAP[i][j] = symbol;
                    pointCheckWinRow = i + 1;
                    pointCheckWinColumn = j + 1;
                    if (checkWin(symbol)) {
                        testRow = i;
                        testColumn = j;
                        MAP[i][j] = DOT_EMPTY;
                        return true;
                    };
                    MAP[i][j] = DOT_EMPTY;

                }


            }

        }
        return false;

    }
}

