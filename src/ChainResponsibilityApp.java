/**
 * Created by 1 on 5/26/2016.
 */
public class ChainResponsibilityApp {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);
        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessage("Everything OK", Level.INFO);
        smsLogger.writeMessage("Debugging", Level.DEBUG);
        smsLogger.writeMessage("System is down", Level.ERROR);
    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}


abstract class Logger{
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeMessage(String message, int level){
        if(level<=priority){
            differ(message);
        }
        if(next!=null){
            next.writeMessage(message, level);
        }
    }

    abstract void differ(String message);
}

class SMSLogger extends Logger{

    public SMSLogger(int priority){
        super(priority);
    }

    @Override
    void differ(String message) {
        System.out.println("SMS " + message);
    }


}

class FileLogger extends Logger{
    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    void differ(String message) {
        System.out.println("File " + message);
    }
}

class EmailLogger extends Logger{

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    void differ(String message) {
        System.out.println("Email " + message);
    }
}
