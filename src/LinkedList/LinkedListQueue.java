package LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
    //设置内部类为节点类
    private class Node{
        public E val;
        public Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(E val){
            this(val,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return val.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (tail == null)
            throw new IllegalArgumentException("队列为空,无法出队");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.val;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        return head.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("队列为：");
        Node cur = head;
        while (cur != null) {
            sb.append(cur).append("→");
            cur = cur.next;
        }
//        与while等价
//        for (cur = dummyHead.next; cur.next != null; cur = cur.next){
//            sb.append(cur + "→");
//        }
        sb.append("null tail");
        return sb.toString();
    }



}
