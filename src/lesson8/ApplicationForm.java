package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    public static Field[][] fields;
    GameField gameField;
    Graphics g;

    public ApplicationForm() {

        gameField = new GameField();
        gameField.initMap();

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(new JMenuBar());
        setAlwaysOnTop(true);
        setResizable(false);
        setBounds(300, 300, 400, 400);
        Font font = new Font("Arial", Font.BOLD, 22);

        setGameField(font);

        setVisible(true);
    }

    private void setGameField(Font font) {
        fields = new Field[Values.SIZE][Values.SIZE];

        for (int i = 0; i < Values.SIZE; i++) {
            for (int j = 0; j < Values.SIZE; j++) {
                fields[j][i] = new Field(j, i);
                setBtnText(j, i, Values.DOT_EMPTY);
                fields[j][i].setOpaque(true);
                gameField.setMapValue(j, i, Values.DOT_EMPTY);
                fields[j][i].setFont(font);
                setLayout(new GridLayout(Values.SIZE, Values.SIZE));
                add(fields[j][i]);
                fields[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = ((Field) e.getSource()).getCoordX();
                        int y = ((Field) e.getSource()).getCoordY();
                        Turn turn = new Turn();
                        turn.humanTurn(x, y, (Field) e.getSource());
                    }
                });
            }
        }
    }

    public static void setBtnText(int x, int y, char c) {
        fields[x][y].setText(String.valueOf(c));
    }

    public static void setBtnDisable(int x, int y) {
        fields[x][y].setEnabled(false);
    }
}