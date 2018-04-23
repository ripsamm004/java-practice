import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by shiful on 19/04/2018.
 * LinkedList in Java with Example
 *
 * LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
 * LinkedList allows for constant-time insertions or removals using iterators,
 * but only sequential access of elements. In other words, LinkedList can
 * be searched forward and backward but the time it takes to traverse the
 * list is directly proportional to the size of the list.
 *
 *
 * https://www.youtube.com/watch?v=njTh_OwMljA
 * https://www.youtube.com/watch?v=ch1uQeu0PVY
 *
 * https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/
 *
 */


public class ExampleLinkedList {

    public void test1LinkedList(){

        LinkedList<String> linkedlist = new LinkedList<String>();

        linkedlist.add("Item01");
        linkedlist.add("Item02");
        linkedlist.add("Item03");
        linkedlist.add("Item04");
        linkedlist.add("Item04");
        linkedlist.add("Item04");
        linkedlist.add("Item04");


        /*Display Linked List Content*/
        System.out.println("Linked List Content: " +linkedlist);

        System.out.println("linkedlist.indexOf Return index of the item: " +linkedlist.indexOf("Item04"));

        System.out.println("linkedlist.lastIndexOf Return last occurance index of the item: " +linkedlist.lastIndexOf("Item04"));

        System.out.println("Object poll(): It returns and removes the first item of the list.: " +linkedlist.poll());


        /*
            There are four ways in which a LinkedList can be iterated –
            For loop
            Advanced For loop
            Iterator
            While Loop
         */

        /*For loop*/

        System.out.println("**For loop**");

        for(int num=0; num<linkedlist.size(); num++)
        {
            System.out.println(linkedlist.get(num));
        }

        /*Advanced for loop*/
        System.out.println("**Advanced For loop**");
        for(String str: linkedlist)
        {
            System.out.println(str);
        }

        /*Using Iterator*/
        System.out.println("**Iterator**");

        Iterator i = linkedlist.iterator();

        while (i.hasNext()){

            System.out.println(i.next());

        }



    }


}
