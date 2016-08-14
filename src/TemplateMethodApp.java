/**
 * Created by 1 on 5/25/2016.
 */
public class TemplateMethodApp {
    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();

        C b = new B();
        b.templateMethod();
    }
}

abstract class C{
    void templateMethod(){
        System.out.println("1");
        differ();
        System.out.println("3");
        differ2();
    }

    abstract void differ();
    abstract void differ2();
}

class A extends C{
    void differ(){
        System.out.println("2");
    }

    @Override
    void differ2() {
        System.out.println(5);
    }
}

class B extends C{
    public void differ(){
        System.out.println("4");
    }

    @Override
    void differ2() {

    }
}

