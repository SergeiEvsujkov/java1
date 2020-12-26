package lesson7;


public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int appetite) {
        if (food >= appetite) {
            food -= appetite;
        } else  {
            food = 0;

        }
    }

    public void addFoot(int food) {
        this.food += food;
        System.out.println("В тарелку добавили еды: " + food);
    }

    public void info() {
        System.out.println("В тарелке осталось: " + food);
    }
}
