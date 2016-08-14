import java.util.Arrays;

/**
 * Created by 1 on 5/25/2016.
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1,3,2,1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11,4,2,7,8,34};
        c.setStrategy(new InsertionSort());
        c.executeStrategy(arr1);

        int[] arr2 = {3,-8,2,0,33,1,3,2};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);

    }
}

class StrategyClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy){
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

interface Sorting{
    void sort(int[] arr);
}

class BubbleSort implements Sorting {
    public void sort(int[] arr){
        System.out.println("Bubble sorting");
        System.out.println("before\t" + Arrays.toString(arr));
        for(int barrier = arr.length-1;barrier>=0;barrier--){
            for(int i = 0;i<barrier;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("After\t" + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {
    public void sort(int[] arr){
        System.out.println("Selection sorting");
        System.out.println("before\t" + Arrays.toString(arr));
        for(int barrier = arr.length-1;barrier>=0;barrier--){
            for(int i = 0;i<barrier;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("After\t" + Arrays.toString(arr));
    }
}

class InsertionSort implements Sorting {
    public void sort(int[] arr){
        System.out.println("Insertion sorting");
        System.out.println("before\t" + Arrays.toString(arr));
        for(int barrier = arr.length-1;barrier>=0;barrier--){
            for(int i = 0;i<barrier;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("After\t" + Arrays.toString(arr));
    }
}

