/**
 * Created by 1 on 5/23/2016.
 */
public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface p = new QuotesDecorator(new RightBracketDecorator(new LeftBracketDecorator(new Printer("Hello"))));
        p.print();
    }
}

interface PrinterInterface{
    void print();
}


class Printer implements PrinterInterface{

    String value;
    public Printer(String value){
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface{
    PrinterInterface component;
    public Decorator(PrinterInterface component){
        this.component = component;
    }
    public void print(){
        component.print();
    }
}

class QuotesDecorator extends Decorator{
    public QuotesDecorator(PrinterInterface component){
        super(component);
    }

    public void print(){
        System.out.print("\"");
        super.print();
        System.out.println("\"");
    }
}

class LeftBracketDecorator extends Decorator{
    public LeftBracketDecorator(PrinterInterface component){
        super(component);
    }

    public void print(){
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends Decorator{
    public RightBracketDecorator(PrinterInterface component){
        super(component);
    }

    public void print(){
        super.print();
        System.out.print("]");
    }
}
