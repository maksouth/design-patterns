import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 5/25/2016.
 */
public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new SquareComp();
        Shape square2 = new SquareComp();
        Shape triangle = new TriangleComp();

        Shape square3 = new SquareComp();
        Shape circle1 = new CircleComp();
        Shape circle2 = new CircleComp();
        Shape circle3 = new CircleComp();

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite3.addComponent(composite1);
        composite3.addComponent(composite2);

        composite3.draw();
    }
}

interface Shape{
    void draw();
}

class TriangleComp implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw the triangle");
    }
}

class SquareComp implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw the square");
    }
}

class  CircleComp implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw the circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    void addComponent(Shape component){
        components.add(component);
    }

    void removeComponent(Shape component){
        components.remove(component);
    }

    public void draw(){
        for(Shape component: components){
            component.draw();
        }
    }

}