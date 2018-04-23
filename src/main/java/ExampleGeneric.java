/**
 * Created by shiful on 23/04/2018.
 *
 * https://www.journaldev.com/1663/java-generics-example-method-class-interface?utm_source=website&utm_medium=sidebar&utm_campaign=RecommendedTutorials-Sidebar-Widget
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 *
 * https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
 *  public void drawAll(List<? extends Shape> shapes) {
    ...
    }

 https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
 */
public class ExampleGeneric {

    //Java Generic Method
    public <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
        return g1.get().equals(g2.get());
    }

    /*

    Java Generics Bounded Type Parameters
Suppose we want to restrict the type of objects that can be used in the parameterized type,
for example in a method that compares two objects and we want to make sure that the accepted
objects are Comparables. To declare a bounded type parameter, list the type parameter’s name,
followed by the extends keyword, followed by its upper bound, similar like below method.
*/

public <T extends Comparable<T>> int compare(T t1, T t2){
		return t1.compareTo(t2);
	}

    /*
The invocation of these methods is similar to unbounded method except that if we will
try to use any class that is not Comparable, it will throw compile time error.
*/

    public void test(){
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Pankaj");

        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Pankaj");

        boolean isEqual =isEqual(g1, g2);
        System.out.println("Result " + isEqual);
        //This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
        //Compiler will infer the type that is needed

        System.out.println("Result compare " + compare(new Integer(3), new Integer(5)));
    }

    public void testGeneric(){
        GenericsType<String> type = new GenericsType<>();
        type.set("Pankaj"); //valid

        GenericsType type1 = new GenericsType(); //raw type
        type1.set("Pankaj"); //valid
        type1.set(10); //valid and autoboxing support
    }

}


 class GenericsType<T> {

    private T t;

    public T get(){
        return this.t;
    }

    public void set(T t1){
        this.t=t1;
    }
}

