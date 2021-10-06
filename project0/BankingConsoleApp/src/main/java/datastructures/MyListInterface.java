package datastructures;

public interface MyListInterface<T> {

    int size(); // return the size of the Array

    void add(T t); // add a new item

    void add(T t, int index); //add an item at index location

    T get(int index); //get the item at index location

    void remove(int index); //remove the item at index location

    void clearList (); // clear the array

    int contains(T e); //check how many T-objects the array contains???






}
