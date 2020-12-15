package lesson7;


public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {

        if (appetite <= plate.getFood()) {
            satiety = true;
            plate.decreaseFood(appetite);
            System.out.println("Котику " + name + " хватает еды");
        } else {
            plate.decreaseFood(appetite);
            System.out.println("Котику " + name + " не хватает еды");
        }

    }

    public void isSatiety() {
        System.out.println("Сытость котика " + name + ": " + satiety);
    }
}
