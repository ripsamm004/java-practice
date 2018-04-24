import java.util.*;

/**
 * Created by shiful on 17/04/2018.
 */
public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        // int i = in.nextInt();
        System.out.println("TEST IS PRIME " + isPrime(503));
        int[] unsortedArray = {23,3,56,100,2,78,54,8,1,0};
        int[] dataArray = {23,3,56,100,2,78,54,8,1,0};

        //sortArray(unsortedArray);
        //sortSelectionSort(unsortedArray);
        //bubbleSortArray(unsortedArray);
        //linearSearch(dataArray, 100);


        /*
        ExampleBinarySearch exampleBinarySearch = new ExampleBinarySearch();
        exampleBinarySearch.binarySearch(67);

        //System.exit(0);

        ExampleArrayList exampleArrayList = new ExampleArrayList();
        exampleArrayList.testArrayList();

        ExampleLinkedList exampleLinkedList = new ExampleLinkedList();
        exampleLinkedList.test1LinkedList();

        ExampleHashMap exampleHashMap = new ExampleHashMap();
        exampleHashMap.testHashmap();

        ExampleHashTable exampleHashTable = new ExampleHashTable();
        exampleHashTable.testHashtable();


        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add("Test1");
        linkedList.add("Test3");
        linkedList.add("Test2");
        linkedList.add("Test2");
        linkedList.insertAtFirst("FIRST");
        linkedList.insertAt(0,"INSERT AT 0");
        linkedList.insertAt(1,"INSERT AT 1");
        linkedList.add("LAST");

        // DELETE
        linkedList.remove("INSERT AT 1");
        linkedList.remove("Test2");
        linkedList.remove("Test2");
        linkedList.remove("LAST");
        linkedList.remove("Test3");
        linkedList.remove("FIRST");
        linkedList.remove("Test1");
        linkedList.remove("INSERT AT 0");
        //linkedList.remove("INSERT AT 0");
        linkedList.remove("Test1");
        linkedList.remove("LAST");
        linkedList.show();


        System.out.println("TESTING GENERIC LINK LIST WITH STRING");
        LinkedListGenericImpl<String> linkedListGeneric = new LinkedListGenericImpl<String>();
        linkedListGeneric.add("Test1");
        linkedListGeneric.add("Test3");
        linkedListGeneric.add("Test2");
        linkedListGeneric.add("Test2");
        linkedListGeneric.insertAtFirst("FIRST");
        linkedListGeneric.insertAt(0,"INSERT AT 0");
        linkedListGeneric.insertAt(1,"INSERT AT 1");
        linkedListGeneric.show();


        System.out.println("TESTING GENERIC LINK LIST WITH INTEGER");
        LinkedListGenericImpl<Integer> linkedListGenericInt = new LinkedListGenericImpl<Integer>();
        linkedListGenericInt.add(309);
        linkedListGenericInt.add(3221);
        linkedListGenericInt.add(2234);
        linkedListGenericInt.insertAtFirst(43423);
        linkedListGenericInt.insertAt(0,2342323);
        linkedListGenericInt.insertAt(1,33);

        linkedListGenericInt.remove(33);
        linkedListGenericInt.remove(2342323);
        linkedListGenericInt.remove(2234);

        linkedListGenericInt.show();

        System.out.println("TESTING HASHMAP IMPLEMENTATION");

        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put("ripon", 400);

        System.out.println("GET FROM HASHMAP : ");
        hashMap.get("ripon");

        System.out.println("TESTING Concurrent HASHMAP");
        ExampleConcurrentHashMap exampleConcurrentHashMap = new ExampleConcurrentHashMap();
        exampleConcurrentHashMap.testConcurrectHashMap();

        System.out.println("TESTING Concurrent Count");
        ConcurrentAtomic concurrentAtomic = new ConcurrentAtomic();
        try {
            concurrentAtomic.test();
            concurrentAtomic.testAtomic();

        }
        catch (Exception ex){

        }

        System.out.println("TESTING ExampleGeneric : ");
        ExampleGeneric exampleGeneric = new ExampleGeneric();
        exampleGeneric.test();



        System.out.println("Reflections: ");
        ExampleReflaction exampleReflaction = new ExampleReflaction();
        exampleReflaction.test();



        System.out.println("Testing Multithreading with synchronize keyword");
        ExampleConcurrentMultithreading exampleConcurrentMultithreading = new ExampleConcurrentMultithreading();
        exampleConcurrentMultithreading.test();
        System.out.println("Testing Multithreading DeadLock");
        exampleConcurrentMultithreading.testDeadLock();
*/
        System.out.println("JAVA 8 Features testing....");
        ExampleJava8 exampleJava8 = new ExampleJava8();
        exampleJava8.test();

    }

    public static boolean isPrime(int n){

        if(n==1) return true;

        int divisor = n/2;

        int count = 1;

        while( n % divisor > 0 ){
            if(divisor>1) divisor--;
            count++;
        }

        if(count==n/2) return true;

        else return false;
    }

    public static void linearSearch(int[] a, int n){

        for(int i=0;i<a.length;i++){
            if(a[i] == n) System.out.println("Position is " + i);
        }
    }


    public static void sortArray(int[] unsortedArray){

        boolean flag = true;
        int temp;

        while (flag){

            flag = false;

            for(int i=0; i < unsortedArray.length-1; i++){

                if(unsortedArray[i]<unsortedArray[i+1]){
                    temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i+1];
                    unsortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        for (int i : unsortedArray){
            System.out.println("Position is " + i);
        }

    }

    //https://www.youtube.com/watch?v=cqh8nQwuKNE
    public static void sortSelectionSort(int[] unsortedArray){

        int temp = 0;
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[i] < unsortedArray[j]) {
                    temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[i];
                    unsortedArray[i] = temp;
                }
            }
        }

        for (int i : unsortedArray){
            System.out.println("Position is " + i);
        }

    }

    //https://www.youtube.com/watch?v=F13_wsHDIG4
    //https://www.youtube.com/watch?v=6Gv8vg0kcHc
    public static void bubbleSortArray(int[] unsortedArray){
        int temp, n;
        n = unsortedArray.length;

        for(int i=0; i<n; i++){

            for (int j=1; j< (n - i); j++){  // every iteration sort one number from the list

                if(unsortedArray[j-1] < unsortedArray[j]){
                    temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j-1];
                    unsortedArray[j-1] = temp;
                }

            }
        }

        for (int i : unsortedArray){
            System.out.println("Position is " + i);
        }

    }

    //HashTable
    //https://www.youtube.com/watch?v=shs0KM3wKv8&t=111s

    //HashMapImpl implementation In java
    //https://www.youtube.com/watch?v=c3RVW3KGIIE

    //HashMapImpl And HashTable
    //https://www.youtube.com/watch?v=z5tZ0Zb5rJQ

    // graph search
    //https://www.youtube.com/watch?v=zaBhtODEL0w&t=74s
}


