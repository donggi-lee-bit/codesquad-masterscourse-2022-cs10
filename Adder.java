public class Adder {

    DigitalLogicFunction dlf = new DigitalLogicFunction();

    final static int CARRY = 0;
    final static int SUM = 1;

    /*
    byteA  = [ 1, 1, 0, 1, 1, 0, 1, 0 ]
    byteB  = [ 1, 0, 1, 1, 0, 0, 1, 1 ]
       결과 = [ 0, 0, 0, 1, 0, 1, 0, 0, 1 ]
     */

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean[] answer = new boolean[9];
        boolean carry = false;
        int len = answer.length - 1;
        boolean[] res = new boolean[len];

        for (int i = 0; i < len; i++) {
            res = fullAdder(byteA[i], byteB[i], carry);
            carry = res[CARRY];
            answer[i] = res[SUM];
        }
        answer[8] = res[CARRY];

        return answer;
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] firstHalfAdder = halfAdder(bitA, bitB);
        boolean sum = firstHalfAdder[1];

        boolean[] secondHalfAdder = halfAdder(carry, sum);
        boolean carryOut = dlf.or(firstHalfAdder[0], secondHalfAdder[0]);
        boolean sumOut = secondHalfAdder[1];
        return new boolean[]{carryOut, sumOut};
    }

    private boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[]{carry(bitA, bitB), sum(bitA, bitB)};
    }

    private boolean carry(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.and(bitA, bitB);
    }

     private boolean sum(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.xor(bitA, bitB);
    }
}
