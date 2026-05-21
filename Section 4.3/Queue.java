// A generic queue, implemented via a linked list.

import java.util.Iterator;
import java.util.NoSuchElementException;

// The class represents a first-in-first-out (FIFO) queue of
// generic items. It supports the usual enqueue and dequeue
// operations, along with methods to peek the top item, test if the
// queue is empty, return the number of items in the queue, and iterate
// over the items in FIFO order.

// This implementation uses a singly-linked list with a nested class for
// linked-list nodes.

public class Queue<Item> implements Iterable<Item> {
    
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // Helper linked list class.
    private class Node {
        private Item item;   // the item in the node
        private Node next;   // reference to next item
    }

    // Initializes an empty queue.
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this queue.
    public int size() {
        return n;
    }

    // Returns the item first added to this queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    // Add the item to the queue. Note that items are added
    // to the right of the linked list. Thus the leftmost item
    // in the linked list was the first item added.
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    // Removes and returns the item on this queue that was first added.
    // This will be the leftmost item, since queues are FIFO and items
    // are added on the right.
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    // Returns a string representation of this queue.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item).append(" ");
        return s.toString();
    }

    // Returns an iterator that iterates over the items in this queue in FIFO order.
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // An iterator.
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // The test client.
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                StdOut.print("item queued: ");
                StdOut.println(item);
                queue.enqueue(item);
                StdOut.print("curret state of queue: ");
                StdOut.println(queue);
            }
            else if (!queue.isEmpty()) {
                StdOut.print("item dequeued: ");
                StdOut.println(queue.dequeue() + " ");
                StdOut.print("curret state of queue: ");
                StdOut.println(queue);
            }
        }
        StdOut.print("done");
    }
}