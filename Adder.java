public class Adder {

    DigitalLogicFunction dlf = new DigitalLogicFunction();

    // 1, 1, 1
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
