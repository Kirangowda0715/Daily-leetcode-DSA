class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DoublyLinkedList {

    // Convert Array to DLL
    public static Node convertArrToDLL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    // 🔹 Insert at Beginning
    public static Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) return newNode;

        newNode.next = head;
        head.prev = newNode;

        return newNode; // new head
    }

    // 🔹 Insert at End
    public static Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // 🔹 Insert at Kth Position (1-based index)
    public static Node insertAtK(Node head, int k, int val) {
        if (k == 1) return insertAtBeginning(head, val);

        Node temp = head;
        int count = 1;

        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) return head;

        Node newNode = new Node(val);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        return head;
    }

    // 🔹 Delete Head
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;

        head = head.next;
        head.prev = null;

        return head;
    }

    // 🔹 Delete Tail
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;

        return head;
    }

    // 🔹 Delete Kth Node
    public static Node deleteKthNode(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (temp == null) return head;

        // delete head
        if (temp.prev == null) {
            return deleteHead(head);
        }

        // delete tail
        if (temp.next == null) {
            temp.prev.next = null;
            return head;
        }

        // middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }

    // 🔹 Print DLL
    public static void print(Node head) {
        System.out.print("DLL: ");
        while (head != null) {
            System.out.print(head.data + " <-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = convertArrToDLL(arr);

        head = insertAtBeginning(head, 0);
        head = insertAtEnd(head, 6);
        head = insertAtK(head, 3, 99);

        head = deleteHead(head);
        head = deleteTail(head);
        head = deleteKthNode(head, 3);

        print(head);
    }
}