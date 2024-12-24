package Iterable;

import java.util.ArrayList;
import java.util.Iterator;

/* Iterable<T> is an interface where it is at the top of the hierarchy.

     01) Iterator<T>     iterator()
        Note - In this method, it returns an object that has been created as an
        inner class with implementing from the Iterator<T> interface.

     Iterator<T> interface -->
         01) boolean	        hasNext()
         02) E	            next()
         03)default void	    forEachRemaining(Consumer<? super E> action)
         04)default void	    remove()

     02) default void 	forEach(Consumer<? super T> action)

     03)default Spliterator<T>	spliterator()

 **/

public class TestIterableForArrayList {
    public static void main(String[] args) {

        ArrayList<String> list1=new ArrayList<>();

        // Note that the add(E element) is defined in collection interface.
        list1.add("S");
        list1.add("A");
        list1.add("K");
        list1.add("U");
        list1.add("J");
        list1.add("A");


        //01) iterator()
        Iterator<String> iterator=list1.iterator();
        System.out.println(iterator);// Prints memory address


        while(iterator.hasNext()){
            String currentElement=iterator.next();
            System.out.print(currentElement);
        }

        //02) default void 	forEach(Consumer<? super T> action)

        //03) 03)default Spliterator<T>	spliterator()
    }
}
