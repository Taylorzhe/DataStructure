package Array;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<E>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.geCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Array.Queue:");
        sb.append("front [");
        for (int i=0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if (i != array.getSize()-1)    sb.append(",");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
