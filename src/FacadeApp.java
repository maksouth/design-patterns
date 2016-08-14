/**
 * Created by 1 on 5/24/2016.
 */
public class FacadeApp {
    public static void main(String[] args) {
       Computer computer = new Computer();
        computer.copy();

    }
}

class Computer{
    DVDRom dvd = new DVDRom();
    Power power = new Power();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
        dvd.unload();
    }
}

class Power{
    void on(){
        System.out.println("Power on");
    }

    void off(){
        System.out.println("Power off");
    }
}

class DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        System.out.println("Drive is loaded");
        data = true;
    }
    void unload(){
        System.out.println("Drive is unloaded");
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Copying from drive");
        }else {
            System.out.println("Insert drive in dvd rom");
        }
    }
}