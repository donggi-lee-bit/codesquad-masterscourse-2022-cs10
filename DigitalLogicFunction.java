public class DigitalLogicFunction {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = true;

        System.out.println("AND : " + myAnd(bitA, bitB));

        bitB = false;
        System.out.println("AND : " + myAnd(bitA, bitB));

        bitA = false;
        bitB = true;
        System.out.println("AND : " + myAnd(bitA, bitB));

        bitB = false;
        System.out.println("AND : " + myAnd(bitA, bitB));
        System.out.println("============================");

        bitA = true;
        bitB = true;
        System.out.println("OR : " + myOr(bitA, bitB));

        bitB = false;
        System.out.println("OR : " + myOr(bitA, bitB));

        bitA = false;
        bitB = true;
        System.out.println("OR : " + myOr(bitA, bitB));

        bitB = false;
        System.out.println("OR : " + myOr(bitA, bitB));
        System.out.println("============================");

        bitA = true;
        bitB = true;
        System.out.println("NAND : " + myNand(bitA, bitB));

        bitB = false;
        System.out.println("NAND : " + myNand(bitA, bitB));

        bitA = false;
        bitB = true;
        System.out.println("NAND : " + myNand(bitA, bitB));

        bitB = false;
        System.out.println("NAND : " + myNand(bitA, bitB));
        System.out.println("============================");
    }

    private static boolean myNand(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return false;
        }
        return true;
    }

    private static boolean myAnd(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }

    private static boolean myOr(boolean bitA, boolean bitB) {

        if (bitA | bitB == true) {
            return true;
        }
        return false;
    }
}
