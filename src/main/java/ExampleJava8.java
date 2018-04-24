import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by shiful on 23/04/2018.
 * https://www.journaldev.com/2389/java-8-features-with-examples?utm_source=website&utm_medium=sidebar&utm_campaign=Core-Java-Sidebar-Widget
 * Java Functional Interfaces
 * Before I conclude the post, I would like to provide a brief introduction to Functional interfaces. An interface with exactly one abstract
 * method is known as Functional Interface.
 *
 */

public class ExampleJava8 {


    public void test(){


        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);

        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            System.out.println("Iterator Value::"+i);
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::"+t);
            }
        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

        // LAMDA
        myList.forEach(i->System.out.println(i));

        MyClass myClass = new MyClass();


    }
}


//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::"+t);
    }


}

// DIAMOND PROBLEM in MyClass because it implements Interface1, Interface2 where both has a common log(String str) function.
// So if MyClass Object if want ot call log function then which function will get call first there will be compiler exception


class MyClass implements Interface1, Interface2 {

    @Override
    public void method2() {
    }

    @Override
    public void method1(String str) {
    }

    //MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str){
        System.out.println("MyClass logging::"+str);
        Interface1.print("abc");
    }

}

@FunctionalInterface
interface Interface1 {

    void method1(String str);

    default void log(String str){
        System.out.println("I1 logging::"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }

    //trying to override Object method gives compile time error as
    //"A default method cannot override a method from java.lang.Object"

//	default String toString(){
//		return "i1";
//	}

}

// https://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method

/**
 * Java Functional Interfaces
 Before I conclude the post, I would like to provide a brief introduction to Functional interfaces.
 An interface with exactly one abstract method is known as Functional Interface.

 A new annotation @FunctionalInterface has been introduced to mark an interface as Functional Interface.
 @FunctionalInterface annotation is a facility to avoid accidental addition of abstract methods in the
 functional interfaces. It’s optional but good practice to use it.

 Functional interfaces are long awaited and much sought out feature of Java 8 because it enables us to use
 lambda expressions to instantiate them. A new package java.util.function with bunch of functional interfaces
 are added to provide target types for lambda expressions
 and method references. We will look into functional interfaces and lambda expressions in the future posts.

 https://www.journaldev.com/2763/java-8-functional-interfaces
 */

@FunctionalInterface
interface Interface2 {

    void method2();

    default void log(String str){
        System.out.println("I2 logging::"+str);
    }

}
