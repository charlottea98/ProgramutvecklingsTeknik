package Lab4.Lab4FactoryMethod;
// 0 = NonBinary
// udda = Man
// jämn = Woman
public abstract class Human {
// här är factory metoded

    Human() {
        //Default modifier is package-private
    }

    public static Human create(String pnr){
        // 10:e siffran lika med 0
        if (Character.getNumericValue(pnr.charAt(9)) == 0){
            return new NonBinary();
        }
        // 10:e siffran är udda
        else if (Character.getNumericValue(pnr.charAt(9))%2 != 0){
            return new Man();
        }
        // 10:e siffran är jämn
        else if (Character.getNumericValue(pnr.charAt(9))%2 == 0){
            return new Woman();
        }
        return null;

    }

}



