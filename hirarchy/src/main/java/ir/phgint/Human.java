package ir.phgint;

/**
 * Created by pouya on 08/01/2017.
 */
abstract class Human extends Mammal implements Cloneable{
    //-------------------static Field-------------------
    private static int count = 0;
    //-------------------instance Field-----------------
    private boolean think;
    private boolean soul;
    int s;
    int t;
    //-------------------static Initializer-------------
    static{
        count = 10;
    }

    public static int countNumber(){
        System.out.println(count + "create of Human");
        return count;
    }

    abstract public void eat();

    //-------------------constructor--------------------

    public Human(String name,boolean think,boolean soul,boolean isPregnant) {
        super(isPregnant, name);
        legs =2;
        eye = 2;
        this.think = think;
        this.soul = soul;
        count++;
    }

    public Human(Human hum1){
        super(hum1);
        think = hum1.isThink();
        soul = hum1.isSoul();
        count++;
    }

    //-------------------field Initializer--------------

    public boolean isThink() {
        return think;
    }
    public boolean isSoul(){return soul;}

    public void setThink(boolean think) {
        this.think = think;
    }
    public void setSoul(boolean soul) { this.soul = soul; }

    //-------------------method-------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        if (!super.equals(o)) return false;

        Human human = (Human) o;

        if (think != human.think) return false;
        return soul == human.soul;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (think ? 1 : 0);
        result = 31 * result + (soul ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "think=" + think +
                '}';
    }

    @Override
    public Human clone() throws CloneNotSupportedException{
        return (Human)super.clone();
    }

    @Override
    public void copyFrom(Object h){
        this.setThink(((Human)h).isThink());
        this.setSoul(((Human)h).isSoul());
        super.copyFrom(h);
    }

    @Override
    public Object copy(Object m){
        ((Human)m).setThink(this.isThink());
        ((Human)m).setSoul(this.isSoul());
        m = super.copy(m);
        return m;
    }

    @Override
    public int compareTo(Object m) {
        return super.compareTo(m);
    }
}
