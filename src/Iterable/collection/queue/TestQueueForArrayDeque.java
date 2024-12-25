package Iterable.collection.queue;

/* Queue<T> is an interface which is implemented from Collection<T> interface.

    01) boolean	    add(E e)
    02) E	        element()
    03) boolean	    offer(E e)
    04) E	        peek()
    05) E	        poll()
    06) E	        remove()

 **/

import java.util.ArrayDeque;

public class TestQueueForArrayDeque {
    public static void main(String[] args) {

        ArrayDeque<String> list1=new ArrayDeque<>();
       // 01) boolean  add(E e)
        list1.add("S");
        list1.add("A");
        list1.add("K");
        list1.add("U");
        list1.add("J");
        list1.add("A");

        System.out.println(list1); // [S, A, K, U, J, A]

       // 02) E	 element()

        System.out.println(list1.element()); // S - The head of the queue
        //list1.clear();
        //System.out.println(list1.element()); // --> NoSuchElementException

       // 03) boolean  offer(E e)
        System.out.println(list1.offer("H")); // true - Adds H at the last passion of the queue
        System.out.println(list1); // [S, A, K, U, J, A, H]

       // 04) E	 peek()
        System.out.println(list1.peek()); //S - Here doesn't remove the element
        //list1.clear();
        //System.out.println(list1.peek()); // --> null

       // 05) E	 poll()
        System.out.println(list1.poll()); //S - Removes the element at the head of list
        System.out.println(list1); //[A, K, U, J, A, H]
        //list1.clear();
        //System.out.println(list1.poll()); // --> null

       // 06) E	 remove()
        System.out.println(list1.remove()); //A
        //list1.clear();
        //System.out.println(list1.remove()); // --> NoSuchElementException



    }
}
