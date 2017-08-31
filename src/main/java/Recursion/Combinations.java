package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Combinations {
    // Recursive
    // Make in list and out list two parameters?
    private List<Integer> recursiveCombine(List<Integer> list) {
        if(list.size() > 1) {
            Integer lastItem = list.get(list.size() - 2);
            List<Integer> appendList = new ArrayList<>();
            List<Integer> currentList = recursiveCombine(list.subList(1, list.size()));
            for(Integer i : currentList) {
                appendList.add(lastItem * i);
            }
            appendList.add(lastItem);
            currentList.addAll(appendList);
            return currentList;
        } else {
            return list;
        }

//        if(list.size() == 1) {
////            output.add(list.get(0));
//            return list;  // Return base case, do not continue recursion of smaller
//        } else {
//            List<Integer> temp = recursiveCombine(list.subList(1, list.size()));
//            log(temp.toString());
//            return temp;
////            output.addAll(list);
////            for (int i = 0; i < list.size(); i++) {
////                output.add(n *)
////            }
//        }
    }

//    private List iterativeCombine(List<Integer> list) {
//        ArrayList<Integer> output = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//            output.add(list.get(i));
//            for(int j = 0; j < output.size(); j++) {
//                output.add()
//            }
//        }
//    }

    // Treat as binary numbers
    void binaryCombine(ArrayList<Integer> set) {
        int bits = set.size();
        for(int i = 1; i <= Math.pow(2, bits); i++) {
            ArrayList<Integer> subset = int2subset(i, set);
            System.out.println(i + " " + subset.toString());
        }



//        int min = 1; // dont need empty set
//        int max = 1 << bits;
//        max--;
//
////        log(max);
//
//        for(int i = min; i <= max; i++) {
//            log("Calling: " + i);
//
//            ArrayList<Integer> subset = int2subset(i, set);
//            for(Integer n : subset) {
//                log(n);
//            }
//        }
    }


    private ArrayList<Integer> int2subset(int binary, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        for(int i = 0; binary > 0; binary >>= 1, i++) {
            if((binary & 1) == 1)
                subset.add(set.get(i));
        }
        return subset;
    }
}
