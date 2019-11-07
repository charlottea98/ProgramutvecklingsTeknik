package Lab2;

public class FifteenModel implements Boardgame {
    private String currentMessage = "No message yet";
    private String[][] board = new String[4][4];    // spelplanen
    private int iemp, jemp;                        // index till den tomma rutan


    FifteenModel() {
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter<10) {
                    board[i][j] = " " + counter;
                    counter++;
                }
                else if (counter==16){
                    board[i][j] = "  ";
                    iemp = i;
                    jemp = j;
                    counter++;
                }
                else {
                    board[i][j] = Integer.toString(counter);
                    counter++;
                }
            }
        }

        for (int i = 0; i < 10000;) {
            if (move((int)(Math.random()*4), (int)(Math.random()*4))) {
                i++;
            }
        }
    }


    public boolean move(int i, int j) {
        try {
            if (board[i][j - 1].equals(board[iemp][jemp])) {
                board[iemp][jemp] = board[i][j];
                iemp = i;
                jemp = j;
                board[iemp][jemp] = "  ";
                currentMessage = "OK";
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i][j + 1].equals(board[iemp][jemp])) {
                board[iemp][jemp] = board[i][j];
                iemp = i;
                jemp = j;
                board[iemp][jemp] = "  ";
                currentMessage = "OK";
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i - 1][j].equals(board[iemp][jemp])) {
                board[iemp][jemp] = board[i][j];
                iemp = i;
                jemp = j;
                board[iemp][jemp] = "  ";
                currentMessage = "OK";
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i + 1][j].equals(board[iemp][jemp])) {
                board[iemp][jemp] = board[i][j];
                iemp = i;
                jemp = j;
                board[iemp][jemp] = "  ";
                currentMessage = "OK";
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            if (board[i][j].equals(board[iemp][jemp])) {
                currentMessage = "Don't choose the empty one";
                return false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ;
        }
        currentMessage = "Please choose a position next to the empty one!";
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

        //FifteenModel femtonspel = new FifteenModel();

        /*
        for (int i = 0; i < 10;) {
            femtonspel.move((int)(Math.random()*4), (int)(Math.random()*4));
            if (femtonspel.currentMessage.equals("OK")) {
                i++;
            }
        }

       for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(femtonspel.getStatus(i, j));
                System.out.print(" ");
            }
            System.out.println();
        }

         */
        //System.out.println(femtonspel.move(3,2));

        //System.out.println(femtonspel.getStatus(femtonspel.iemp,femtonspel.jemp));
        //System.out.println(femtonspel.getStatus(3,2));
        //System.out.println(femtonspel.getStatus(3,3));


    }
}

