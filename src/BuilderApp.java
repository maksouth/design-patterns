/**
 * Created by 1 on 5/25/2016.
 */
public class BuilderApp {
    public static void main(String[] args) {
        /*Car car = new CarBuilder()
                .buildMake("Ford")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(195)
                .build();
        System.out.println(car);
        */

        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make){
        this.make = make;
    }
    public void setTransmission(Transmission transmission){
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder{
    Car car;
    void createCar(){
        car = new Car();
    }

    Car getCar(){
        return car;
    }

    abstract void buildMaxSpeed();
    abstract void buildTransmission();
    abstract void buildMake();
}

class FordMondeoBuilder extends CarBuilder{

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(250);
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");
    }
}

class SubaruImprezzaBuilder extends CarBuilder{

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMake() {
        car.setMake("Subaru Imprezza");
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){
        builder = b;
    }

    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}

/*
class CarBuilder{
    String m = "Defaulr";
    Transmission t = Transmission.AUTO;
    int s = 120;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}
*/