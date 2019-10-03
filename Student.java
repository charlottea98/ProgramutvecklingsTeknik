package Lab0;

public class Student extends Randomperson {
    private int year;

    public static void main(String[] args) {

        int randomnumber = (int)(Math.random()*(names.length-1)) + 1;

        Student[] objects = new Student[randomnumber];

        int counter = 0;
        for (int i = 0; i < randomnumber; i++) {
            objects[counter++] = new Student();
        }

        for (Student p : objects) {
            System.out.println(p);
        }

        /*
        Student a = new Student("Lotta", 20, 2017);
        System.out.println(a);
         */
    }

    private Student(String nameIn, int ageIn, int yearIn){
        name = nameIn;
        age = ageIn;
        year = yearIn;
    }

    Student() {
        age = (int)(Math.random()*100 + 15);
        year = (int)(Math.random()*19 + 2000);
    }

    @Override
    public String toString() {
        return ("Namn: " + getName() + ", Ålder: " + getAge()) + ", började på CMETE " + getYear();
    }

    private int getYear(){
        return year;
    }


}
