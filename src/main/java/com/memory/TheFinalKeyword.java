package com.memory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by shiful on 15/05/2018.
 */
public class TheFinalKeyword {

    public static void main(String[] args) {
        //final Customer c = new Customer("initValue");

        // c = new Customer("initValue"); // should gives and error
        // but we can change the state of the object by change its property. so final is not fully safe
        // which allow us to change the Object stats once it initialized. Other language has very powerful concept
        // like const will not allow you to change the state of the Object.
        //c.setName("shouldNotChangeButWeCanChange");
        //System.out.println(c);

        Supplier<String> i = () -> "Car";

        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());

        System.out.println();


    }


    private static class Customer {

        private String name;

        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}


