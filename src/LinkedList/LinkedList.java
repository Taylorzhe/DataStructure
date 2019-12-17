package LinkedList;

public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表索引为index处插入元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("索引越界异常");
        Node prev = dummyHead;
        for (int i=0; i<index; i++){
            prev = prev.next;
        }
//       Node node = new Node(e);
//       node.next = prev.next;
//       prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 向链表的头部添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表的最后插入结点
     * @param e
     */
    public void addLast(E e){
        add(getSize(), e);
    }

    /**
     * 获取链表中索引为index结点的值
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("索引越界异常");
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++){
                cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 获取链表中头结点对应的值
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表中最后一个结点对应的值
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表中索引为index结点对应的值
     * @param index
     * @param e
     */
    public void modify(int index, E e){
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.val = e;
    }

    public boolean isExist(E e){
        Node node = dummyHead;
        for (int i=0; i<size; i++){
            node = node.next;
            if (e.equals(node.val))
                return true;
        }
        return false;
    }

    /**
     * 判断链表中是否有结点包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (e.equals(cur.val))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表中索引为index处的节点，并返回对应的值
     * @param index
     * @return
     */
    public E remove(int index){
        Node prev = dummyHead;
        for (int i=0; i<index; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.val;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1 );
    }

    public void removeElements(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if (prev.next.val == e){
                Node delNode = prev.next;
                prev.next = null;
                prev.next = delNode.next;
                size--;
                break;
            }
            prev = prev.next;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("链表为：");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur).append("→");
            cur = cur.next;
        }
//        与while等价
//        for (cur = dummyHead.next; cur.next != null; cur = cur.next){
//            sb.append(cur + "→");
//        }
        sb.append("null");
        return sb.toString();
    }
}
