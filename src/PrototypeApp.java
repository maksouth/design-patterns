/**
 * Created by 1 on 5/24/2016.
 */
public class PrototypeApp {
    public static void main(String[] args) {
        Humann original = new Humann(18, "Vasya");
        System.out.println(original);
        Humann copy = (Humann) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Humann h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Humann(20, "Valeria"));
        Humann girl = factory.makeCopy();
        System.out.println(girl);

    }
}

interface Copyable{
    Object copy();
}

class Humann implements Copyable{
    int age;
    String name;

    public Humann(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public Object copy() {
        Humann copy = new Humann(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Humann{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory{
    Humann human;

    public HumanFactory(Humann human){
        this.human = human;
    }

    void setPrototype(Humann human){
        this.human = human;
    }

    Humann makeCopy(){
        return (Humann)human.copy();
    }
}