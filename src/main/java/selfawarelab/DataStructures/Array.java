package selfawarelab.DataStructures;

import static selfawarelab.Common.log;

/**
 * Created by ethansmith on 9/7/17.
 */

public class Array {

    /*
        if length = 3 Odd
        length / 2 = 1 (trunkated / floor of 1.5)
        < length / 2 means we will do index 0. The first and last elements. No need to touch middle one

        if length = 4 Even
        length / 2 = 2
        < length / 2 means we will do index 0 and 1. All elements will be swapped. No overlapping
     */
    public static int[] reverseArray(int[] array) {
        // Iterate through the list swapping the first and last
        log("Length / 2: " + array.length / 2);
        for(int i = 0; i < array.length / 2; i++) {
            log(i);
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] makeArray(int ... values) {
        return values;
    }
}
