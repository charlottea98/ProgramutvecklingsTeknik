import javax.swing.*;

// This is a test comment. I'm practicing with Git

class HelloWorld{

    public static void main(String[] args) {

        //  System.out.println("Hello World!");
        JFrame fonster = new JFrame();
        fonster.setSize(300, 100);
        JLabel text = new JLabel("Hello World!");
        fonster.add(text);
        fonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Varibler med stora bokstäver är konstanter
        fonster.setVisible(true);
    }

}

// Class: Mall för objekt, Kan ärvas från, Alla metoder klara
// Abstract Class: Mall för klasser, Kan ärvas från, Kan ha både "kompletta" och abstarkta ("ofärdiga") metoder,
// Kan inte bilda objekt
// Interface: Gränssnitt för klass, Namnger metoder som måste finnas