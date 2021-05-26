package lesson8;

import java.awt.*;

public class TicTacToe {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationForm();
            }
        });
    }
}