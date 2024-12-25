package Iterable.collection.list;

/* List<T> is an interface that is extended from Collection<T> interface.

Main functions of List<T> -->
     01) boolean	        add(int index, E element)
     02) boolean	        addAll(int index, Collection<? extends E> c)
     03) E	                get(int index)
     04) int	            indexOf(Object o)
     05) int	            lastIndexOf(Object o)
     06) ListIterator<E>	listIterator()
     07) ListIterator<E>	listIterator(int index)

         * Note - ListIterator<E> is an interface extended from Iterator<E>
          Iterator<T> interface -->
             01) boolean	        hasNext()
             02) E	                next()
             03) default void	    forEachRemaining(Consumer<? super E> action)
             04) default void	    remove()

          ListIterator<T> interface -->
             05) void	            add(E e)
             06) boolean            hasPrevious()
             07) int	            nextIndex()
             08) E	                previous()
             09) int	            previousIndex()
             10) void	            remove()
             11) void	            set(E e)

     08) E	                remove(int index)
     09) E	                set(int index, E element)
     10) List<E>	        subList(int fromIndex, int toIndex)

Main functions of LinkedList class -->

     11) void	            addFirst(E e)
     12) void	            addLast(E e)
     13) E	                getFirst()
     14) E	                getLast()
     15) boolean	        offer(E e)
     16) boolean	        offerFirst(E e)
     17) boolean	        offerLast(E e)
     18) E	                peek()
     19) E	                peekFirst()
     20) E	                peekLast()
     21) E	                poll()
     22) E	                pollFirst()
     23) E	                pollLast()
     24) E	                pop()
     25) void	            push(E e)
     26) E	                removeFirst()
     27) E	                removeLast()
 **/

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.SortedMap;

