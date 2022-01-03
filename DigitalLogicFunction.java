public class DigitalLogicFunction {
    public static void main(String[] args) {

        boolean bitA = true;
        boolean bitB = true;
        System.out.println(myAnd(bitA, bitB)); 
    }

    public static boolean myAnd(boolean a, boolean b) {

        if (a & b == true) {
            return true;
        }
        return false;
    }
}
