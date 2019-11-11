package Lab3;
//  Delar gavs i labbinstrujtioner
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;


class RPSSkel extends JFrame implements ActionListener{
    GameBoard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    StenSaxPase game;

    private RPSSkel () {

        counter = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        closebutton = new JButton("Close");
        closebutton.addActionListener(this::actionPerformed);

        myboard = new GameBoard("Myself", this::actionPerformed2); // Must be changed
        computersboard = new GameBoard("Computer");

        game =  new StenSaxPase("localhost",4713, "Lotta och Mood" );

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

    public void actionPerformed(ActionEvent e){
        game.out.println("");
        game.out.flush();
        System.exit(0); //  Process finished with exit code 0
    }

    private void actionPerformed2(ActionEvent e) {
        if(counter == 0){   //  Start view
            myboard.resetColor();
            computersboard.resetColor();
        }
        counter ++;

        game.out.println(" "); //  Tom input så ordningen på readLine i StenSaxPase stämmer
        game.out.flush();

        if(counter == 3){
            String computerhand = game.getComputer(game.in);    //  Anropar getComputer i StenSaxPase
            String result = game.compare(computerhand, e.getActionCommand());

            myboard.setUpper(e.getActionCommand());
            computersboard.setUpper(computerhand);

            myboard.markPlayed(e.getActionCommand());
            computersboard.markPlayed(computerhand);

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
        else if (counter == 1){
            myboard.setLower("One...");
            computersboard.setLower("One...");
        }
        else if (counter == 2) {
            myboard.setLower("Two...");
            computersboard.setLower("Two...");
        }
    }
}