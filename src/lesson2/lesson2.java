package lesson2;

public class lesson2 {
    public static void main(String[] args) {
        compareDiapazon(10, 20);
        isPositivePrint(10);
        System.out.println(isNegative(-10));
        printString("Hello world!",10);
        System.out.println(isLeapYear(1501));
    }

    private static boolean compareDiapazon(int a, int b) {
        int result = a + b;
        return result >= 10 && result <= 20;
    }

    private static void isPositivePrint(int i) {
        if ((i >= 0)) {
            System.out.println("Число " +  i + " положительное");
        } else {
            System.out.println("Число " +  i + " отрицательное");
        }
    }

    private static boolean isNegative(int i) {
        return i < 0;
            return true;
        } else {
            return false;
        }
    }

    private static void printString(String s, int n) {
        for(int i=0;i<n;i++){
            System.out.println(s);
        }
    }

    private static boolean isLeapYear(int year){
        if(year%4 == 0) {
            if(year%100 == 0){
                if(year%400 == 0) return true;
                else return false;
            }
            else return true;
        }
        else return false;
    }
}
