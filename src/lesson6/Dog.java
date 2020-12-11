package lesson6;

public class Dog extends Animals {

    public final double MAXJUMP = 0.5;
    public final int MAXSWIM = 10;


    public int maxRun = 300 + max.nextInt(200);

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }
    public void viewProperties(int resultRun, double resultJump,int resultSwim) {
        propertiesAnimals(resultRun, resultJump, resultSwim, maxRun, MAXJUMP, MAXSWIM);
    }
}
