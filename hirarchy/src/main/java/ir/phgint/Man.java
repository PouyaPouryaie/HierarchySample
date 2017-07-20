package ir.phgint;

/**
 *
 * Created by pouya on 08/01/2017.
 */
abstract class Man extends Human{
    protected int deck = 0;
    AgeRange agerange;
    int age;

    public Man(String name, boolean think, int age,AgeRange agerange) {
        super(name, think, false, false);
        this.age = age;
        this.agerange = agerange;
    }

    public Man(){
        super("man", true, false, false);
    }

    public Man(Man man1){
        super(man1);
        deck = man1.getDeck();
        agerange = man1.agerange;
        age = man1.getAge();
    }

    public final boolean do_sex(){
        if (agerange  == AgeRange.gonde) {
            System.out.println("he is do sex");
            return true;
        }
        return false;

//        if (age > agerange.getMin() && age < agerange.getMax()){
//            System.out.println("He is do sex");

    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Man)) return false;
        if (!super.equals(o)) return false;

        Man man = (Man) o;

        if (deck != man.deck) return false;
        if (age != man.age) return false;
        return agerange == man.agerange;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + deck;
        result = 31 * result + (agerange != null ? agerange.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append("deck=").append(deck);
        sb.append(", agerange=").append(agerange);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public Man clone() throws CloneNotSupportedException{
        return (Man)super.clone();
    }

    @Override
    public void copyFrom(Object m){
        this.age = ((Man)m).getAge();
        this.agerange = ((Man)m).agerange;
        this.setDeck(((Man)m).getDeck());
        super.copyFrom(m);
    }

    @Override
    public Object copy(Object m){
        ((Man)m).age = this.getAge();
        ((Man)m).agerange = this.agerange;
        ((Man)m).setDeck(this.getDeck());
        m = super.copy(m);
        return m;
    }

    @Override
    public int compareTo(Object m) {
        int result;
        if((result=super.compareTo(m)) == 0){
            return this.getAge() - ((Man)m).getAge();
        }
        else
            return result;
    }
}
