package lesson7;

import java.util.ArrayList;
import java.util.Locale;

public class CatFeed {
    public static void main(String[] args) {
        // По основной части задания
        ArrayList<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Murzik", 20);
        Cat cat3 = new Cat("Kote", 7);
        Plate plate = new Plate(30);
        plate.info();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        for (int i = 0; i < cats.size(); i++) {
            cats.get(i).eat(plate);
        }
        plate.info();

        // По заданию со *
        strings("I like Java!!!");
    }
    private static void strings(String str){
        System.out.println(str.charAt(str.length()-1));
        if(str.endsWith("!!!")) System.out.println(str + "ends with \"!!!\"");
        if(str.startsWith("I like")) System.out.println(str + "starts from \"I like\"");
        if(str.contains("Java")) System.out.println(str + "contains \"Java\"");
        str = str.replace("a", "o");
        System.out.println(str);
        str = str.toUpperCase();
        str = str.toLowerCase();
        str = str.replace("jovo", "");
        System.out.println(str);
    }
}
