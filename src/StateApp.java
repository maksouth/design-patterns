import java.sql.Statement;

/**
 * Created by 1 on 5/24/2016.
 */
public class StateApp {
    public static void main(String[] args) {

       /* Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for(int i = 0;i<10;i++){
            radio.play();
            radio.nextStation();
        }
        */
        Human human = new Human();
        human.setState(new Work());
        for(int i = 0;i<10;i++){
            human.doSomething();
        }
    }
}

//Context
class Human{
    private Activity state;
    public void setState(Activity a){
        state = a;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}
//State
interface Activity{
    void doSomething(Human context);
}
class Work implements Activity{
    public void doSomething(Human context) {
        System.out.println("Working..");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity{
    private int count = 0;
    public void doSomething(Human context){
        if(count<3){
            System.out.println("Relaxing (Zzz)");
            count++;
        }else{
            context.setState(new Work());
        }
    }
}


interface Station{
    void play();
}

class Radio7 implements Station{
    public void play(){
        System.out.println("Radio 7");
    }
}

class RadioDFM implements Station{
    public void play(){
        System.out.println("Radio DFM");
    }
}

class VestiFM implements Station{
    public void play(){
        System.out.println("Vesti FM");
    }
}

//Context
class Radio{
    Station station;
    void setStation(Station station){
        this.station = station;
    }

    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        }else if(station instanceof RadioDFM){
            setStation(new VestiFM());
        }else if(station instanceof VestiFM){
            setStation(new Radio7());
        }
    }

    void play(){
        station.play();
    }
}