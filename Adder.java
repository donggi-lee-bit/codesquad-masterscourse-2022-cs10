import java.util.Arrays;

public class Adder {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = true;

        System.out.println(Arrays.toString(halfAdder(bitA, bitB)));

    }

    private static boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = new boolean[2];

        answer[0] = mySum(bitA, bitB);
        answer[1] = myCarry(bitA, bitB);
        return answer;
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
