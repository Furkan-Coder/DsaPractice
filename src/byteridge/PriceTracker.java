package byteridge;

import java.util.Stack;

public class PriceTracker {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public PriceTracker() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    public  void push(int price){
        mainStack.push(price);
        if(minStack.isEmpty()){
            minStack.push(price);
        }else{
            int currentMin=minStack.peek();
            minStack.push(Math.min(price,currentMin));
        }
    }
    public void pop(){
        mainStack.pop();
        minStack.pop();
    }
    public  int getMin(){
        return minStack.peek();
    }
    public static void main(String[] args) {
        PriceTracker tracker = new PriceTracker();

        tracker.push(5);
        tracker.push(3);
        tracker.push(7);

        System.out.println(tracker.getMin()); // 3

        tracker.pop();
        System.out.println(tracker.getMin()); // 3

        tracker.pop();
        System.out.println(tracker.getMin()); // 5
    }
}
