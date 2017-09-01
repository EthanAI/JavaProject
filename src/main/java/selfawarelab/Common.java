package selfawarelab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Common {

    // Logging
    public static void log() {
        log("");
    }

    public static void log(int num) {
        log(num + "");
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void log(String tag, String text) {
        log(tag + ":" + text);
    }


    public static <T> void log(ArrayList<T> arrayList) {
        String outputString = "";
        for(T object : arrayList) {
            outputString += object + " ";
        }
        log(outputString);
    }

    // Sample data
    public static int[] getArray() {
        int[] array = {24, 5, 3, 35, 14, 23, 23, 19, 43, 2};
        return array;
    }

    public static int[] getSimpleArray() {
        int[] array = {3, 5, 7};
        return array;
    }

    public static ArrayList<Integer> getArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int n : getArray())
            arrayList.add(n);
        return arrayList;
    }

    public static ArrayList<Integer> getSimpleArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int n : getSimpleArray())
            arrayList.add(n);
        return arrayList;
    }

    // Math
    public double random(int low, int high) {
        /*
         Math.random() * high; // will give a range of [0,10)
         Meaning (int) Math.random() * high will give a range of 0 -> high - 1
         Range of ints 0 -> high requires Math.random() * (high + 1)
         Range of low -> high requires low + Math.random() * (length)
         length = (high - low + 1) (How many buckets we must fill. 0 -> 1 = 2 buckets)
         low + Math.random() * (high - low + 1)
        */
        return low + (int) (Math.random() * (high - low + 1));
    }


    // To Strings
    public static <T> String arrayListToString(List<T> list) {
        String outputString = "";
        for(T object : list) {
            outputString += object + " ";
        }
        return outputString;
    }

    public static <T> String arrayListToString(ArrayList<T> arrayList, int startInd, int endInd) {
        return arrayListToString(arrayList.subList(startInd, endInd + 1));
    }

    public static String arrayToString(int[] array) {
        String outputString = "";
        for(int i : array) {
            outputString += i + " ";
        }
        return  outputString;
    }
}
