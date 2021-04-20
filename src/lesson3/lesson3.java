package lesson3;

public class lesson3 {
    public static void main(String[] args) {
        //Задача 1
        int[] massive = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertNumbers(massive);

        //Задача 2
        int[] emptyMassive = new int[100];
        fillEmptyMassive(emptyMassive);

        //Задача 3
        int[] massive2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multNumbersLess6to2(massive2);

        //Задача 4
        int[][] matrix = new int[11][11];
        fillMatrixDiagonals(matrix);

        //Задача 5
        int[] newMassive = initMassive(10, 4);

        //Задача 6
        int[] massive3 = {-1, -5, 3, 2, 11, 4, 5, 2, 4, -8, -9, 1};
        findAndPrintExtremums(massive3);

        //Задача 7
        int[] massive4 = {2, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 2};
        findBalance(massive4);
    }

    /* Задача 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    С помощью цикла и условия заменить 0 на 1, 1 на 0; */
    public static void invertNumbers(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == 0) massive[i] = 1;
            else if (massive[i] == 1) massive[i] = 0;
            System.out.print(massive[i]);
        }
        System.out.println("\n");
    }

    /* Задача 2. Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100 */
    private static void fillEmptyMassive(int[] emptyMassive) {
        for (int i = 0; i < emptyMassive.length; i++) {
            emptyMassive[i] = i + 1;
            System.out.print(emptyMassive[i]);
        }
        System.out.println("\n");
    }

    /* Задача 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2 */
    private static void multNumbersLess6to2(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] < 6) massive[i] *= 2;
            System.out.print(massive[i] + " ");
        }
        System.out.println("\n");
    }

    /* Задача 4. Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    заполнить его диагональные элементы единицами */
    public static void fillMatrixDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j || i + j == matrix.length - 1) matrix[i][j] = 1;
                System.out.print(matrix[i][j]);
                if (j == matrix.length - 1) System.out.println("");
            }
        }
    }

    /* Задача 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна
    initialValue */
    private static int[] initMassive(int len, int initValue) {
        int massive[] = new int[len];

        for (int i = 0; i < massive.length; i++) {
            massive[i] = initValue;
        }
        return massive;
    }

    /* Задача 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы */
    private static void findAndPrintExtremums(int[] massive) {
        int minimum = Integer.MIN_VALUE, maximum = Integer.MAX_VALUE;

        for (int i = 0; i < massive.length; i++) {
            if (massive[i] > minimum) minimum = massive[i];
            if (massive[i] < maximum) maximum = massive[i];
        }
        System.out.println("Максимальное значение = " + maximum + ", минимальное знгачение = " + minimum);
    }

    /* Задача 7. Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    массива равны */
    private static boolean findBalance(int[] massive) {
        boolean result = false;
        int left = 0, right = 0;
        for (int i = 0; i < massive.length; i++) {
            left += massive[i];
            for (int j = massive.length - 1; j >= 0; j--) {
                right += massive[j];
                if (left == right) {
                    result = true;
                    System.out.println("Есть баланс!");
                }
            }
        }
        return result;
    }

}
