package selfawarelab.DataStructures;

import static selfawarelab.Common.log;

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
            log(n.data);
            n = n.next;
        }
    }

    public Node reverseList() {
        Node current = this;
        Node old = null; // the previous node the current node needs to start pointing to

        while(current != null) {
            Node future = current.next; // Store next node so we can iterate forward\

            current.next = old; // Reassign the next pointer so this node aims in reverse now

            old = current;  // save current node to be the future old node
            current = future; // Move to next node so we can repeat the process
        }

        return old; // Current should be null. Old should be last valid node
    }

    public static Node makeLinkedList(int... value) {
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
