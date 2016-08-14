import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 5/24/2016.
 */
public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(23, 760);
        station.setMeasurements(-5, 745);
    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed{

    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather changed. Temperature = " + temp + " Pressure = " + presser);
    }
}

class FileObserver implements Observer{
    public void handleEvent(int temp, int presser){
        File f;
        try{
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Weather has changed. Temperature = " + temp + ", Pressure = " + presser);
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}