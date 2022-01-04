import java.util.ArrayList;

public class Converter {

    DigitalLogicFunction dlf = new DigitalLogicFunction();
    Adder ad = new Adder();

    public boolean[] dec2bin(int decimal) {
        int i = 0;
        boolean[] answer = new boolean[9];

        while (decimal > 0) {
            int remainder = decimal % 2;
            decimal /= 2;
            answer[i] = intToBool(remainder);
            i++;
        }
        return answer;
    }

    public boolean intToBool(int remainder) {
        if (remainder == 0) {
            return false;
        }
        return true;
    }
}
