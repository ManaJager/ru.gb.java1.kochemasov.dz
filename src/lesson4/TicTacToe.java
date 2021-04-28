package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 3;
    static final char DOT_EMPTY = '.';
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';

    static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (isWin(DOT_X)) {
                System.out.println("Человек победил!");
                printMap();
                break;
            } else if (isMapFull()) {
                System.out.println("Ничья!");
                printMap();
                break;
            }
            computerTurn();
            if (isWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                printMap();
                break;
            } else if (isMapFull()) {
                System.out.println("Ничья!");
                printMap();
                break;
            }
            printMap();
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите координаты в формате X Y через пробел:");
            String coordinates = scanner.nextLine();
            try {
                String[] coords = coordinates.split(" ", 2);
                x = Integer.parseInt(coords[0]) - 1;
                y = Integer.parseInt(coords[1]) - 1;
                if (checkValues(x, y, true)) {
                    map[x][y] = DOT_X;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Координаты должны быть целыми числами!");
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Должны быть введены два числа, разделенные одним пробелом!");
            }
        } while (true);
    }

    private static boolean checkValues(int x, int y, boolean notify) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            if(notify) System.out.println("Координаты должны быть в диапазоне 1 - " + SIZE);
            return false;
        } else if (map[x][y] != DOT_EMPTY) {
            if(notify) System.out.println("Поле уже занято, попробуйте еще раз");
            return false;
        } else return true;
    }

    private static void computerTurn() {
        int x, y;
        Random random = new Random();
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
            if (checkValues(x, y, false)) {
                map[x][y] = DOT_O;
                break;
            }
        } while (true);
    }

    private static boolean isWin(char symbol) {
        int score = 0;

        //Диагональ 00-хх
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j && map[i][j] == symbol) score++;
            }
        }
        if(score==SIZE) return true; else score = 0;

        //Диагональ 0х-х0
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + j == SIZE - 1 && map[i][j] == symbol) score++;
            }
        }
        if(score==SIZE) return true; else score = 0;

        //Горизонтали
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) score++;
                else score = 0;
            }
            if(score==SIZE) return true;
        }

        //Вертикали
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symbol) score++;
                else score = 0;
            }
            if(score==SIZE) return true; else score = 0;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
