package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount){
        if(amount> food){
            return false;
        } else{
            food -= amount;
            return true;
        }
    }

    public void info() {
        System.out.println("Food amount: " + food);
    }

    public void addFood(int howMush){
        this.food += howMush;
    }

}
