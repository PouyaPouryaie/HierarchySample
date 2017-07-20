package ir.phgint;

/**
 * Created by pouya on 08/01/2017.
 */
abstract class Animal extends Mammal{
    public Animal(String name) {
        super(false, name);
        legs =4;
        eye = 2;
    }

    public Animal(boolean isPregnant, String name) {
        super(isPregnant, name);
        legs = 4;
        eye =2;
    }

    public Animal(Animal an1){
        super(an1);
        legs = an1.getLegs();
        eye = an1.getEye();
    }
    public void hunter(){}

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}