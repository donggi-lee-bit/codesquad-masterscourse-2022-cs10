public class DigitalLogicFunction {

    public boolean xor(boolean bitA, boolean bitB) {

        return bitA | bitB && !(bitA & bitB);
    }

    public boolean nand(boolean bitA, boolean bitB) {

        return !(bitA & bitB);
    }

    public boolean and(boolean bitA, boolean bitB) {

        return bitA & bitB;
    }

    public boolean or(boolean bitA, boolean bitB) {

        return bitA | bitB;
    }
}
