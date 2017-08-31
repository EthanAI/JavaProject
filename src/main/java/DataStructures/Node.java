package DataStructures;

/**
 * Created by ethansmith on 8/30/17.
 */

public class Node {
    public int data;
    public Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }

    public void outputList() {
        Node n = this;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void reverseList() {
        Node current = this;
        Node next = null;

        while(current != null) {
            Node temp = current.next; // Store so we can iterate forward
            current.next = temp; // Overwrite pointer so we go back
            current = temp;
        }
    }

    public static Node getLinkedList(int... value) {
        Node head = null;

        Node last = null;
        for(int v : value) {
            Node newNode = new Node(v);
            if(head == null) {
                head = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
        }
        return head;
    }
}
