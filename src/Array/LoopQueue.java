package Array;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        this.data = (E[]) new Object[capacity+1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public int getSize() {
        return front + tail;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = tail % data.length + 1;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空，无法出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity() * 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空，无法获取");
        }
        return data[front];
    }

    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];
       for (int i=0; i<size; i++){
           newData[i] = data[(i + front) % data.length];
       }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array.Queue: Array.Array size = %d, capacity = %d", size, getCapacity()));
        res.append("front [");
        for (int i=front; i != tail; i = (i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length != tail){
                res.append(",");}
        }
        res.append("] tail");
        return res.toString();
    }
}
