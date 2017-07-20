package ir.phgint;

import java.io.Serializable;

/**
 *
 * Created by pouya on 07/01/2017.
 */
abstract class Mammal implements Cloneable , Copyable, Comparable <Object> , Serializable{
    //-----------Static Fields---------
    private static int count = 0;
    //-----------Instance Fields-------
    protected int legs;
    protected int eye;
    private String name;
    private boolean isPregnant;

    //-----------Static Initializer----
    static {
        count = 10;
    }

    public static int countNumber() {
        System.out.println(count + "create of mammal");
        return count;
    }

    //-----------Constructor-----------
    public Mammal() {
        this.isPregnant = false;
        this.name = "None";
        count++;
        System.out.println("Create Mammal");
    }

    public Mammal(boolean isPregnant, String name) {
        this.isPregnant = isPregnant;
        this.name = name;
        System.out.println("Create Mammal");
        count++;
    }

    public Mammal(Mammal o) {
        this.name = o.getName();
        this.setPregnant(o.getIsPregnant());
        this.setLegs(o.getLegs());
        this.setEye(o.getEye());
        count++;
    }

    //----------Getter&Setter----------------
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPregnant() {
        return this.isPregnant;
    }

    public void setPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int leg) {
        this.legs = legs;
    }

    public int getEye() {
        return eye;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }

    //----------Method-----------------------

    public abstract void eat();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mammal)) return false;
        Mammal mammal = (Mammal) o;
        if (legs != mammal.legs) return false;
        if (eye != mammal.eye) return false;
        if (isPregnant != mammal.getIsPregnant()) return false;
        return name.equals(mammal.getName());
    }

    @Override
    public int hashCode() {
        int result = legs;
        result = 31 * result + eye;
        result = 31 * result + name.hashCode();
        result = 31 * result + (isPregnant ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mammal{" + " Name: " + this.getName() +
                "\n" + " Pregnant: " + this.getIsPregnant() + " }";
    }

    @Override
    public Mammal clone() throws CloneNotSupportedException {
        return (Mammal) super.clone();
    }

    @Override
    public void copyFrom(Object m) {
        this.name = (((Mammal) m).getName());
//        this.name = ((Mammal)m).getName();
        this.legs = ((Mammal) m).getLegs();
        this.eye = ((Mammal) m).getEye();
        this.isPregnant = ((Mammal) m).getIsPregnant();
    }


    public Object copy(Object m) {
        ((Mammal) m).name = this.getName();
        ((Mammal) m).legs = (this.getLegs());
        ((Mammal) m).eye = (this.getEye());
        ((Mammal) m).isPregnant = (this.getIsPregnant());
        return m;
    }

    @Override
    public int compareTo(Object m) {
        if(this.getLegs() - ((Mammal)m).getLegs()==0){
            if(this.getEye() - ((Mammal)m).getEye()==0){
                return name.compareTo(((Mammal)m).getName());
            }
            return this.getEye() - ((Mammal)m).getEye();
        }
        else return this.getLegs() - ((Mammal)m).getLegs();
    }
}
//        int x = 0;
//        if(legs == m.getLegs()){
//            if(eye == m.getEye()){
//                if(name.compareTo(m.getName())==0){
//                    return x;
//                }
//                else{
//                    x = name.compareTo(m.getName());
//                }
//            }
//            else {
//                x = name.compareTo(m.getName());
//                x = x + (eye - m.getEye());
//            }
//        }
//        else {
//            x = name.compareTo(m.getName());
//            x = x + (eye - m.getEye());
//            x = x + (legs - m.getLegs());
//        }
//        return x;
//    }

