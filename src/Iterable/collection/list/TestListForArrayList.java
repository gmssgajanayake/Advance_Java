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

Main functions of ArrayList class -->

     11) Object	            clone()
     12) void	            ensureCapacity(int minCapacity)
     13) boolean            removeIf(Predicate<? super E> filter)
     14) protected void     removeRange(int fromIndex, int toIndex)
     15) void	            replaceAll(UnaryOperator<E> operator)
     16) void	            trimToSize()

 **/



import java.util.ArrayList;
import java.util.ListIterator;

public class TestListForArrayList {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();

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

        ArrayList<String> list2 = new ArrayList<>();

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

        // 11) Object  clone()
        ArrayList<String> list3=(ArrayList<String>) list1.clone();
        System.out.println(list3); // Get a copy of ArrayList
        System.out.println(list1.hashCode() +", "+list3.hashCode());  // -1994894479, -1994894479
        list3.clear();
        System.out.println(list1);
        System.out.println(list3);


        // 12) void	 ensureCapacity(int minCapacity)
        list1.ensureCapacity(3); // ?????????
        //list1.add(30,"fr");

        // 13) boolean  removeIf(Predicate<? super E> filter) //??

    }
}
