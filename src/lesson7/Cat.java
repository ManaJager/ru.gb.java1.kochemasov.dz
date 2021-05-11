package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean wellFedCat = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite(){
        return this.appetite;
    }

    public void eat(Plate p) {
        if(p.decreaseFood(appetite) && !wellFedCat){
            System.out.println("Cat " + name + " began eat");
            wellFedCat = true;
            isThisCatWellFed();
        }
        else if(!wellFedCat){
            System.out.println("There's not enough food. Cat " + name + " is still hungry");
            isThisCatWellFed();
        }
        else if(wellFedCat){
            System.out.println("Cat " + name + " is already well-fed");
        }
    }

    public void isThisCatWellFed(){
        if(wellFedCat) System.out.println("Cat " + name + " is well-fed");
        else System.out.println("Cat " + name + " is hungry");
    }
}
