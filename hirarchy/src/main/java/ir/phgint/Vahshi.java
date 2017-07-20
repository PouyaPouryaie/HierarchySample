package ir.phgint;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by pouya on 08/01/2017.
 */

public class Vahshi extends Animal {
    public Vahshi(String name) {
        super(name);
    }

    public Vahshi(boolean isPregnant, String name) {
        super(isPregnant, name);
    }

    @Override
    public void eat() {
        System.out.println("vahshi mikhure");
    }

    public Vahshi(Vahshi va1){
        super(va1);
    }

    @Override
    public void hunter(){
        System.out.println(getName() + "is hunter");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vahshi{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void copyFrom(Object v) {

    }
    @Override
    public Object copy(){
        return null;
    }
}
