package Array;

public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack() {
        array = new Array<E>();
    }

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peel() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.geCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array.Stack:");
        sb.append("[");
        for (int i=0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if (i != array.getSize()-1)    sb.append(",");
        }
        sb.append("]  top");
        return sb.toString();
    }
}
