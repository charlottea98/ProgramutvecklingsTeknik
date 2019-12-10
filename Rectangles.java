
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rectangles extends JFrame implements ActionListener {
    JFrame jFrame = new JFrame("Game");

    Rectangles(){
        JTextArea jTextArea = new JTextArea();
        jTextArea.append("hej");
        jTextArea.setVisible(true);
        this.jFrame.add(jTextArea);

        this.jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(1);
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    jTextArea.append("key typed");
                    System.out.println(1);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(2);
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    jTextArea.append("Nu går du höger");
                    System.out.println(2);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(3);
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    jTextArea.append("Nu går du höger");
                    System.out.println(3);
                }
            }
        });


        this.jFrame.setVisible(true);
        this.jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Rectangles();
    }
}

/*

public class Cell {

}

public class Maze {
    private Cell[][] cells;
    //...
    private Cell getCellAt(int x, int y){
        return null;
    }
}

 */