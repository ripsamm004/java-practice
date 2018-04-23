import java.util.*;

/**
 * Created by shiful on 19/04/2018.
 */
public class ExampleArrayList {

    public static void testArrayList(){

        /*
     * Integer class implements Comparable
     * Interface so we can use the sort method
     */
        int[] arr = {11,55,22,0,89};
        Arrays.sort(arr);
        System.out.print("Sorted Int Array: ");
        System.out.println(Arrays.toString(arr));

    /*
     * String class implements Comparable
     * Interface so we can use the sort method
     */
        System.out.print("Sorted String Array: ");
        String[] names = {"Steve", "Ajeet", "Kyle"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

     /*
      * String class implements Comparable
      * Interface so we can use the sort method
      */
        System.out.print("Sorted List: ");
        List<String> fruits = new ArrayList();
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Guava");
        fruits.add("Grapes");
        Collections.sort(fruits);
        for(String s: fruits) System.out.print(s+", ");

        /*
         *In the above example, you have seen that how easy it is to sort the Arrays and list
         *of objects that implements Comparable interface, you just need to call the
         *Collections.sort (and Arrays.sort). However if you want to sort the objects of
         *custom class then you need to implement the Comparable interface in our custom class.
         */

        List<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student(223, 30,  "Chaitanya", "test1"));
        arraylist.add(new Student(245, 23, "Rahul", "test2"));
        arraylist.add(new Student(209, 40, "Ajeet", "test3"));

        Collections.sort(arraylist); // We have to implement comparable in the student class

        /**
         * Since Comparable is implemented by the same class whose objects are sorted so
         * it binds you with that sorting logic which is ok in most of the cases but in
         * case you want to have more than way of sorting your class objects you should use comparators.
         *
         * https://beginnersbook.com/2017/08/comparable-interface-in-java-with-example/
         * https://beginnersbook.com/2017/08/comparator-interface-in-java/
         *
         */

        System.out.println("\n-------- Sorted By Id [Using Comparable] ----------");
        for(Student str: arraylist){
            System.out.println(str);
        }


        /*
        // How to make ArrayList synchronized?
        // As I stated above ArrayList methods are non-synchronized but
        // still if there is a need you can make them synchronized like this –

        //Use Collecions.synzhonizedList method
        List list = Collections.synchronizedList(new ArrayList());

        //If you wanna use iterator on the synchronized list, use it
        //like this. It should be in synchronized block.
        synchronized (list) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext())

            iterator.next();

        }

        */

        /* Comparator Interface in Java
         In the last tutorial, we have seen how to sort objects of a custom class using Comparable interface.
         By using Comparable we can sort the objects based on any data member. For example, lets say we have
         an Author class has data members: Author name, book name and author age, now if we want to sort
         the objects based on any of the data member then we can use Comparable but what if we want to
         have multiple sort choices and we can sort objects based on any choice, this can be done using
         Comparator interface, we can create as many Comparator as we want and then we can call Collections.sort
         on one or more Comparator
        */

        List<Student> arraylist2 = new ArrayList<Student>();
        arraylist2.add(new Student(223, 30,  "Chaitanya", "test1"));
        arraylist2.add(new Student(245, 23, "Rahul", "test2"));
        arraylist2.add(new Student(209, 40, "Ajeet", "test3"));

        Collections.sort(arraylist2, new StudentAgeComparator());

        System.out.println("-------- Sorted By Age [Using Comparator] ----------");
        for(Student str: arraylist2){
            System.out.println(str);
        }

    }
}



class StudentAgeComparator implements Comparator<Student> {
    public int compare(Student a1,Student a2){
        if(a1.getAge()==a2.getAge())
            return 0;
        else if(a1.getAge()>a2.getAge())
            return 1;
        else
            return -1;
    }
}


/*
Example: Sorting Custom object by implementing Comparable interface
*/

class Student implements Comparable{

    private int id;
    private int age;
    private String name;
    private String address;

    public Student(int id, int age, String name, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Object s) {
        Student o = (Student) s;
        if(this.id > o.id) return 1; // greater
        else if(this.id < o.id) return -1; // smaller
        else return 0; // equal
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

