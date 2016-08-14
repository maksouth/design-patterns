/**
 * Created by 1 on 6/2/2016.
 */
public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        ComputerUser user = new ComputerUser(new StartCommand(comp), new StopCommand(comp),
                                new ResetCommand(comp));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface Command{
    void execute();
}

class Comp{
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}

class StartCommand implements Command{
    Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }

    public void execute(){
        computer.start();
    }
}

class StopCommand implements Command{
    Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    public void execute(){
        computer.stop();
    }
}

class ResetCommand implements Command{
    Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    public void execute(){
        computer.reset();
    }
}

class ComputerUser{
    Command start;
    Command stop;
    Command reset;

    public ComputerUser(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer(){
        start.execute();
    }

    void stopComputer(){
        stop.execute();
    }

    void resetComputer(){
        reset.execute();
    }

}