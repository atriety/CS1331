
public class LinkedTester {
    public static void main(String[] args){
        LinkedList<String> numbLinkedList = new LinkedList<>();
        System.out.println(numbLinkedList.size());
        numbLinkedList.addAtIndex("Hello", 0);
        numbLinkedList.addAtIndex("World", 1);
        numbLinkedList.addAtIndex("Test", 1);

        // numbLinkedList.addAtIndex("Insert", 1);
        // numbLinkedList.addAtIndex("Insert again", 1);
        // numbLinkedList.addAtIndex("Insert again", 1);
        // numbLinkedList.addAtIndex("New head", 0);
        // numbLinkedList.addAtIndex("New head 2", 0);


        System.out.println(numbLinkedList.isEmpty());
        System.out.println(numbLinkedList.size());
        System.out.println(numbLinkedList.size);
        System.out.println(numbLinkedList.remove("Hello"));
        System.out.println(numbLinkedList.size());
        System.out.println(numbLinkedList.size);
        System.out.println(numbLinkedList.remove("Test"));
        System.out.println(numbLinkedList.remove("World"));



        // System.out.println(numbLinkedList.removeAtIndex(0));

        System.out.println(numbLinkedList.getAtIndex(0));
        // System.out.println(numbLinkedList.getAtIndex(0));
        // System.out.println(numbLinkedList.getAtIndex(1));

        // System.out.println(numbLinkedList.getAtIndex(2));
        // System.out.println(numbLinkedList.getAtIndex(3));

        // System.out.println(numbLinkedList.getAtIndex(4));
        System.out.println(numbLinkedList.getHead().getData());
        System.out.println(numbLinkedList.getTail().getData());
        // System.out.println(numbLinkedList.getTail().getNext());
        // numbLinkedList.clear();
        // System.out.println(numbLinkedList.getTail().getData());
        // System.out.println(numbLinkedList.getHead().getData());

    }
}
