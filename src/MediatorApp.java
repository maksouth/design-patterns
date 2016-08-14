import oracle.jrockit.jfr.StringConstantPool;
import org.omg.PortableInterceptor.AdapterNameHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 5/24/2016.
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Ivan Ivanych");
        User u1 = new SimpleUser(chat, "Vanya");
        User u2 = new SimpleUser(chat, "Vova");
        User u3 = new SimpleUser(chat, "Sasha");
        u2.setEnabled(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        u1.sendMessage("Hello, I user");
        admin.sendMessage("Admin closed the chat");
    }
}

abstract  class User{
    private Chat chat;
    private String name;
    private boolean isEnabled = true;

    public boolean isEnabled(){
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }

    public User(Chat chat, String name){
        this.chat = chat;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    public String toString(){
        return "User [name=" + name + "]";
    }
}

class Admin extends User{
    public Admin(Chat chat, String name){
        super(chat, name);
    }

    @Override
    void getMessage(String message) {
        System.out.println("Admin " + getName() + " get a message '" + message + "'");
    }

}

class SimpleUser extends User{

    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void getMessage(String message) {
        System.out.println("User " + getName() + " get a message '" + message + "'");
    }
}

interface Chat{
    void sendMessage(String message, User user);
}

class TextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin){
        if(admin!=null && admin instanceof Admin) {
            this.admin = admin;
        }else throw new RuntimeException("Lack of rights");
    }

    public void addUser(User user){
        if(admin==null){
            throw new RuntimeException("Chat doesn't have an admin");
        }

        if(user instanceof SimpleUser) {
            users.add(user);
        }else{
            throw new RuntimeException("Admin can't enter other chat");
        }
    }

    public void sendMessage(String message, User user){
        if(user instanceof Admin){
            for(User u: users){
                u.getMessage(user.getName() + ": " +message);
            }
        }

        if(user instanceof SimpleUser) {
            for(User u: users){
                if(u!=user && u.isEnabled()){
                    u.getMessage(user.getName() + ": " + message);
                }
            }

            if(admin.isEnabled()){
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}