package Set;

import LinkedList.LinkedList;

import java.util.TreeSet;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e))
            list.addLast(e);
    }

    @Override
    public void remove(E e) {
        list.removeElements(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListSet{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
       LinkedListSet<Integer> list = new LinkedListSet<Integer>();
       list.add(1);
       list.add(2);
       list.add(6);
       list.add(2);
       list.add(7);
       list.add(9);
        System.out.println(list.toString());
        System.out.println(list.getSize());
       list.remove(2);
        System.out.println(list.toString());
    }
}


