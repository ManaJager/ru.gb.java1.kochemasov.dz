package lesson1;

public class HomeWorkApp {
    public static final String[] fruits = {"Orange", "Banana", "Apple"};

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        for (int i = 0; i < fruits.length; i++)
            System.out.println(fruits[i]);
    }

    public static void checkSumSign() {
        int a = 9, b = -18;

        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 123;

        if (value <= 0) System.out.println("Красный");
        else if (value > 0 && value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = -19, b = -8;

        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
