package ir.phgint;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class AppTest{
    Mammal mam1;
    Object ma2;
    Adult ad1;
    Child ch1;
    Human ch2;
    Child ch;
    Child ch4;
    Child sser;
    Child s;
    String[] sname;
    ObjectOutputStream output;
    ObjectInputStream input;
    HashMap<String, Mammal> mymap;
    public int divider(int sorat, int makhraj) throws ArithmeticException{
        return sorat/makhraj;
    }

    List<Child> list = new ArrayList<Child>();
    ListIterator<Child> pname;
    PriorityQueue<Child> pList = new PriorityQueue<Child>(3, new Comparator<Child>() {
        @Override
        public int compare(Child o1, Child o2) {
            return o1.compareTo(o2);
        }
    });

    @Before
    public void init() throws Exception {
        mam1 = new Child("hasan", true,true,10, 10);
        ma2 = new Child("pouya", true, true, 9, 15);
        ad1 = new Adult("sina", false, 33);
        ch1 = new Child("ali", true, true,8, 25);
        list.add(new Child("pouya", false, true,20,20));
        list.add(new Child("sina", false, true, 25, 25));
        list.add(new Child("riaz", false, true, 10, 10));
        pList.add(new Child("pouya", false, true,20,20));
        pList.add(new Child("sina", false, true, 25, 25));
        pList.add(new Child("riaz", false, true, 10, 10));
        ch2 = ch1.clone();
        ch = new Child();
        ch.copyFrom(mam1);
        ch.setName("jafar");
        ch2.setName("pouya");
        ch4 = (Child) mam1.copy();
        output = new ObjectOutputStream(new FileOutputStream("object.bin"));
        output.writeObject(mam1);
        input = new ObjectInputStream(new FileInputStream("object.bin"));
        sser = (Child) input.readObject();
        System.out.println(sser.getName());
        sname = new String[]{"riaz", "pouya", "sina"};
        mymap = new HashMap<String, Mammal>();
    }

    @Test
    public void isAssign(){
        assertTrue("Is not assignable",Mammal.class.isAssignableFrom(Child.class));
    }

    @Test
    public void testMap(){
        ListIterator<Child> iter1 = list.listIterator();
        int count = 0;
        while (iter1.hasNext()){
            String name;
            name = ((Child)iter1.next()).getName();
            if(!mymap.containsKey(name)){
                mymap.put(name, list.get(count));
            }
        }
        assertTrue("not equals", mymap.containsKey("pouya")==true && mymap.containsValue(list.get(0))==true);
    }

    @Test
    public void testPriority() throws ArrayIndexOutOfBoundsException{
        int count = 0;
        boolean b = true;
        try {
            while (!pList.isEmpty()){
                s = pList.poll();
                b = s.getName() == sname[count];
                count++;
            }
        }catch (ArrayIndexOutOfBoundsException ne){
            System.out.println("null pointer");
            assertFalse("this test is not run",true);
        }

        assertTrue("is not sort", b==true);
    }
    @Test
    public void testserialize(){
        assertTrue("not serial", sser.equals(mam1));
    }

    @Test
    public void testCompare(){
        assertTrue("is not equal", mam1.compareTo(ma2)== 0);
    }

    @Test
    public void testcom(){
        assertTrue("not is equal", mam1.compareTo((Mammal) ma2) == 0);
    }

    @Test
    public void testCopy() throws Exception{
        assertTrue("this is not equal",!(ch.equals(mam1)));
    }

    @Test
    public void testCopyof() throws Exception{
        assertTrue("this is not equal",!(ch4.equals(mam1)));
    }

    @Test
    public void testClonemodify(){
        assertTrue("this is not equal", ch2.equals(ch1));
    }

    @Test
    public void testClone(){
        assertTrue("is not same",(ch2 != ch1));
    }

    @Test
    public void testExceptionTrue(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number 1: ");
            int numberone = 10;
            System.out.println("Enter Number 2: ");
            int numbertwo = 2;
            int result = divider(numberone,numbertwo);
            System.out.println(numberone + "/" + numbertwo + "is " + result);
        }
        catch (ArithmeticException artimeticException){
            assertTrue("true mean exception run",true);
            return;
        }
        assertTrue("Artimetic exception not true", false);
    }

    @Test
    public void test(){
        String str = "this is correct";
        assertEquals("this is correct", str);
    }

    @Test
    public void copyConstructorTest(){
        Mammal mam2 = new Child((Child) mam1);
        assertEquals(mam2, mam1);
    }

    @Test
    public void EqualByRefTest(){
        assertEquals(ma2, mam1);
        assertFalse(ma2 == mam1);
    }

    @Test
    public void doSexTest(){

        assertTrue("if true means agerange is gonde",((Man)mam1).do_sex());
    }

    @Test
    public void hashCheckerTest(){
        assertTrue("if false mean not equal",mam1.hashCode() == ma2.hashCode());
    }

    @Test
    public void toStringTest(){
        assertTrue("if false means not toserialaize", mam1.toString().contains("Child"));
    }

    @Test
    public void countTest(){
        assertTrue("if true means staticVariable is currect", 3 == Mammal.countNumber());
    }

    @Test
    public void staticInitializerTest(){
        assertTrue("if True means we change static variable with static initializer", 13 == Mammal.countNumber());
    }
}