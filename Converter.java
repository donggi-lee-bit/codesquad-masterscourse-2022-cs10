import java.util.ArrayList;

public class Converter {
    
    public int bin2dec(boolean[] bin) {
        int answer = 0;
        int binary = 2;

        for (int i = 0; i < bin.length; i++) {
            int temp = boolToInt(bin[i]);

            if (i == 0 && temp == 1) {
                answer += 1;
            }

            if (temp == 1 && i >= 1) {
                answer += pow(binary, i);
            }
            
        }
        return answer;
    }

    private int pow(int base, int expo) {
        int result = base;
        for (int i = 1; i < expo; i++) {
           result *= base;
        }
        return result;
    }


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

    private int boolToInt(boolean bin) {
        if (bin) {
            return 1;
        }
        return 0;
    }

    private boolean intToBool(int remainder) {
        if (remainder == 0) {
            return false;
        }
        return true;
    }
}
