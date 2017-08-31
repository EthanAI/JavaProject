import DataStructures.Node;
import Recursion.Fibonacci;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Main {
    public static void main(String[] args) {

        Node n = Node.getLinkedList(3, 5, 7, 9);
        n.outputList();
        n.reverseList();
        n.outputList();

//        for(int i = 0; i <= 8; i++) {
//            log(i + " " + Fibonacci.dynamicFib(i));
//        }
//        log(Fibonacci.fibArray(7));
//        Fibonacci.iterativeFib(7);
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void log(int num) {
        log(num + "");
    }
}
