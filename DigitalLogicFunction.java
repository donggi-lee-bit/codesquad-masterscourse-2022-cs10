public class DigitalLogicFunction {

    public boolean xor(boolean bitA, boolean bitB) {

        if (bitA == bitB) {
            return false;
        }
        return true;
    }

    public boolean nand(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return false;
        }
        return true;
    }

    public boolean and(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }

    public boolean or(boolean bitA, boolean bitB) {

        if (bitA | bitB == true) {
            return true;
        }
        return false;
    }
}
