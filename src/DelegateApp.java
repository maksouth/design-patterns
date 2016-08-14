/**
 * Created by 1 on 5/23/2016.
 */
public class DelegateApp {
    public static void main(String[] args) {
        /*
        B a = new B();
        a.f();
        */

        Painter painter = new Painter();
        painter.setShape(new Square());
        painter.draw();

        painter.setShape(new Triangle());
        painter.draw();
    }
}

/*class A{
    void f(){
        System.out.println("A.f()");
    }
}

class B{
    A a = new A();
    void f(){
        a.f();
    }
}
*/

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("draw the triangle!");
    }
}

class Square implements Graphics{

    @Override
    public void draw() {
        System.out.println("draw the square!");
    }
}

class Circle implements Graphics{

    @Override
    public void draw() {
        System.out.println("draw the circle!");
    }
}

class Painter{
    Graphics shape;

    public void setShape(Graphics shape) {
        this.shape = shape;
    }

    void draw(){
        shape.draw();
    }
}