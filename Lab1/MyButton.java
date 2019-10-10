package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    private Color c1;
    private Color c2;
    private String s1;
    private String s2;

    public static void main(String[] args) {

        JFrame window = new JFrame("Mood och Lotta");
        GridLayout layout = new GridLayout(0,2);

        window.setSize(300, 200);
        window.setLayout(layout);

        MyButton button = new MyButton(Color.green, Color.red, "Run", "Stop");
        window.add(button);
        button.addActionListener(button);

        MyButton button2 = new MyButton(Color.white, Color.black, "On", "Off");
        window.add(button2);
        button2.addActionListener(button2);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Varibler med stora bokstäver är konstanter
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        toggleState();
    }

    private MyButton(Color c1, Color c2, String s1, String s2){
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;
    }

    private void toggleState(){
        if (this.getBackground() == this.c1){
            this.setBackground(this.c2);
            this.setText(this.s2);
            this.setForeground(this.c1);
        }
        else {
            this.setBackground(this.c1);
            this.setText(this.s1);
            this.setForeground(this.c2);
        }
        this.setOpaque(true);
    }
}
