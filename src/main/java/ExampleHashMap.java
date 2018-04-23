import java.util.*;

/**
 * Created by shiful on 19/04/2018.
 */
public class ExampleHashMap {

    public static void testHashmap() {

        /* This is how to declare HashMapImpl */
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

      /*Adding elements to HashMapImpl*/
        hmap.put(12, "Chaitanya");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

      /* Display content using Iterator
      *
      * difference between these classes is that the Iterator of the HashMapImpl is
      * a fail-fast and it throws ConcurrentModificationException if any other
      * Thread modifies the map structurally by adding or removing any element
      * except iterator’s own remove() method. In Simple words fail-fast means:
      * When calling iterator.next(), if any modification has been made between
      * the moment the iterator was created and the moment next() is called, a
      * ConcurrentModificationException is immediately thrown.
      *
      * */

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }



      /* Get values based on key*/
        String var= hmap.get(2);
        System.out.println("Value at index 2 is: "+var);

      /* Remove values based on key*/
        hmap.remove(3);
        System.out.println("Map key and values after removal:");
        Set set2 = hmap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
        }

    }
}



