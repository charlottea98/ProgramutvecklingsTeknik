package Lab2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;
    private JLabel mess = new JLabel();
    private JFrame frame;

    ViewControl(Boardgame gm, int n) {
        //  Constructor
        this.game = gm;
        this.size = n;
        this.frame = new JFrame();
        this.board = new Square[n][n];
        this.frame.setLayout(new GridLayout(n+1, n));
        this.create();
    }

    public static void main(String[] args) {
        //new ViewControl(new FifteenModel(), 4);
        //new ViewControl(new MockObject(), 2);
        new ViewControl(new TicTacToe(), 3);
    }

    private void create() {
        this.frame.setSize(new Dimension(600, 600));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.create_btns();
    }

    public void actionPerformed(ActionEvent e){
        //  Move button when pressed, i.e. do action
        Square square = (Square) e.getSource();
        if (this.game.move(square.x, square.y)) {
            this.update();     //   After every OK move board is updated
        }
        this.mess.setText(this.game.getMessage());  //  Display message regardless so user knows if
                                                    // move was Ok or not
    }

    private void create_btns() {
        //  Create buttons
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Square square = new Square(this.game.getStatus(i,j), i, j);
                this.board[i][j] = square;
                this.board[i][j].addActionListener(this);
                this.frame.add(this.board[i][j]);
                this.mess.setText("Welcome");
                this.frame.add(this.mess);
            }
        }
    }

    private void update() {
        // Update every button
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j].setText(this.game.getStatus(i,j));
                this.frame.add(this.board[i][j]);
                this.mess.setText(this.game.getMessage());
                this.frame.add(this.mess);
            }
        }
    }
}

class Square extends JButton {
    int y;
    int x;
    //private String text;
    Square(String text, int x, int y) {
        setText(text);
        setBackground(Color.CYAN);
        setOpaque(true);
        this.y = y;
        this.x = x;
    }
}
