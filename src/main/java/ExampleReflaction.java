import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rufiyaa on 23/04/18.
 * https://www.journaldev.com/1789/java-reflection-example-tutorial#reflection-in-java
 *
 */
public class ExampleReflaction {

    public void test(){




        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass


        System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"



        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double


        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]

        Class<?>[] classes = concreteClass.getClasses();
        //[class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface,
        //class com.journaldev.reflection.BaseClass$BaseClassInnerClass,
        //class com.journaldev.reflection.BaseClass$BaseClassMemberEnum]
        System.out.println(Arrays.toString(classes));

        try {

            Method[] publicMethods = Class.forName("ConcreteClass").getMethods();
            //prints public methods of ConcreteClass, BaseClass, Object
            System.out.println("METHOD " +  Arrays.toString(publicMethods));


            Method method2 = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            Map<String, String> hm = new HashMap<>();
            method2.invoke(hm, "key", "value");
            System.out.println(hm); // prints {key=value}


            //invoking private method
            Method method1 = Class.forName("BaseClass").getDeclaredMethod("method3", null);
            method1.setAccessible(true);
            method1.invoke(null, null); //prints "Method3"

            Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            //get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
            System.out.println(Arrays.toString(method.getParameterTypes()));
            //get method return type, return "class java.lang.Object", class reference for void
            System.out.println(method.getReturnType());
            //get method modifiers
            System.out.println(Modifier.toString(method.getModifiers())); //prints "public"

            //Get All public fields
            Field[] publicFields = Class.forName("ConcreteClass").getFields();
            //prints public fields of ConcreteClass, it's superclass and super interfaces
            System.out.println("FIELDS " +  Arrays.toString(publicFields));


            //Get Type parameters (generics)
            TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
            for(TypeVariable<?> t : typeParameters)
                System.out.print(t.getName()+",");

            //prints "public abstract interface"
            System.out.println(Modifier.toString(Class.forName("BaseInterface").getModifiers()));

            //prints "com.journaldev.reflection"
            System.out.println("----------" + Class.forName("ConcreteClass$ConcreteClassPublicEnum").getPackage().getName());

            Class<?> innerClass = Class.forName("ConcreteClass$ConcreteClassDefaultClass");
            //prints com.journaldev.reflection.ConcreteClass
            System.out.println(innerClass.getDeclaringClass().getCanonicalName());

            //prints "com.journaldev.reflection"
            System.out.println("TTT : " + Class.forName("ConcreteClass").getPackage().getName());


            System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"
            //prints "public abstract interface"
            System.out.println(Modifier.toString(Class.forName("BaseInterface").getModifiers()));

            //getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
            Class<?>[] explicitClasses = Class.forName("ConcreteClass").getDeclaredClasses();
            //prints [class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass,
            //class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultEnum,
            //class com.journaldev.reflection.ConcreteClass$ConcreteClassPrivateClass,
            //class com.journaldev.reflection.ConcreteClass$ConcreteClassProtectedClass,
            //class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
            //class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
            //interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface]
            System.out.println(Arrays.toString(explicitClasses));





        }

        catch (Exception ex){

        }



    }
}


@Deprecated
class ConcreteClass extends BaseClass implements BaseInterface {

    public int publicInt;
    private String privateString="private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int i){
        this.publicInt=i;
    }

    @Override
    public void method1() {
        System.out.println("Method1 impl.");
    }

    @Override
    public int method2(String str) {
        System.out.println("Method2 impl.");
        return 0;
    }

    @Override
    public int method4(){
        System.out.println("Method4 overriden.");
        return 0;
    }

    public int method5(int i){
        System.out.println("Method4 overriden.");
        return 0;
    }

    // inner classes
    public class ConcreteClassPublicClass{}
    private class ConcreteClassPrivateClass{}
    protected class ConcreteClassProtectedClass{}
    class ConcreteClassDefaultClass{}

    //member enum
    enum ConcreteClassDefaultEnum{}
    public enum ConcreteClassPublicEnum{}

    //member interface
    public interface ConcreteClassPublicInterface{}

}

class BaseClass {

    public int baseInt;

    private static void method3(){
        System.out.println("Method3");
    }

    public int method4(){
        System.out.println("Method4");
        return 0;
    }

    public static int method5(){
        System.out.println("Method5");
        return 0;
    }

    void method6(){
        System.out.println("Method6");
    }

    // inner public class
    public class BaseClassInnerClass{}

    //member public enum
    public enum BaseClassMemberEnum{}
}

interface BaseInterface {

    public int interfaceInt=0;

    void method1();

    int method2(String str);
}