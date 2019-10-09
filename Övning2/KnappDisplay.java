package Övning2;

import javax.swing.*;
import java.awt.*;

public class KnappDisplay extends JFrame {
     MinKnappsats knappar;
     JLabel display;

     public KnappDisplay(){
         setSize(250, 150);
         setLayout(new BorderLayout());
         knappar= new MinKnappsats(this);
         display = new JLabel();
         add(knappar, BorderLayout.NORTH);
         add(display, BorderLayout.CENTER);
         setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);

     }

    public void updateDisplay(String myText){
         display.setText(myText);
    }

    public static void main(String[] args) {
        KnappDisplay window = new KnappDisplay();


    }
}

