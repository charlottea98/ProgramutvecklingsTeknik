package Lab2;

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl2 extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Squares[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private JFrame frame;

    private ViewControl2(Boardgame gm, int n) {


        GridLayout layout = new GridLayout(n + 1, n);
        setSize(300, 300);
        setLayout(layout);


        this.board = new Squares[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "        " + j);
                Squares a = new Squares(gm.getStatus(i, j), i, j);
                this.board[i][j] = a;
                add(a);
                a.addActionListener(this);

            }
        }

        mess.setText("Welcome");
        add(mess);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Varibler med stora bokstäver är konstanter
        setVisible(true);


        this.game = gm;
        this.size = n;
        this.frame = new JFrame();
        this.board = new Squares[n][n];
        this.panel = new JPanel(new GridLayout(n + 1, n));
        this.create();

    }


    public void actionPerformed2(ActionEvent e) {
        Squares square = (Squares) e.getSource();
        //game.move(square.x, square.y);

    }


    public static void main(String[] args) {
        Boardgame hej = new FifteenModel();
        ViewControl2 a = new ViewControl2(null, 4);
    }


    public void actionPerformed(ActionEvent e) {
        Squares square = (Squares) e.getSource();
        if (game.move(square.x, square.y)) {
            this.update();     //After every move board is updated
        }
        this.mess.setText(this.game.getMessage());

    }


    private void create_btns() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new Squares("", i, j);
                this.board[i][j].addActionListener(this);
                this.panel.add(this.board[i][j]);
                this.panel.add(this.mess);
            }
        }
    }

    private void update() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j].setText(this.game.getStatus(i, j));
                this.panel.add(this.board[i][j]);
                this.mess.setText(this.game.getMessage());
                this.panel.add(this.mess);
            }
        }
    }


    private void create() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(new Dimension(600, 600));
        this.frame.setVisible(true);

        this.panel.setVisible(true);
        this.create_btns();

        this.frame.add(this.panel);
        this.update();


    }
}

    class Squares extends JButton {
        int y;
        int x;
        String text;

        Squares(String text, int x, int y) {
            setText(text);

            this.y = y;
            this.x = x;
        }
    }

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl2 extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;
    private JLabel mess = new JLabel();
    private JFrame frame;

    private ViewControl2(Boardgame gm, int n) {
        //  Constructor
        this.game = gm;
        this.size = n;
        this.frame = new JFrame();
        this.board = new Square[n][n];
        this.frame.setLayout(new GridLayout(n + 1, n));

        this.create();

    }

    public static void main(String[] args) {
        //new ViewControl2(null, 20);
        new ViewControl2(null, 20);

    }


    private void create() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(new Dimension(600, 600));
        this.frame.setVisible(true);

        this.create_btns();

    }

    public void actionPerformed(ActionEvent e) {
        Square square = (Square) e.getSource();
        System.out.println("Tryck på knapp " + square.x + " " + square.y);
        this.update();

    }

    private void create_btns() {
        //  Create buttons
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Square square = new Square("", i, j);
                this.board[i][j] = square;
                this.board[i][j].addActionListener(this);
                this.frame.add(this.board[i][j]);
                this.mess.setText("");
                this.frame.add(this.mess);
            }
        }
    }

    private void update() {
        // Update every button
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j].setText("");
                this.frame.add(this.board[i][j]);
                this.mess.setText("");
                this.frame.add(this.mess);
            }
        }
    }
}


