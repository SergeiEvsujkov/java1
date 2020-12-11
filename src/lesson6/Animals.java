package lesson6;


import java.util.Random;


public abstract class Animals {

    protected String name;
    protected String color;
    protected int age;

    public Random max = new Random();


    public Animals(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean runJumpSwim(int property, int max) {
        return property <= max;
    }

    public boolean runJumpSwim(double property, double max) {
        return property <= max;
    }

    public void propertiesAnimals(int resultRun, double resultJump, int resultSwim, int maxRun, double MAXJUMP, int MAXJSWIM) {
        System.out.println(name + " бежит " + resultRun + ":" + runJumpSwim(resultRun, maxRun) + "(" + maxRun + " может пробежать)");
        System.out.println("Прыгает " + resultJump + ":" + runJumpSwim(resultJump, MAXJUMP) + "(" + MAXJUMP + " может прыгнуть)");
        System.out.println("Плавает " + resultSwim + ":" + runJumpSwim(resultSwim, MAXJSWIM) + "(" + MAXJSWIM + " может проплыть)");
    }

    public void propertiesAnimals(int resultRun, double resultJump, int maxRun, double MAXJUMP) {
        System.out.println(name + " бежит " + resultRun + ":" + runJumpSwim(resultRun, maxRun) + "(" + maxRun + " может пробежать)");
        System.out.println("Прыгает " + resultJump + ":" + runJumpSwim(resultJump, MAXJUMP) + "(" + MAXJUMP + " может прыгнуть)");
        System.out.println("Котик не плавает ");
    }
}
