import java.util.*;

/**
 * Created by shiful on 19/04/2018.
 */
public class ExampleHashTable {

    public static void testHashtable() {

        /* This is how to declare Hashtable */
        Hashtable<Integer, String> hmap = new Hashtable<Integer, String>();

        /*Adding elements to HashMapImpl*/
        hmap.put(12, "Chaitanya");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

        /* Display content using Iterator*/
        System.out.print("Hashtable iterate");
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }


        /* Display content using Enumeration
        *  Enumerator for the Hashtable is not fail-fast.
        * */

        Enumeration names;
        Integer key;

        System.out.print("Hashtable iterate using Enumeration");
        names = hmap.keys();
        while (names.hasMoreElements()) {
            key = (Integer) names.nextElement();

            System.out.print("key is: " +key + " & Value is: ");
            System.out.println(hmap.get(key));
        }


    }

}



