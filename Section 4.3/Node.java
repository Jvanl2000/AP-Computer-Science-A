// Note the assumption that the data item
// contained in a node is a String.

public class Node {
    
    String item;
    Node next;
    
    @Override
    public String toString() {
        return this.item;
    }
    
    // main contains the test client.
    // main builds a simple linked list
    // that consists of three nodes.
    // Note that the value of next of the node
    // third is by default null.
    public static void main(String[] args) {
        // First we create three nodes.
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        
        // Next we add data to each node.
        first.item = "to";
        second.item = "be";
        third.item = "or";
        
        // Last we link the nodes.
        first.next = second;
        second.next = third;
        
        System.out.println(first.item);
        System.out.println(second.item);
        System.out.println(third.item);
        
        System.out.println(first.next.item);
        System.out.println(first.next.next.item);
        
        // The value of next for the last node
        // is by default null.
        System.out.println(third.next);
        
        System.out.println("done");
    }
}