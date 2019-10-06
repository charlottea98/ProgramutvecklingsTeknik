package Lab1;

// this is a commentt4

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonX extends JButton implements ActionListener {
    private Color c1;
    private Color c2;
    private String s1;
    private String s2;
    private static Color[] colors = {Color.cyan, Color.green, Color.red, Color.black, Color.magenta, Color.white, Color.blue,
            Color.orange, Color.pink, Color.yellow};

    public static void main(String[] args) {

        int j = Integer.parseInt(args[0]);
        int k = 0;
        String[] words = new String[2*j];

        for (String t:args
        ) {
            if (!t.equals(args[0])){
                words[k++] = t;
            }
        }

        JFrame window = new JFrame("Knapp");
        GridLayout layout = new GridLayout((int)(Math.ceil(j/2)), (int)(Math.ceil(j/2)));

        window.setSize(300, 200);
        window.setLayout(layout);

        int counter = 0;

        for (int i = 0; i < (j); i++) {
            int randomnumber = (int)(Math.random()*(colors.length));
            int randomnumber2 = (int)(Math.random()*(colors.length));

            MyButtonX btn = new MyButtonX((colors[randomnumber]), (colors[randomnumber2]), words[counter],
                    words[counter+1]);
            btn.addActionListener(btn);
            window.add(btn);
            counter = counter + 2;
        }


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Varibler med stora bokstäver är konstanter
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        toggleState();
    }

    private MyButtonX(Color c1, Color c2, String s1, String s2){
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;
    }

    private void toggleState(){
        if (this.getBackground() == this.c1 && this.getText().equals(this.s1)){
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