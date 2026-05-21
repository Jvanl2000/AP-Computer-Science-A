// Last In, First Out (LIFO) Linked List, aka Stack.
// Note that the assumed type of the elements in the
// stack is String. See GenericStack for code
// that lifts this requirement.

// Dependency: the Node class. 

public class LinkedList {
    
    private Node head;
    private Integer length = 0;
    
    public void push(String item) {
        // Insert a new node at the start
        // of the linked list. The next of the
        // last element will be null.
        Node previousHead = head;
        Node newHead = new Node();
        newHead.item = item;
        newHead.next = previousHead;
        this.head = newHead;
        this.length += 1;
    }
    
    public String pop() {
        // Remove and return the current head.
        String item = head.item;
        this.head = head.next;
        this.length -= 1;
        return item;
    }
    
    public String peek() {
        // Return but do not remove the current head.
        return this.head.item;
    }
    
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    public Integer size() {
        return this.length;
    }
    
    @Override
    public String toString() {
        // Build a return a string representation
        // of a linked list. Form: {item, item, ...}.
        if (this.head == null) {
            return "{}";
        } else {
            String strRep = "{";
            Node currentNode = this.head;
            while (currentNode != null) {
                if (currentNode.next == null) {
                    strRep += currentNode.item;
                } else {
                    strRep += currentNode.item + ", ";
                }
                currentNode = currentNode.next;
            }
            return strRep + "}";
        }
    }
    
    // main is the test client.
    // Another test client is found in TestClient.java.
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // The linked list is empty to begin.
        // Note that head is thus null.
        System.out.println(list);
        System.out.println(list.head);
        System.out.println(list.isEmpty());
        // We now push a node into linked list.
        // It becomes the new head, and its next
        // will be null.
        list.push("or");
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.head.next);
        list.push("be");
        System.out.println(list);
        list.push("to");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.peek());
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
    }
}