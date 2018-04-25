import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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


    List<Article> articles = new ArrayList<>();

    ExampleJava8Stream(){
        List<String> tags;
        tags = new ArrayList<>();
        tags.add("testtag1");
        tags.add("testtag2");
        tags.add("testtag3");
        tags.add("testtag5");
        tags.add("testtag5");

        articles.add(new Article("title1", "author1", tags));
        articles.add(new Article("title2", "author1", tags));
        articles.add(new Article("title3", "author1", tags));
        articles.add(new Article("title4", "author4", tags));
        articles.add(new Article("title5", "author5", tags));
        articles.add(new Article("title6", "author5", tags));
    }

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
        sumStream(list);
        System.out.println("Group map : " + groupByAuthor());
        System.out.println("Group map using Stream : " + groupByAuthorUsingStream());
        System.out.println("Collections get distinct set of a object properties from collection of object : " + getDistinctTags());
        System.out.println("Test Optional");
        testOptional();
        testMap();

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

        iL = list.stream().filter(i -> i > 10).mapToInt(i -> i); // if we remove this live it will throw exceptions
        System.out.println("Stream SUM: " + iL.sum());

        return 0;

    }

    public Map<String, List<Article>> groupByAuthor() {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> articles = new ArrayList<>();
                articles.add(article);
                result.put(article.getAuthor(), articles);
            }
        }

        return result;
    }

    public Map<String, List<Article>> groupByAuthorUsingStream() {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }


    public Optional<Article> getFirstJavaArticle() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    public List<Article> getAllJavaArticles() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    public Set<String> getDistinctTags() {

        Set<String> result = new HashSet<>();

        for (Article article : articles) {
            result.addAll(article.getTags());
        }

        return result;
    }

    public Set<String> getDistinctTagsUsingStream() {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }

    public void testOptional(){
        List<String> listOfStrings = Arrays.asList("Mark", "Howard", "Anthony D'Cornian");
        Optional<String> largeString
                = listOfStrings.stream().filter(str -> str.length() > 10).findAny();
        largeString.ifPresent(System.out::println);

        Optional<String> veryLargeString
                = listOfStrings.stream().filter(str -> str.length() > 20).findAny();
        veryLargeString.ifPresent(System.out::println);
    }

    /**
     * Stream map() example: We can use map() to apply functions to an stream.
     * Let’s see how we can use it to apply upper case function to a list of Strings.
     */
    public void testMap(){
        Stream<String> names = Stream.of("aBc", "d", "ef");
        System.out.println(names.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList()));
        //prints [ABC, D, EF]

        Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
        List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted); // [ef, d, aBc, 123456]

        Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
        System.out.println(naturalSorted); //[123456, aBc, d, ef]

        /***
         * Stream flatMap() example: We can use flatMap() to create a stream
         * from the stream of list. Let’s see a simple example to clear this doubt.

         */

        Stream<List<String>> namesOriginalList = Stream.of(
        Arrays.asList("Pankaj"),
        Arrays.asList("David", "Lisa"),
        Arrays.asList("Amit"));
        //flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);

        Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
//Stream contains 4? true

        Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
//Stream contains all elements less than 10? true

        Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
//Stream doesn't contain 10? true
    }

}



class Article {

    private final String title;
    private final String author;
    private final List<String> tags;

    Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }
}

