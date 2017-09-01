package selfawarelab.Bits;

import java.util.ArrayList;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Bits {
    private ArrayList<Integer> int2subset(int binary, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        for(int i = 0; binary > 0; binary >>= 1, i++) {
            if((binary & 1) == 1)
                subset.add(set.get(i));
        }
//        for(int i = binary; i > 0; i >>= 1) {
//            if((i & 1) == 1) {
//                log(i + " bit = 1");
//            } else {
//                log(i + " bit = 0");
//            }
//        }
        return subset;
    }

    // Does it really matter if we start from the high bit or the low bit?
    private void int2binary(int num) {
        // move the bit we check
//        int bitPostion = 1;
//        for(int i = 0; i < 3; i++) {
//            log("Number: " + num + " bit: " + bitPostion + " value: " + (num & bitPostion));
//            bitPostion <<= 1;
//        }
        // move the number we check
        System.out.println("Number: " + num + " bits: " + getBits(num));
//        for(int i = 0; i < 3; i++) {
//            log("Number: " + num + " bit: " + (int) Math.pow(2, i) + " value: " + (num & 1));
//            num >>= 1;
//        }

//        for(int i = 0; i < 3; i++) {
//            log("Number: " + num + " bit: " + (int) Math.pow(2, i) + " value: " + (num & 1));
//            num >>= 1;
//        }

        for(int i = 0; num > 0; num >>= 1, i++) {
            System.out.println("Number: " + num + " bit: " + (int) Math.pow(2, i) + " value: " + (num & 1));
        }

        System.out.println("-----");
    }

    // Use this sort of loop to do your math
    private int getBits(int num) {
//        log("Number: " + num);
        int bits = 0;
//        for(; num > 0; num /=2, bits++) {
//            log(num + " " + bits);
//        }
        for(; num > 0; num >>= 1, bits++) { // modification is done before the evaluation. Kind of meaningless for 0
//            log(num + " " + bits);
        }
//        log("selfawarelab.Bits: " + bits);
        return bits;
    }

//    public static string intToBinary(int n)
//    {
//        string s = "";
//        while (n > 0)
//        {
//            s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
//            n = n / 2;
//        }
//        return s;
//    }

}
