package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer>mainStack=new Stack<>();
    Stack<Integer>minStack=new Stack<>();

    public void push(int x){
        mainStack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }
    public void pop(){
        if(!minStack.isEmpty() && minStack.peek()>mainStack.pop()){
            minStack.pop();
        }
    }
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1=new MinStack();
        minStack1.push(4);
        minStack1.push(3);
        minStack1.push(6);
        minStack1.push(5);
        minStack1.pop();
        System.out.println(minStack1.getMin());
    }

}
