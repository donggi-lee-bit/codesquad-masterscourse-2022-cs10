public class Adder {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = true;

        myCarry(bitA, bitB);

    }

    // AND 의 결과와 같다
    private static boolean myCarry(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }

    // XOR 의 결과와 같다
    private static boolean mySum(boolean bitA, boolean bitB) {

        if (bitA == bitB) {
            return false;
        }
        return true;
    }
}
