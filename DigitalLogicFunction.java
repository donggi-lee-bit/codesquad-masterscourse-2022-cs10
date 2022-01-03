public class DigitalLogicFunction {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = true;

        System.out.println(myAdd(bitA, bitB));
    }

    private static boolean myAdd(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }
}
