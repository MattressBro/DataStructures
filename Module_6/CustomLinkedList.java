package Module6;
import java.util.*;


public class CustomLinkedList {
    private static Node head;
    
        public void insert(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        public static void delete(int data) {
                if (head == null) {
                return;
            }
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    
        public Iterator<Integer> iterator() {
            return new LinkedListIterator();
        }
    
        private class Node {
            int data;
            Node next;
    
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        private class LinkedListIterator implements Iterator<Integer> {
            private Node current = head;
    
            @Override
            public boolean hasNext() {
                return current != null;
            }
    
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int data = current.data;
                current = current.next;
                return data;
            }
        }
    
        // Other methods...
        public static void main(String[] args) {
            CustomLinkedList linkedList = new CustomLinkedList();
        
            // Insert some elements
            linkedList.insert(1);
            linkedList.insert(2);
            linkedList.insert(3);
        
            // Iterate and display elements
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println("Deleting 2");
            delete(2);
    }
}



