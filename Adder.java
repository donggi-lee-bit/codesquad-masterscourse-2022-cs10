import java.util.Arrays;

public class Adder {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = false;
        boolean carry = carry(true, true);

        System.out.println(Arrays.toString(fullAdder(bitA, bitB, carry)));

    }

    private static boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] answer = new boolean[2];

        if (bitA & bitB == true) {
            answer[0] = false;
            answer[1] = true;
        }

        if (carry == true) {
            answer[0] = true;
        }


        return answer;
    }

    private static boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = new boolean[2];

        answer[0] = sum(bitA, bitB);
        answer[1] = carry(bitA, bitB);
        return answer;
    }

    // AND 의 결과와 같다
    private static boolean carry(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }

    // XOR 의 결과와 같다
    private static boolean sum(boolean bitA, boolean bitB) {

        if (bitA == bitB) {
            return false;
        }
        return true;
    }
}
