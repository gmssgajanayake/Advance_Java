package Iterable.collection;

/* Collection<T> is an interface that is extended from Iterable<T> interface.

Main functions -->
     01) boolean	add(E e)
     02) boolean	addAll(Collection<? extends E> c)
     03) void	    clear()
     04) boolean	contains(Object o)
     05) boolean	containsAll(Collection<?> c)
     06) boolean	equals(Object o)
     07) int	    hashCode()
     08) boolean	isEmpty()
     09) boolean	remove(Object o)
     10) boolean	removeAll(Collection<?> c)
     11) boolean	retainAll(Collection<?> c)
     12) int	    size()
     13) Object[]	toArray()
     14) <T> T[]	toArray(T[] a)
 **/

import java.util.ArrayDeque;

public class TestCollectionForArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> list1 = new ArrayDeque<>();

        // 01) boolean add(E e)
        list1.add("S");
        list1.add("A");
        list1.add("K");
        list1.add("U");
        list1.add("J");
        list1.add("A");

        System.out.println(list1); // [S, A, K, U, J, A]

        ArrayDeque<String> list2 = new ArrayDeque<>();

        list2.add("S");
        list2.add("H");
        list2.add("A");
        list2.add("M");
        list2.add("A");
        list2.add("L");

        // 02) boolean addAll(Collection<? extends E> c)
        list1.addAll(list2);
        System.out.println(list1); // [S, A, K, U, J, A, S, H, M, A, L]

        // 03) void	clear()
        list2.clear();
        System.out.println(list2); // []

        // 04) boolean	contains(Object o)
        System.out.println(list1.contains("A")); //true
        System.out.println(list1.contains("S")); //true
        System.out.println(list1.contains("s")); //false
        System.out.println(list1.contains(4));   //false

        //05) boolean	containsAll(Collection<?> c)
        System.out.println(list1.contains(list2)); //false
        //Note - Here currently list2 is empty --> 03)

        //Adding some elements again
        list2.add("S");
        list2.add("H");
        list2.add("A");
        list2.add("M");
        list2.add("L");

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1.containsAll(list2)); //true

        list2.add("P");
        System.out.println(list1.containsAll(list2)); //false

        // 06) boolean	equals(Object o)
        System.out.println(list1.equals(list2)); //false

        list2.clear();
        list2.add("S");
        list2.add("A");
        list2.add("K");
        list2.add("U");
        list2.add("J");
        list2.add("A");
        list2.add("S");
        list2.add("H");
        list2.add("A");
        list2.add("M");
        list2.add("A");
        list2.add("L");
        System.out.println(list1.equals(list2)); //true

        // 07) int	    hashCode()
        System.out.println(list1.hashCode()); // 168423058 ??

        // 08) boolean	isEmpty()
        System.out.println(list1.isEmpty()); // false
        //list1.clear();
        // System.out.println(list1.isEmpty()); //true

        // 09) boolean	remove(Object o)
        list1.remove("A");
        System.out.println(list1); //[S, K, U, J, A, S, H, A, M, A, L]
        list1.remove("A");
        System.out.println(list1); //[S, K, U, J, S, H, A, M, A, L]

        // 10) boolean	removeAll(Collection<?> c)
        list1.removeAll(list2);
        System.out.println(list1);

        // 11) boolean	retainAll(Collection<?> c)
        list1.clear();
        list2.clear();

        list1.add("S");
        list1.add("A");
        list1.add("K");
        list1.add("U");
        list1.add("J");
        list1.add("A");

        list2.add("S");
        list2.add("H");
        list2.add("A");
        list2.add("M");
        list2.add("A");
        list2.add("L");

        System.out.println(list1.retainAll(list2)); //true
        //Note - This method like intersection of two sets.
        System.out.println(list1); //[S, A, A]

        // 12) int	    size()
        System.out.println(list1.size()); // 3

        // 13) Object[]	toArray()
        System.out.println(list1.toArray()[1]); // A

        // 14) <T> T[]	toArray(T[] a)
        String[] array1 = list1.toArray(new String[10]);

        for (String e : array1) {   // S, A, A, null, null, null, null, null, null, null,
            System.out.print(e + ", ");
        }

        System.out.println();

        array1 = list1.toArray(new String[2]);  // S, A, A
        for (String e : array1) {
            System.out.print(e + ", ");
        }

    }
}
