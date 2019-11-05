package Lab2;

public class MockObject implements Boardgame {

    private Square[][] board;
    private int size;

    MockObject() {

    }

    public boolean move(int i, int j) {
        try {
            this.getMessage();
            System.out.println("Nice move");
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Error occured");
            return false;
        }
    }

    public String getStatus(int i, int j) {
        try {
            return "något" + (i+j);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String getMessage() {
        return "Message";
    }
}
