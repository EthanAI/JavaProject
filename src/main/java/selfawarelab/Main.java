package selfawarelab;

import java.util.ArrayList;

import selfawarelab.DataStructures.Node;
import selfawarelab.Recursion.Fibonacci;

import static selfawarelab.Common.*;
import static selfawarelab.Recursion.Combinations.dynamicCombos;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Main {
    public static void main(String[] args) {
//        Node n = Node.getLinkedList(3, 5, 7, 9);
//        n.outputList();
//        log();
//        n = n.reverseList();
//        n.outputList();
//        log();
//
//        for(int i = 0; i <= 8; i++) {
//            log(i + " " + Fibonacci.dynamicFib(i));
//        }
//        log();
//
//        log(Fibonacci.fibArray(7));
//        log();
//
//        Fibonacci.iterativeFib(7);
//        log();

        ArrayList<Integer> setAL = getSimpleArrayList();
        ArrayList<Integer> combosAL = dynamicCombos(setAL);
        log(combosAL);
        log();

        int[] setAr = getSimpleArray();
        int[] combosAr = dynamicCombos(setAr);
        logs(combosAr);
        log();
    }

    private static void logs(int[] array) {
        String outputString = "";
        for(int num : array) {
            outputString += num + " ";
        }
        log(outputString);
    }
}