public class TestListForLinkedList {
    public static void main(String[] args) {


        LinkedList<String> list1 = new LinkedList<>();

        list1.add("S");
        list1.add("A");
        list1.add("K");
        list1.add("U");
        list1.add("J");
        list1.add("A");

        // 01) boolean	add(int index, E element)

        list1.add(5, "P");
        System.out.println(list1);  // [S, A, K, U, J, P, A]

        list1.add(7, "K");
        System.out.println(list1);  // [S, A, K, U, J, P, A, K]

        //list1.add(10,"K"); // Illegal statement
        //Note - It trows an IndexOutOfBoundsException

        // 02) boolean  addAll(int index, Collection<? extends E> c)

        LinkedList<String> list2 = new LinkedList<>();

        list2.add("S");
        list2.add("H");
        list2.add("A");
        list2.add("M");
        list2.add("A");
        list2.add("L");

        //list1.addAll(10,list2); // Illegal statement
        //Note - It trows an IndexOutOfBoundsException

        list1.addAll(3, list2);
        System.out.println(list1); // [S, A, K, S, H, A, M, A, L, U, J, P, A, K]

        // 03) E  get(int index)
        System.out.println(list1.get(4));

        // 04) int	indexOf(Object o)
        System.out.println(list1.indexOf("S")); // 0 Note - Only first occur
        System.out.println(list1.indexOf(8)); // -1

        // 05) int	            lastIndexOf(Object o)
        System.out.println(list1.lastIndexOf("S")); // 3 Note - Only last occur
        System.out.println(list1.indexOf(4.45)); // -1

        // 06) ListIterator<E>	listIterator()

        ListIterator<String> listIterator = list1.listIterator();
        // Iterator<T> interface -->
        // Methods (01 to 04) of Iterator<T> interface was tasted in "TestIteratorForArrayList" class

        // ListIterator<T> interface -->
        // 05) void	  add(E e)
        listIterator.add("L"); // current element --> L
        System.out.println(list1); // [L, S, A, K, S, H, A, M, A, L, U, J, P, A, K]

        listIterator.add("N"); // // current element --> N
        System.out.println(list1); // [L, N, S, A, K, S, H, A, M, A, L, U, J, P, A, K]

        // 06) boolean  hasPrevious()
        // current element --> N
        System.out.println(listIterator.hasPrevious()); //true , current element --> N
        System.out.println(listIterator.next()); // current element --> S


        // 07) int	nextIndex()
        // current element --> S
        System.out.println(listIterator.nextIndex()); // 3 current element --> S

        // 08) E previous()
        // current element --> S
        System.out.println(list1); // [L, N, S, A, K, S, H, A, M, A, L, U, J, P, A, K]
        System.out.println(listIterator.previous()); // current element --> N
        System.out.println(listIterator.previous()); // current element --> L


        // 09) int	previousIndex()
        System.out.println(listIterator.previousIndex()); // 0
        listIterator.previous();
        System.out.println(listIterator.previousIndex()); // -1


        // 10) void	 remove()
        listIterator.remove(); // Removes current element
        System.out.println(list1); // Now, there no current element

        // 11) void	 set(E e)
        //listIterator.previous();  // NoSuchElementException
        listIterator.next(); // Makes "N" as current location
        listIterator.set("V"); // Replaces current element from given element
        System.out.println(list1);

        // 07) ListIterator<E>	listIterator(int index)
        listIterator = list1.listIterator(6);
        System.out.println(listIterator.nextIndex()); //7 but --> 6 ???

        // 08) E  remove(int index)
        System.out.println(list1.remove(2)); // A
        System.out.println(list1); // [V, S, K, S, H, A, M, A, L, U, J, P, A, K]

        // 09) E  set(int index, E element)
        System.out.println(list1.set(5,"F")); // A, Note - Replaces element A from F
        System.out.println(list1); // [V, S, K, S, H, F, M, A, L, U, J, P, A, K]
        //                                            ^

        // 10) List<E>  subList(int fromIndex, int toIndex)
        System.out.println(list1.subList(2,7)); // [K, S, H, F, M]

        // 11) void	 addFirst(E e)
        list1.addFirst("Z");

        // 12) void	 addLast(E e)
        list1.addLast("X");

        // 13) E  getFirst()
        System.out.println(list1.getFirst()); //Z

        // 14) E  getLast()
        System.out.println(list1.getLast()); //X

        // 15) boolean	offer(E e)
        System.out.println(list1.offer("L")); // true - Adds to last
        System.out.println(list1);

        // 16) boolean	offerFirst(E e)
        System.out.println(list1.offerFirst("B")); // true - Adds to front
        System.out.println(list1);

        // 17) boolean	offerLast(E e)
        System.out.println(list1.offerLast("J")); // true - Adds to end
        System.out.println(list1);

        //[B, Z, V, S, K, S, H, F, M, A, L, U, J, P, A, K, X, L, J]
        // 18) E  peek()
        System.out.println(list1.peek()); // B

        // 19) E  peekFirst()
        System.out.println(list1.peekFirst()); // B

        // 20) E  peekLast()
        System.out.println(list1.peekLast());// J

        // 21) E  poll()
        System.out.println(list1.poll()); // B -> Note - removes B
        System.out.println(list1); // [Z, V, S, K, S, H, F, M, A, L, U, J, P, A, K, X, L, J]

        // 22) E  pollFirst()
        System.out.println(list1.pollFirst());// Z

        // 23) E  pollLast()
        System.out.println(list1.pollLast());// J

        // 24) E  pop()
        System.out.println(list1.pop()); //V
        System.out.println(list1); // [S, K, S, H, F, M, A, L, U, J, P, A, K, X, L]

        // 25) void	 push(E e)
        list1.push("U");
        System.out.println(list1);

        // 26) E  removeFirst()
        System.out.println(list1.removeFirst()); //U

        // 27) E  removeLast()
        System.out.println(list1.removeLast()); // L

        System.out.println(list1);

    }
}
