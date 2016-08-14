import java.util.Collection;

/**
 * Created by 1 on 5/24/2016.
 */
public class VisitorApp {
    public static void main(String[] args) {
        /*Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor mechanic = new MechanicVisitor();

        body.accept(mechanic);
        engine.accept(mechanic);*/

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

class EngineElement implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelElement implements Element{
    private String name;

    public String getName() {
        return name;
    }
    public WheelElement(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element{
    Element[] elements;

    public CarElement(){
        this.elements = new Element[]{new WheelElement("back wheel"),
                        new WheelElement("right wheel"),
                        new WheelElement("front wheel"),
                        new WheelElement("left wheel"),
                        new BodyElement(),
                        new EngineElement()};
    }

    public void accept(Visitor visitor){
        for (Element elem: elements){
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{
    public void visit(EngineElement engine) {
        System.out.println("Start engine");
    }
    public void visit(BodyElement body) {
        System.out.println("Kick the body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Smoked in the car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pierce " + wheel.getName());
    }
}

class MechanicVisitor implements Visitor{
    public void visit(EngineElement engine) {
        System.out.println("Checked the engine");
    }
    public void visit(BodyElement body) {
        System.out.println("Cleaned the body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Painted the car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pumped up " + wheel.getName());
    }
}
