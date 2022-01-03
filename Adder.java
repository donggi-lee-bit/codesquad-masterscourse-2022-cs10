import java.util.Arrays;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        boolean bitA = true;
        boolean bitB = false;
        boolean carry = carry(true, true);

//        System.out.println(Arrays.toString(fullAdder(bitA, bitB, carry)));

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

    private boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[]{carry(bitA, bitB), sum(bitA, bitB)};
    }

    // AND 의 결과와 같다
    private boolean carry(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.myAnd(bitA, bitB);
    }

    // XOR 의 결과와 같다
     private boolean sum(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.myXor(bitA, bitB);
    }
}
