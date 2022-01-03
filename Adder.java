import java.util.Arrays;
import java.util.Scanner;

public class Adder {

    // 1, 1, 1
    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] halfAdderResult = halfAdder(bitA, bitB);
        // c1, s1
        return new boolean[]{halfAdderResult[0], sum(halfAdderResult[1], carry)};
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
