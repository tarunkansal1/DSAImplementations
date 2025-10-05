package StackImplementation;

public class StackUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        static Node head;
        public boolean isEmpty(){
            return head==null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }

            return head.data;
        }

        public void pushAtBottom(int data ){
            if(isEmpty()){
               push(data);
               return;
            }
            int top = pop();
            pushAtBottom(data);
            push(top);
            return;
        }
        public void reverse(){
            while(!isEmpty()){
                int top = pop();
                reverse();
                pushAtBottom(top);
                return;
            }

        }
    }

    public static void main(String[] args){
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

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.reverse();
        System.out.println("After Reversing");
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
