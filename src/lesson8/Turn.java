package lesson8;

import java.util.Random;

public class Turn extends GameField {

    private static final Random random = new Random();

    public Turn() {

    }

    public void humanTurn(int x, int y, Field f) {
        if (checkValues(x, y, true) && !isWin(Values.DOT_X) && !isWin(Values.DOT_O) && !isMapFull()) {
            f.setFieldValue(Values.DOT_X, f);
            if (isWin(Values.DOT_X)) {
                System.out.println("Human wins!");
            } else if (isMapFull()) {
                System.out.println("No one wins!");
            } else computerTurn();
        }
    }

    private void computerTurn() {
        int x, y;
        if (!isWin(Values.DOT_X) && !isWin(Values.DOT_O) && !isMapFull()) {
            do {
                x = random.nextInt(Values.SIZE);
                y = random.nextInt(Values.SIZE);
                if (checkValues(x, y, false)) {
                    ApplicationForm.setBtnText(x, y, Values.DOT_O);
                    ApplicationForm.setBtnDisable(x, y);
                    setMapValue(x, y, Values.DOT_O);
                    if (isWin(Values.DOT_O)) {
                        System.out.println("Computer wins!");
                    }
                    else if (isMapFull()) {
                        System.out.println("No one wins!");
                    }
                    break;
                }
            } while (true);
        }
    }

    private boolean checkValues(int x, int y, boolean notify) {
        if (getMapValue(x, y) != Values.DOT_EMPTY) {
            if (notify && !isWin(Values.DOT_X) && !isWin(Values.DOT_O) && !isMapFull())
                System.out.println("Поле уже занято, попробуйте еще раз!");
            return false;
        } else return true;
    }
}