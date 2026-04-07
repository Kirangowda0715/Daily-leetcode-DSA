class Node{
    int data;
    Node next;
    Node prev;

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
    Node(int data1, Node next1, Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }
}

public class doubly_ll_basics_strivers {
    private static Node ConvertArrtoDLL(int[] arr){
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i], null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }
    private static void print(Node head){
        System.out.println("printing DLL");
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        Node head = ConvertArrtoDLL(arr);
        print(head);

    }

}