package ir.phgint;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<Child> list = new ArrayList<>();
        HashMap<String, Mammal> mymap = new HashMap<String, Mammal>();
        list.add(new Child("pouya", false, true,20,20));
        list.add(new Child("sina", false, true, 25, 25));
        list.add(new Child("riaz", false, true, 10, 10));
        A a = new A();
        B b = new B();
        System.out.println("b is assign able from a: " + A.class.isAssignableFrom(B.class));
        System.out.println("b is instance a: " + A.class.isInstance(b));

        System.out.println("a is assign able from b : " + B.class.isAssignableFrom(A.class));
        System.out.println("a is instance b : " + B.class.isInstance(a));

        System.out.println("b instance of a: " + (b instanceof A));
        System.out.println("a instance of b: " + (a instanceof B));

        Collections.sort(list);
        ListIterator<Child> iter = list.listIterator();
        while (iter.hasNext())
        {
            System.out.println(((Child)iter.next()).getName());
        }
        ListIterator<Child> iter1 = list.listIterator();
        int count = 0;
        while (iter1.hasNext()){
            String name;
            name = ((Child)iter1.next()).getName();
            if(!mymap.containsKey(name)){
                mymap.put(name, (Mammal)list.get(count));
            }
        }

    }
    static class A{};
    static class B extends A{};
}
