package lesson8;

import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class GameField {
    private static char[][] map;

    public GameField() {

    }

    public void initMap() {
        map = new char[Values.SIZE][Values.SIZE];
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                map[j][i] = Values.DOT_EMPTY;
            }
        }
    }

    public char getMapValue(int x, int y) {
        return map[x][y];
    }

    public static void setMapValue(int x, int y, char c) {
        map[x][y] = c;
    }

    public boolean isWin(char symbol) {
        int score = 0;
        Color color = (symbol == Values.DOT_X) ? Color.cyan : Color.red;
        //Диагональ 00-хх
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                if (i == j && map[j][i] == symbol) score++;

            }

        }
        if (score == Values.SIZE) {
            for (int j = 0; j < Values.SIZE; j++) {
                for (int k = 0; k < Values.SIZE; k++) {
                    if (j == k) {
                        ApplicationForm.fields[k][j].setBackground(color);
                    }
                }
            }
            disableAll();
            showMessageDialog(null, symbol + " is WIN!");
            return true;
        } else score = 0;

        //Диагональ 0х-х0
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                if (i + j == Values.SIZE - 1 && map[j][i] == symbol) score++;
            }
        }
        if (score == Values.SIZE) {
            for (int j = 0; j < Values.SIZE; j++) {
                for (int k = 0; k < Values.SIZE; k++) {
                    if (j + k == Values.SIZE - 1) ApplicationForm.fields[k][j].setBackground(color);
                }
            }
            disableAll();
            showMessageDialog(null, symbol + " is WIN!");
            return true;
        } else score = 0;

        //Вертикали
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                if (map[i][j] == symbol) score++;

            }
            if (score == Values.SIZE) {
                for (int j = 0; j < Values.SIZE; j++) {
                    ApplicationForm.fields[i][j].setBackground(color);
                }
                disableAll();
                showMessageDialog(null, symbol + " is WIN!");
                return true;
            } else score = 0;
        }

        //Горизонтали
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                if (map[j][i] == symbol) score++;
                else score = 0;
            }
            if (score == Values.SIZE) {
                for (int j = 0; j < Values.SIZE; j++) {
                    ApplicationForm.fields[j][i].setBackground(color);
                }
                disableAll();
                showMessageDialog(null, symbol + " is WIN!");
                return true;
            } else score = 0;
        }
        return false;
    }

    private void disableAll(){
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                ApplicationForm.fields[i][j].setEnabled(false);
            }
        }
    }

    public boolean isMapFull() {
        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                if (map[i][j] == Values.DOT_EMPTY) {
                    return false;
                }
            }
        }
        showMessageDialog(null, "Nobody WIN!");
        return true;
    }
}