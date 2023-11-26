import java.util.NoSuchElementException;


public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    
    public int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = size();
    }

    public void addAtIndex(T data, int index) {
        Node<T> newNode;
        if(index > this.size() || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } 
        else if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }        
        else if (index == 0){ //add at the beginning 
            if(this.size() == 0) {
               newNode = new Node<T>(data);
               head = newNode;
               tail = head; 
            } else {
               newNode = new Node<T>(data, head);
               head = newNode;
            }
        } 
        else if (index == this.size()){ //add at the end size or (max index + 1)
            Node<T> current = head;
            newNode = new Node<T>(data);

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            tail = newNode;
        } 
        else {  // in between
            Node<T> current = head;
            Node<T> previous = null;

            //find current node at index and shift lefst
            for(int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            newNode = new Node<T>(data, current);
            previous.setNext(newNode);
        }
        this.size++;
    }
         

    public T getAtIndex(int index) {
        int i = 0;
        // boolean tester = true;
        Node<T> current = head;
        if(index > (this.size() - 1) || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } else {
            while(i < index) {
                i++;
                current = current.getNext();
            }

        }
        return current.getData();
    }

    public T removeAtIndex(int index) {
        int i = 0;
        Node<T> current = head;
        Node<T> removedNode = null;
        if(index > this.size || index < 0 || isEmpty()) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } else if (index == 0) {
            removedNode = head;
            head = (this.size() == 1)? null : head.getNext();
        }  else { 
            while(i < (index - 1)) { //find cell before node
                i++;
                removedNode = current.getNext();
                current = current.getNext();
                if(index == this.size()-1) { //handle node at the end
                    tail = current;
                    current.setNext(null);
                } else {
                    current.setNext(removedNode.getNext());
                }
            }
            current.setNext(current.getNext().getNext());
        }
        this.size--;
        return removedNode.getData();
    }



    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        for (int index = 0; index < this.size(); index++) {
            if(this.getAtIndex(index).equals(data)) {
                return removeAtIndex(index);
            } 
        } 
        throw new NoSuchElementException("The data is not present in the list.");  
        //find index and use remove index 
    }

    public void clear() {
       head = new Node<T>(null);
       tail = head;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        if(isEmpty()) {
            return 0;
        } 
        return this.size;
  
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

}
