import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiful on 19/04/2018.
 * https://www.youtube.com/watch?v=rjwKOIK7ls0
 * https://www.youtube.com/watch?v=T98PIp4omUA
 * https://www.youtube.com/watch?v=5uF7XZ-KoYU
 */
public class ExampleBinarySearch {

    /**
     * Only work if the array is sorted
     * new int [2,4,6,7,8,55,67]
     */
    public void binarySearch(int value) {
        int[] array = new int[] {2,4,6,7,8,55,67};

        int start = 0;
        int end = array.length -1;
        int mid = 0;

        while (start<=end){
            mid = (start+end)/2;
            if(array[mid]==value) {
                System.out.println("Found");
                break;
            }
            else{
                if(array[mid]>value){
                    end = mid-1;
                }
                else start = mid+1;
            }
        }

    }
}



