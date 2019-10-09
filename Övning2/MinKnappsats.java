package Övning2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinKnappsats extends JPanel implements ActionListener{
    StringBuilder minne;
    JButton[] knappar;
    KnappDisplay owner=null;

    public MinKnappsats(){
        minne = new StringBuilder();
        knappar = new JButton[12];
        String tecken = "123456789*0#";

        setLayout(new GridLayout(4, 3));
        setSize(200, 150);


        for (int i = 0; i < 12; i++) {
            knappar[i] = new JButton(tecken.substring(i, i+1));
            add(knappar[i]);
            knappar[i].addActionListener(this);

        }

    }

    public MinKnappsats(KnappDisplay owner){
        this();
        this.owner=owner;
    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(200, 150);
        window.add(new MinKnappsats());
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
        try{
            Integer.parseInt(text);
            minne.append(text);
        }
        catch (NumberFormatException e){
            if (text.equals("*")){
                minne = new StringBuilder();
            }
        }
        if (owner==null){
            System.out.println(minne);
        }
        else{
            owner.updateDisplay(minne.toString());
        }


    }

}
