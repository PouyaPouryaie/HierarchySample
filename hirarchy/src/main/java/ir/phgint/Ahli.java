package ir.phgint;

/**
 * Created by pouya on 08/01/2017.
 */
public class Ahli extends Animal {
    public Ahli(String name) {
        super(name);
    }

    public Ahli(boolean isPregnant, String name) {
        super(isPregnant, name);
    }

    @Override
    public void eat() {
        System.out.println("ahli is eat");
    }

    public Ahli(Ahli ah1){
        super(ah1);
    }

    public void hunter(){
        System.out.println(getName() + "is hunt");
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ahli{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void copyFrom(Object a) {

    }
    @Override
    public Object copy(){
        return null;
    }
}
