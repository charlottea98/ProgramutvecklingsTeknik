package Lab2;


public class TicTacToe implements Boardgame{
    private String currentMessage;
    private String[][] board = new String[3][3];  
    private int moveNr = 0;
    private String phase = "placeMarks";
    private String playerTurn = "X";
    private int step = 1;
    

    TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public boolean move(int i, int j) {
 
        if (moveNr>5){
            phase = "moveMarks";
        }

        if (phase == "placeMarks"){
            if (board[i][j] !=" "){
                currentMessage = "Ogiltigt drag, välj en annan ruta";

                return false;
            }
            if (playerTurn == "X"){
                board[i][j] = playerTurn;
                moveNr++;
                playerTurn = "O";
                currentMessage = "Tur: Spelare " + playerTurn;
                return true;

            }
            else if (playerTurn == "O"){
                board[i][j] = playerTurn;
                moveNr++;
                playerTurn = "X";
                currentMessage = "Tur: Spelare " + playerTurn;
                return true;
            }
        }

        if (phase == "moveMarks"){
            if (step==1 && board[i][j] == playerTurn) {
                board[i][j] = " ";
                step = 2;
                currentMessage = "Spelare " + playerTurn + " välj ruta";
                return true;
            } 
            if (step==2 && board[i][j] == " ") {
                board[i][j] = playerTurn;
                if (playerTurn == "X"){
                    playerTurn = "O";
                }
                else {
                    playerTurn = "X";
                }
                currentMessage = "Tur: Spelare " + playerTurn;
                step = 1;
                return true;
            }

        }

        currentMessage = "Ogiltigt drag, välj en annan ruta";
        return false;
        
    }

    public String getStatus(int i, int j){
        return board[i][j];
    }

    public String getMessage() {
        return currentMessage;
    }

    
}