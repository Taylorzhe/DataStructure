package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i=0; i<arr.length; i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 在索引为index的位置添加元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (size == data.length){
            resize(2 * data.length);
        }
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        for (int i=size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在数组的首部添加元素e
     * @param e
     */
    public void addFirst(E e){
        if (size == data.length){
            resize(2 * data.length);
        }
        for (int i=size-1; i>=0; i--){
            data[i+1] = data[i];
        }
        data[0] = e;
        size++;
    }

    /**
     * 在索引的尾部添加元素e
     * @param e
     */
    public void addLast(E e){
        if (size == data.length){
            resize(2 * data.length);
        }
        data[size] = e;
        size += 1;
    }

    /**
     * 判断数组中是否含有元素e
     * @param e
     * @return
     */
    public boolean contains(Object e){
        for (int i=0; i<size; i++){
            if (e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找数组中元素e的位置，并返回其对应的索引
     * @param e
     * @return
     */
    public int find(E e){
        for (int i=0; i<size; i++){
            if (e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 寻找数组中所有包含元素e所对应的索引，并且返回一个list
     * @param e
     * @return
     */
    public List<Integer> findAll(E e){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++) {
            if (e.equals(data[i])) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 获取当前数组的容量capacity
     * @return
     */
    public int geCapacity(){
        return data.length;
    }

    /**
     * 获取索引index处的元素e并返回
     * @param index
     * @return
     */
    public E get(int index) {
        if (index<0 || index>size){
            throw new IllegalStateException("index不合法");
        }
        return data[index];
    }

    /**
     * 获取数组第一个元素，并返回
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取数组最后一个元素，并返回
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 获取数组中元素的个数，并返回
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 移除数组中索引index处所对应的元素e，并将该元素返回
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        E ret = data[index];
        for (int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length/2){
            resize( data.length / 2);
        }
        return ret;
    }

    /**
     * 移除数组中所有的元素e，并且返回元素e所在的索引
     * @param e
     * @return
     */
    public List<Integer> removeAllElement(E e){
        List<Integer> list = findAll(e);
        for (int i=0; i<list.size(); i++){
           remove(list.indexOf(i));
        }
        return list;
    }

    /**
     * 移除数组中的元素e，
     * @param e
     */
    public void removeElement(E e){
        int i = find(e);
        remove(i);
    }

    /**
     * 移除数组中第一个元素，并且返回
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 移除数组中最后一个元素，并且返回
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 将原数组的容量进行扩大或者缩小
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 修改数组索引index处的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index<0 || index>size){
            throw new IllegalStateException("index不合法");
        }
        data[index] = e;
    }

    /**
     * 数组中两个索引对应位置的元素交换位置
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        if (i >= 0 && i < data.length && j >= 0 && j< data.length){
            E k = data[i];
            data[i] = data[j];
            data[j] = k;
        }else
            throw new IllegalArgumentException("索引不合法");
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array.Array size = %d, capacity = %d", size, data.length));
        res.append("[");
        for (int i=0; i<size; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(",");}
        }
        res.append("]");
        return res.toString();
    }
}
