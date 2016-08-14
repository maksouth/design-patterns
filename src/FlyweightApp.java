import java.util.*;

/**
 * Created by 1 on 6/15/2016.
 */
public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<ShapeFly> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));

        Random rand = new Random();
        for(ShapeFly shape: shapes){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        }

    }
}

interface ShapeFly{
    void draw(int x, int y);
}

class PointFly implements ShapeFly{

    @Override
    public void draw(int x, int y) {
        System.out.println("Draw the point: ( " + x + " , " + y + ")");
    }
}

class CircleFly implements ShapeFly{
    int radius = 5;
    public void draw(int x, int y){
        System.out.println("Draw the circle with center: (" + x + "," + y + ") r = " + radius);
    }
}

class SquareFly implements ShapeFly{
    int side = 10;
    public void draw(int x, int y){
        System.out.println("Draw the square with center: (" + x + "," + y + ") a = " + side);
    }
}

class ShapeFactory{
    private static final Map<String, ShapeFly> shapes = new HashMap<>();

    public ShapeFly getShape(String shapeName){
        ShapeFly shape = shapes.get(shapeName);

        if (shape == null){
            switch (shapeName){
                case "circle":
                    shape = new CircleFly();
                    break;
                case "square":
                    shape = new SquareFly();
                    break;

                case "point":
                    shape = new PointFly();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}

