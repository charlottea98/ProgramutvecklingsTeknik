package Lab2;


public class FifteenModel implements Boardgame {
    private String currentMessage = "No message yet";
    private String[][] board = new String[4][4];    // spelplanen
    private int iemp, jemp;                        // index till den tomma rutan

    /*
    FifteenModel(String[][] b, String curM, int ie, int je) {
        board = b;
        currentMessage = curM;
        iemp = ie;
        jemp = je;
    }
     */

    public boolean move(int i, int j) {


        try {
            if (board[i][j - 1].equals(board[iemp][jemp])) {
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i][j + 1].equals(board[iemp][jemp])) {
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i - 1][j].equals(board[iemp][jemp])) {
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i + 1][j].equals(board[iemp][jemp])) {
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        return false;
    }

    public String getStatus(int i, int j){
        return board[i][j];
    }

    public String getMessage() {
        return currentMessage;
    }

    public static void main(String[] args) {

        // Gör ett object som är fifteenmodel

        FifteenModel femtonspel = new FifteenModel();

        int counter = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter<10) {
                    femtonspel.board[i][j] = " " + counter;
                    counter++;
                }
                else if (counter==16){
                    femtonspel.board[i][j] = "  ";
                    femtonspel.iemp = i;
                    femtonspel.jemp = j;
                    counter++;
                }
                else {
                    femtonspel.board[i][j] = Integer.toString(counter);
                    counter++;
                }

            }

        }

        System.out.println(femtonspel.move(1,1));

        System.out.println(femtonspel.getStatus(femtonspel.iemp,femtonspel.jemp));


    }
}

