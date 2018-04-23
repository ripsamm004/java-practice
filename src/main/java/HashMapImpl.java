/**
 * Created by shiful on 22/04/2018.
 *
 * https://www.youtube.com/watch?v=KyUTuwz_b7Q
 * https://www.youtube.com/watch?v=nLWXJ6IDKmQ&t=1170s
 *
 * Hashtable underline algorithm is array (bucket) where every index of the array
 * is contain a collections of nodes which we called linkedList
 *
 * a node contains <key, value, hashOfkey, next_node_reference>
 * we have to calculate the index of the array from the hashcode of the key
 * So int index = hash & (n-1)
 *      where,
 *          hash = the has of the key
 *          n is the initial size of the bucket or array n = 16
 *          we will use CHAINING way of implementation of the hashtable so if the two key has
 *          same hash and same index then when we insert the item in the end of the linklist
 *          in the same index of the array.
 *
 *          [ You can have look for LINEAR PROBING is another way of doing instead of linklist when
 *          two key has same hash]
 *
 *          LoadFactor = number of entry / number of bucket
 *
 *          Difference between HashMapImpl and HashTable
 *
 *          HashMapImpl                         Hashtable
 *          java 1.2                        since beginning of java
 *          not thread safe                 thread safe and synchronized
 *          it is fast                      it is slow
 *          work with single thread         multiple thread can work on
 *          Allow null key                  Does not allow null key
 *
 *
 */

public class HashMapImpl {
        int SIZE_OF_TABLE = 128;
        Entry[] table;

        HashMapImpl(){

            //Define the size of the Entry array
            table = new Entry[SIZE_OF_TABLE];

            //init the array of entry with null
            for(int i=0; i < SIZE_OF_TABLE; i++){
                table[i] = null;
            }
        }

        public int hashKeyCode(String key) {
            int result = 0;
            result = 31 * result + (key != null ? key.hashCode() : 0);
            return result;
        }

        // from the hash of the key we need the index of the table where we insert the entry
        private int getIndex(int hash){
            return hash & (SIZE_OF_TABLE -1);
        }


        public void put(String key, int value ){

            Entry entry = new Entry(hashKeyCode(key), key, value);
            entry.setNextEntry(null);
            int index = getIndex(entry.getHash());
            //insert in the first entry of the linkedlist where the head of the linkedlist is table[index] == head
            if(table[index] == null) table[index] = entry;
            else{
                // travers through the linklist and insert at the end of the linklist
                Entry next = table[index];
                while (next.getNextEntry()!=null){

                    //if the key is same exist then replace
                    if(next.getKey().equals(entry.getKey())){
                        next.setValue(entry.getValue());
                        return;
                    }

                    next = next.getNextEntry();
                }

                // if no key exist then add the new entry at the end of the linkedlist
                next.setNextEntry(entry);
            }
        }


        public void get(String key){
            int index = getIndex(hashKeyCode(key));

            if(table[index] == null) {
                System.out.println("Not found");
                return;
            }
            else{
                // travers through the linklist and insert at the end of the linklist
                Entry entry = table[index];

                //if first index match
                if(entry.getKey().equals(key)){
                    System.out.println("Found : " + entry.getValue());
                    return;
                }

                while (entry.getNextEntry()!=null){

                    //if the key match
                    if(entry.getKey().equals(entry.getKey())){
                        break;
                    }

                    entry = entry.getNextEntry();
                }

                System.out.println("Found : " + entry.getValue());
            }

        }

    class Entry{

        int hash;
        String key;
        int value;
        Entry nextEntry;

        public Entry(int hash, String key, int value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }


        public void setHash(int hash) {
            this.hash = hash;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNextEntry(Entry nextEntry) {
            this.nextEntry = nextEntry;
        }

        public int getHash() {
            return hash;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Entry getNextEntry() {
            return nextEntry;
        }
    }

}
