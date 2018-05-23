package com.memory;

/**
 * Created by shiful on 15/05/2018.
 *
 * In java variable pass in to method by value
 */
public class PassingByValue {

    public static void main(String[] args) {
        Customer c = new Customer("initName");
        renameCustomer(c);
        System.out.println(c);
    }

    public static void renameCustomer(Customer cust){
        cust.setName("ChangedName");
    }

    private static class Customer{

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


