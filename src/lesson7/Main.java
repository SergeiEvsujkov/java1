package lesson7;

public class Main {

    public static void main(String[] args) {
        //String[][] cat = new String[][];
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барсик", 20);
        cat[1] = new Cat("Васька", 20);
        cat[2] = new Cat("Рыжик", 20);
        cat[3] = new Cat("Шалун", 50);
        cat[4] = new Cat("Обжорка", 20);
        Plate plate = new Plate(100);
        plate.info();
        plate.addFoot(10);
        for (int i = 0; i < 5; i++) {
            cat[i].eat(plate);
            cat[i].isSatiety();
            plate.info();
        }

    }
}