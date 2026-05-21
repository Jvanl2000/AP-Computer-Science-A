// A generic stack, implemented as a linked list.
// Each stack element is of type Item.

// generictobe.txt: to be or not to - be - - that - - - is
// output: to be not that or be (2 left on stack)

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    
    private int n;          // size of the stack
    private Node first;     // top of stack

    // Node is a helper linked list class.
    // Note that we can indeed have nested classes.
    private class Node {
        private Item item;
        private Node next;
    }

   // The constructor for GenericStack.
   // Initializes an empty stack.
    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    // Add an element to the head of a stack.
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // Remove and return the head element of a stack.
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; // save item to return
        first = first.next;     // delete first node
        n--;
        return item;            // return the saved item
    }


    // Return but do not remove the head item of a stack.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    // Build a return a string representation of a stack.
    // Note the use of the enhanced for loop.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    // Returns an iterator for this stack
    // that iterates through the items in LIFO order.
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // A list iterator class for generic stacks.
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // 4.3.31
    // public int max() {
    //     return Math.max(first.item, max(first.next));
    // }

    // 4.3.30
    public void remove(String key) {
        if (first.item.equals(key)) {
            first = first.next;
            n--;
            return;
        }

        Node current = first;
        while (current.next != null) {
            if (current.next.item.equals(key)) {
                current.next = current.next.next;
                n--;
                return;
            }
            current = current.next;
        }
    }

    // 4.3.29
    public Stack<Item> copy() {
        Stack<Item> copyStack = new Stack<>();
        for (Item item : this)
            copyStack.push(item);
        return copyStack;
    }

    // 4.3.28
    public void removeAfter(Node node) {
        node.next = node.next.next;
    }

    // 4.3.25
    public void delete(int k) {
        Node current = first;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        n--;
    }

    // 4.3.24
    public boolean find(String key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // A test client for GenericStack.
    public static void main(String[] args) {
        // We begin with a stack of strings.
        // GenericStack<String> stackOne = new GenericStack<String>();
        // while (!StdIn.isEmpty()) {
        //     String item = StdIn.readString();
        //     if (!item.equals("-")) stackOne.push(item);
        //     else if (!stackOne.isEmpty()) StdOut.print(stackOne.pop() + " ");
        // }
        // StdOut.println("(" + stackOne.size() + " left on stack)");
        // StdOut.print("final state of stack:");
        // StdOut.println(stackOne);
        
        // Now let's do a stack of integers.
        Stack<Integer> stackTwo = new Stack<Integer>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")){
                Integer intItem = Integer.valueOf(item);
                stackTwo.push(intItem);
            }
            else if (!stackTwo.isEmpty()) StdOut.print(stackTwo.pop() + " ");
        }
        StdOut.println("(" + stackTwo.size() + " left on stack)");
        StdOut.print("final state of stack:");
        StdOut.println(stackTwo);  
    }
}