package lesson8;

import javax.swing.*;

public class Field extends JButton {
    private final int x;
    private final int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getCoordX() {
        return x;
    }

    public int getCoordY() {
        return y;
    }

    public void setFieldValue(char sign, Field field){
        field.setText(String.valueOf(sign));
        ApplicationForm.setBtnDisable(x, y);
        GameField.setMapValue(x, y, sign);
    }
}
