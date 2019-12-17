package DoubleLinkedList;

public class DoubleLinkedList<E> {
    public class Node {
        public E val;
        public Node pre;
        public Node next;
        public Node(E val, Node pre, Node next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
        public Node(E val){
            this(val, null, null);
        }

        @Override
        public String toString(){
            return val.toString();
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = new Node(null,null,null);
        this.tail = new Node(null,null,null);
        size = 0;
    }

    public void addFirst(E val){
        Node newNode = new Node(val);
        if (!isEmpty())
            this.head.pre = newNode;
        newNode.next = head;
        this.head = newNode;
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("链表为：");
        Node cur = head;
        while (cur != null) {
            sb.append(cur).append("→");
            cur = cur.next;
        }
        return sb.toString();
    }
}
