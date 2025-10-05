package StackImplementation;

import java.util.ArrayList;

public class StackUsingArrayList {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.isEmpty();
        }
        public void push(int data){
            list.add(data);
        }
        public int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static void main(String [] args){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        //s.push(5);
        //s.pushAtBottom(5);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
