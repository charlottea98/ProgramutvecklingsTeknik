package Lab3;
//  Delar gavs i labbinstrujtioner
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;


class RPSSkel extends JFrame {
    GameBoard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    RPSModel model;
    String[] numbersInText;

    RPSSkel () {

        numbersInText = new String[]{"One!", "Two!"};
        counter = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        closebutton = new JButton("Close");
        closebutton.addActionListener(new Close());

        myboard = new GameBoard("Myself", new Action()); // Must be changed
        computersboard = new GameBoard("Computer");

        model =  new RPSModel("localhost",4713, "Lotta och Mood" );

        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));

        boards.add(myboard);
        boards.add(computersboard);

        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);

        setSize(300, 550);
        setVisible(true);


    }

    public static void main (String[] u) {
        new RPSSkel();
    }

    class Close implements ActionListener {
        //  Closes game
        public void actionPerformed(ActionEvent e){
            model.out.println("");
            model.out.flush();
            System.exit(0);
        }
    }

    class Action implements ActionListener {
        //  Plays game by listening to which command the player chooses
        public void actionPerformed(ActionEvent e) {
            //System.out.println(model);
            //System.out.println(e.getActionCommand());
            if(counter == 0){   //  Start view
                myboard.resetColor();
                computersboard.resetColor();
                myboard.setUpper("RPS");
                computersboard.setUpper("RPS");
            }
            counter ++;

            model.out.println("En input");
            model.out.flush();
            String compHand = model.getCompHand(model.in);
            String result = model.compare(compHand, e.getActionCommand());
            //System.out.println(result);

            if(counter == 3){
                myboard.setUpper(e.getActionCommand());
                computersboard.setUpper(compHand);

                myboard.markPlayed(e.getActionCommand());
                computersboard.markPlayed(compHand);

                counter = 0;

                if (result.equals("WIN")){
                    myboard.wins();
                    myboard.setLower(result);
                    computersboard.setLower("LOSE");

                }

                else if (result.equals("LOSS")){
                    computersboard.wins();
                    computersboard.setLower("WIN");
                    myboard.setLower(result);

                }

                else{
                    computersboard.setLower(result);
                    myboard.setLower(result);
                }


            }
            else {

                myboard.setLower(numbersInText[counter - 1]);
                computersboard.setLower(numbersInText[counter - 1]);
            }
        }
    }
}