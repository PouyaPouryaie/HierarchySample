package ir.phgint;

/**
 * Created by pouya on 08/01/2017.
 */
public class Adult extends Man{

    protected Adult(String name, boolean think, int age) {
        super(name, true, age, AgeRange.gonde);
    }

    protected Adult(boolean isPregnant, String name, boolean think, int age) {
        super(name, think, age, AgeRange.gonde);
    }

    public Adult(Adult ad1){
        super(ad1);
    }

    public void goToWord(){
        System.out.println(getName() + "go to work");
    }

    @Override
    public void eat() {
        System.out.println("adult is eat");
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adult{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Adult clone() throws CloneNotSupportedException{
        return (Adult) super.clone();
    }

    @Override
    public Object copy(){
        return null;
    }
}
