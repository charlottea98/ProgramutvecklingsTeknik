package Lab4FactoryMethod;
// 0 = NonBinary
// udda = Man
// jämn = Woman
abstract class Human {
// här är factory metoden
    public static Human create(String name, String pnr){
        // 10:e siffran lika med 0
        if (Character.getNumericValue(pnr.charAt(9)) == 0){
            return new NonBinary(name);
        }
        // 10:e siffran är udda
        else if (Character.getNumericValue(pnr.charAt(9))%2 != 0){
            return new Man(name);
        }
        // 10:e siffran är jämn
        else if (Character.getNumericValue(pnr.charAt(9))%2 == 0){
            return new Woman(name);
        }
        return null;
    }
}



