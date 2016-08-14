/**
 * Created by 1 on 5/25/2016.
 */
public class IteratorApp {
    public static void main(String[] args) {
        Tasks c = new Tasks();

        Iterator it = c.getIterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class Tasks implements Container{
    String[] tasks = {"Build a house", "Settle down a tree", "Create a child"};

    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator{

        int index = 0;
        @Override
        public boolean hasNext() {
            return (index<tasks.length);
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}

