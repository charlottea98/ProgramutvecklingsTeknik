package Lab0;
import Lab0.Student;

public class Main {
    public static void main(String[] args) {
        int randomnumber = (int)(Math.random()*5)+5;
        int randomnumber2 = (int)(Math.random()*5)+5;

        Randomperson[] objects = new Randomperson[randomnumber+randomnumber2];

        int counter = 0;
        for (int i = 0; i < randomnumber; i++) {
            objects[counter++] = new Student();
        }

        for (int i = 0; i < randomnumber2; i++) {
            objects[counter++] = new Randomperson();
        }
        for (Randomperson p : objects) {
            System.out.println(p);
        }

    }
}
