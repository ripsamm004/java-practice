import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shiful on 23/04/2018.
 * https://www.journaldev.com/2389/java-8-features-with-examples?utm_source=website&utm_medium=sidebar&utm_campaign=Core-Java-Sidebar-Widget
 * Java Functional Interfaces
 * Before I conclude the post, I would like to provide a brief introduction to Functional interfaces. An interface with exactly one abstract
 * method is known as Functional Interface.
 * Good link for java 8
 *
 * http://www.deadcoderising.com/why-you-should-embrace-lambdas-in-java-8/
 * http://www.deadcoderising.com/java8-writing-asynchronous-code-with-completablefuture/
 * http://www.deadcoderising.com/2015-09-07-java-8-functional-composition-using-compose-and-andthen/
 * http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/
 * http://www.deadcoderising.com/timeout-support-using-executorservice-and-futures/
 * http://www.deadcoderising.com/java-8-no-more-loops/   [Stream]
 * http://www.deadcoderising.com/2015-10-06-java-8-removing-null-checks-with-optional/
 * http://www.deadcoderising.com/2016-01-17-java-8-new-features-in-concurrenthashmap/
 * http://www.deadcoderising.com/functional-interfaces-in-java-8/
 * http://www.deadcoderising.com/transactions-using-execute-around-method-in-java-8/
 *
 */

public class ExampleJava8Stream {


    public void test(){

        // Collection interface has been extended with stream() and parallelStream() default methods
        // to get the Stream for sequential and parallel execution. Let’s see their usage with simple example.
        testStream();


        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(32);
        list.add(23);

        System.out.println(sumIterator(list));
        System.out.println(sumStream(list));
    }



    private void testStream(){

        //https://www.journaldev.com/2774/java-8-stream

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);

        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

    }



    private int sumIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    // http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/
    private int sumStream(List<Integer> list) {
        //return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();

        IntStream iL = list.stream().filter(i -> i > 10).mapToInt(i -> i);
        iL.forEach(System.out::println);
        System.out.println("Stream Filter:" + iL.toString());

        return 0;

    }

}


