package LinkedList;

public class LL {
    private int size;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next=null;
        }
    }

    Node head;

    LL(){
        head = null;
        size=0;
    }

    public void addFirst(int data){

        Node newNode = new Node(data);
        size++;
        if(head == null){
            head  = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head  = newNode;
            return;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return;
    }

    public void printList(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("null");
        return;

    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        size--;
        head = head.next;
        return;
    }

    public void removeLast(){
        if (head == null){
            System.out.println("Empty list");
            return;
        }
        size--;
        if (head.next == null){
            head = null;
            return;
        }
        Node currNode = head;
       while(currNode.next.next!=null){
            currNode = currNode.next;
       }
       currNode.next = null;
       return;
    }

    public int size(){
        return size;
    }

    public void reverseList(){
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        if (head.next == null){
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while(cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        head = prev;
        return;
    }
    public Node recReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = recReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        /*Node head = new Node(100);
        head.next = new Node(200);
        head.next.next = new Node(300);
        */
        LL list = new LL();
        list.addFirst(100);
        list.addLast(200);
        list.addFirst(0);
        list.printList();

        //System.out.println("Size = " + list.size());
        list.addFirst(600);
        list.printList();
        //System.out.println("Size = " + list.size());
        list.removeFirst();
        list.printList();
        list.addLast(-100);
        //System.out.println("Size = " + list.size());
        list.printList();
        list.removeLast();
        //System.out.println("Size = " + list.size());
        list.printList();
        System.out.println("Size = " + list.size());

        list.reverseList();
        list.printList();

        list.head = list.recReverse(list.head);
        list.printList();
    }
}
