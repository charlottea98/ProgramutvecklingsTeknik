import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class ArrowTest extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(10, this);
    double x = 0, y=0, velx=0, vely=0;

    public ArrowTest(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //g2.fill(new Ellipse2D.Double(x , y,40,40));
        g2.fill(new Rectangle2D.Double(x, y, 10, 10));
        Rectangle rectangle = new Rectangle(100, 100, 200, 200);
        g2.draw(rectangle);
    }

    public void actionPerformed(ActionEvent e){
        if (x < 100){
            velx = 0;
            x = 100;
        }
        if (x > 290){
            velx = 0;
            x = 290;
        }
        if (y < 100){
            vely = 0;
            y = 100;
        }
        if (y > 290){
            vely = 0;
            y = 290;
        }
        x += velx;
        y += vely;
        repaint();
    }
    public void up(){
        vely = -1.5;
        velx = 0;
    }
    public void down(){
        vely = 1.5;
        velx = 0;
    }
    public void left(){
        velx = -1.5;
        vely = 0;
    }
    public void right(){
        velx = 1.5;
        vely = 0;
    }
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code==KeyEvent.VK_UP){
            up();
        }
        if (code==KeyEvent.VK_DOWN){
            down();
        }
        if (code==KeyEvent.VK_LEFT){
            left();
        }
        if (code==KeyEvent.VK_RIGHT){
            right();
        }

    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){
        velx = 0;
        vely = 0;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        ArrowTest a = new ArrowTest();
        f.add(a);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(400,400);

    }
}


