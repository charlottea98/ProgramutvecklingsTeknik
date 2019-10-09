package Övning2;

import javax.swing.*;
import java.awt.event.*;

public class BildKnapp extends JButton{
    ImageIcon[] ikoner;


    public BildKnapp(ImageIcon[] ikoner){
        super();
        this.ikoner = ikoner;
        setIcon(ikoner[0]);
    }

    public void bytIkon(int iknoNummer){
        if (iknoNummer<ikoner.length && iknoNummer >=0){
            setIcon(ikoner[iknoNummer]);
        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        ImageIcon[] ikoner = new ImageIcon[2];
        ikoner[0]=new ImageIcon("penguin.gif");
        ikoner[1]=new ImageIcon("frog.gif");
        BildKnapp testKnapp = new BildKnapp(ikoner);
        window.add(testKnapp);

        testKnapp.addActionListener(new ActionListener(){
            int nummer = 0;
            public void actionPerformed(ActionEvent event){
                BildKnapp knappen = (BildKnapp)event.getSource();
                nummer = (nummer+1)%3;
                knappen.bytIkon(nummer);}});
        window.setSize(40, 80);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
