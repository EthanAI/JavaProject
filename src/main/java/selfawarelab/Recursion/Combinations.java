package selfawarelab.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Combinations {
    // Recursive
    // Make in list and out list two parameters?
    private static List<Integer> recursiveCombine(List<Integer> list) {
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

//    public static ArrayList<ArrayList<Integer>> recursiveComboLists(ArrayList<Integer> set, int index) {
//        // Base Case
//        if(set.size() == 0) {
//            return new ArrayList<>()
//        }
//        // Get previous work
//        // Modify it
//        // Return modifications to higher tier
//
//    }

        // Dynamic programming (because it has cache)
    static int[] cacheArr;
    public static int[] dynamicCombos(int[] set) {
        int oldIndex = -1;
        int emptyIndex = 0;

        // Initialize array that holds results
         if(cacheArr == null) {
             int comboCount = (int) Math.pow(2, set.length) - 1;
             cacheArr = new int[comboCount];
         }
         for(int num : set) {
             cacheArr[emptyIndex++] = num; // Assign the pure value and increment our index

             for(int i = 0; i < oldIndex; i++) {
                 // Fill from next available bucket. Do math and fill for as many buckets as you STARTED with
                 cacheArr[emptyIndex++] = num * cacheArr[i];
             }

             // Store location of last item
             oldIndex = emptyIndex;

         }

         return cacheArr;
    }

    // Dynamic iterative
    static ArrayList<Integer> cacheAL = new ArrayList<>();
    public static ArrayList<Integer> dynamicCombos(ArrayList<Integer> set) {
        for(Integer num : set) {
            int oldSize = cacheAL.size();
            for(int i = 0; i < oldSize; i++) {
                cacheAL.add(num * cacheAL.get(i));
            }
            cacheAL.add(num);
        }
        return cacheAL;
    }

    // Return Sets
    public static ArrayList<ArrayList<Integer>> cacheAAL = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> dynamicComboSets(ArrayList<Integer> set) {
        for(Integer num : set) {
            ArrayList<ArrayList<Integer>> additionalCombos = new ArrayList<>();
            for (ArrayList<Integer> subset : cacheAAL) { // Arraylist will grow as we add more
                ArrayList<Integer> newSubset = new ArrayList<>(subset); // Deep Copy
                newSubset.add(num);
                additionalCombos.add(newSubset);
            }
            cacheAAL.addAll(additionalCombos);
            ArrayList<Integer> newSubset = new ArrayList<>();
            newSubset.add(num);
            cacheAAL.add(newSubset);
        }
        return cacheAAL;
    }

    // Revised to use index points instead of creating partial solutions and appending them
    public static ArrayList<ArrayList<Integer>> dynamicComboSets2(ArrayList<Integer> set) {
        for(Integer num : set) {
            int oldSize = cacheAAL.size();

            ArrayList<Integer> newSubset = new ArrayList<>();
            newSubset.add(num);
            cacheAAL.add(newSubset);

            for(int i = 0; i < oldSize; i++) {
                ArrayList<Integer> subset = cacheAAL.get(i);
                newSubset = new ArrayList<>(subset); // Deep Copy
                newSubset.add(num);
                cacheAAL.add(newSubset);
            }

        }
        return cacheAAL;
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
    static void binaryCombine(ArrayList<Integer> set) {
        int bits = set.size();
        for(int i = 1; i <= Math.pow(2, bits); i++) {
            ArrayList<Integer> subset = binary2subset(i, set);
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


    private static ArrayList<Integer> binary2subset(int binary, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        for(int i = 0; binary > 0; binary >>= 1, i++) {
            if((binary & 1) == 1)
                subset.add(set.get(i));
        }
        return subset;
    }
}
