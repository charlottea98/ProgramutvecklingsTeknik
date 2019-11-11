package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyButton2 extends JButton implements ActionListener {
    // Git-test
    State state1;
    State state2;
    public JButton myBtn;

    public MyButton2(Color c1, Color c2, String s1, String s2) {
        this.state1= new State(c1, s1);
        this.state2 = new State(c2, s2);
        this.state2.active = true;

        this.myBtn = new JButton();
        this.myBtn.setOpaque(true);

        this.toggleState();

        myBtn.addActionListener(this);
        myBtn.validate();
    }

    public String toString(){
        return this.state1 + " : " + this.state2;
    }

    public void toggleState(){
        if(this.state1.active){
            this.myBtn.setText(state2.btnText);
            this.myBtn.setBackground(state2.color);

        }
        else{
            this.myBtn.setText(state1.btnText);
            this.myBtn.setBackground(state1.color);

        }
        this.state1.active = !this.state1.active;
        this.state2.active = !this.state2.active;
        this.myBtn.validate();
    }

    public JButton getBtn(){
        return this.myBtn;
    }

    public void actionPerformed(ActionEvent e){
        this.toggleState(); }

}

class State{
    Boolean active;
    Color color;
    String btnText;

    public State(Color c1, String txt){
        this.color = c1;
        this.btnText = txt;
        this.active = false;
    }

    public String toString(){
        return this.btnText;
    }
}