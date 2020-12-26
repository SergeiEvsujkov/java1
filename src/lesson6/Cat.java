package lesson6;

public class Cat extends Animals {

    public int maxRun = 100 + max.nextInt(200);
    public final double MAXJUMP = 2.0;

    public Cat(String name, String color, int age) {
        super(name, color, age);

    }

    public void viewProperties(int resultRun, double resultJump,int resultSwim){
        propertiesAnimals(resultRun, resultJump, maxRun, MAXJUMP);
    }

}
