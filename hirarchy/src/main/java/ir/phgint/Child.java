package ir.phgint;

import java.io.Serializable;

/**
 *
 * Created by pouya on 08/01/2017.
 */
public class Child extends Man {

    public Child(String name, boolean isPregnant, boolean think, int age , int deck) {
        super(name, think, age, AgeRange.child);
        this.deck = deck;
    }

    public Child(){
        super("bache", false, 10, AgeRange.child);
    }

    public Child(Child ch1){
        super(ch1);
    }
    public void game(String toys){
        System.out.println(getName() + "the child is play" + toys);
        AgeRange.valueOf("child");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Child{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void eat() {
        System.out.println("child is eat");
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public Child clone() throws CloneNotSupportedException{
        return (Child)super.clone();
    }

    @Override
    public void copyFrom(Object c){
        this.setDeck(((Child)c).getDeck());
        super.copyFrom(c);
    }

    @Override
    public Object copy(){
        Object m = new Child();
        ((Child)m).setDeck(this.getDeck());
        m = super.copy(m);
        return m;
    }

    @Override
    public int compareTo(Object m) {
        int result;
        if((result=super.compareTo(m)) == 0) {
            return this.getDeck() - ((Child)m).getDeck();
        }
        else return result;
    }
}


