package datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray<T> implements MyListInterface<T>, Iterable<T>{
    private static final int INITIAL_CAPACITY = 10;
    private int size=0;
    private int maxSize=2;
    private Object[] elementData = {};

    public MyArray(){
        elementData = new Object[INITIAL_CAPACITY];
    }

//    public clearList(){ ///DONT FORGET
//        size = 0;
//        maxSize = 2;
//        Object array[]; <---??? Shouldn't the array brackets be like Object[] ?
//        Object temp[];
//    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T t) {
        if(size==elementData.length){
            growArray();
        }
        elementData[size++] = t;
    }

    @Override
    public void add(T t, int index) {
        if(size==elementData.length){ // check to see if the array size can handle another element... if not... grow...
            growArray();
        }
        if(index>=size || index<0){ // check if index provided will throw a null point error
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for(int i=size;i>=index;i--){ // starts at the size number and goes down
            elementData[i] = elementData[i-1];

        }
    }

    @Override
    public T get(int index) {
        if (index <0 || index >=size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        return (T) elementData[index]; //Typecast to the same Array type.
    }

    @Override
    public void remove(int index) {
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        for (int i=index; i<size-1; i++) {
            elementData[i] = elementData[i +1];
        }
        size--; //Reduce the size of the array by one after the removal
    }

//    @Override
//    public void clearList() {
//        size = 0;
//        maxSize = 2;
//        Object array[];
//        Object temp[];
//    }

    @Override
    public void clearList() {
        for (int i= 0; i<=size;i++){
            elementData[i] = null;
        }
        size=0;
        maxSize=2;
    }

    @Override
    public int contains(T t) {
        for(int i=0; i<size;i++){
            if(elementData[i] == t) {
                return i;
            }
        }
        return -1;
    }

    // growth method
    private void growArray() {
        int newCapacity = elementData.length * 2; //double length
        elementData = Arrays.copyOf(elementData,newCapacity); //assigning to a new array that's twice as large.
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (index < size) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                Object t = elementData[index];
                index++;
                return (T) t;
            }
        };
    }
}

