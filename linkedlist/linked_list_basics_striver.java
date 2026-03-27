public class linked_list_basics_striver {
    // Node is kept as a static inner class for clarity and encapsulation.
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head is an instance field representing the start of the list.
    private Node head;

    // Insert at the beginning: update the instance `head`.
    public void insertAtBeg(int data) {
        Node node = new Node(data);
        node.next = head; // new node points to former head
        head = node;      // head now references the new node
    }

    // Insert at the end: handle empty list and traverse using temp.next
    // (previous code iterated until temp == null which then dereferenced temp).
    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) { // empty list: new node becomes head
            head = node;
            return;
        }
        Node temp = head;
        // traverse to the last node (temp.next == null)
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node; // append new node
    }

    // Remove head: update `head` to next node (previous code tried to
    // modify a local parameter and didn't affect the caller's head).
    public void removeHead() {
        if (head == null) return;
        head = head.next; // allow former head to be GC'd
    }

    // Remove tail: handle empty and single-element lists correctly.
    public void removeTail() {
        if (head == null) return;           // nothing to remove
        if (head.next == null) { head = null; return; } // single element
        Node temp = head;
        // stop at second-last node (temp.next.next == null)
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; // drop last node
    }

    // Utility: print list contents for quick verification.
    public void printList() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }

    // Simple main to exercise methods and demonstrate the fixes.
    public static void main(String[] args) {
        linked_list_basics_striver ll = new linked_list_basics_striver();
        ll.insertAtBeg(3);   // list: 3
        ll.insertAtBeg(2);   // list: 2 3
        ll.insertAtEnd(4);   // list: 2 3 4
        System.out.print("After inserts: ");
        ll.printList();      // expected: 2 3 4

        ll.removeHead();     // list: 3 4
        ll.removeTail();     // list: 3
        System.out.print("After removals: ");
        ll.printList();      // expected: 3
    }
}