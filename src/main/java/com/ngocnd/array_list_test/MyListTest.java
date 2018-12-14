package com.ngocnd.array_list_test;

import java.util.Arrays;
import java.util.Objects;

class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private Object[] clone;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void ensureCapacity(int mincapacity) {
        int newSize = mincapacity * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void checkCapacity(int index) {
        if (size == elements.length) ensureCapacity(elements.length);
        else if (index < 0 || index > elements.length)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
    }

    public void add(int index, E element) {
        checkCapacity(index);
        elements[index - 1] = element;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        else {
            Object temp = elements[index];
            elements[index] = null;
            for (int i = index - 1; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }

            return (E) (temp);
        }
    }

    public int size() {
        int count = 0;
        for (Object e : elements) {
            if (e != null) count++;
        }
        return count;
    }

    public Object[] clone() {
        clone = new Object[elements.length];
        clone = Arrays.copyOf(elements, elements.length);
        return clone;
    }

    public boolean contains(E o) {
        boolean check = false;
        for (Object e : elements) {
            if (Objects.equals(o, e)) {
                check = true;
            }
        }
        return check;
    }

    public int indexOf(E o) {
        int check = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                check = i + 1;
                break;
            } else check = -1;
        }
        return check;
    }

    public boolean add(E o) {
        ensureCapacity(elements.length);
        elements[size++] = o;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        } else return (E) elements[index - 1];
    }

    public void clear() {
        elements = new Object[elements.length];
    }

}

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        Object[] clone;
        listInteger.add(1);
        listInteger.add(4, 5);
        //listInteger.remove(4);
        //listInteger.clear();
        clone = listInteger.clone();
        /*for (int i = 1; i < listInteger.elements.length; i++) {
            System.out.println(listInteger.get(i));
        }*/
        //System.out.println(listInteger.get(1));
        // System.out.println(listInteger.get(4));

        /*
        if(listInteger.contains(2)){
            System.out.println("true");
        }
        else System.out.println("false");
        */
        //listInteger.ensureCapacity(100);
        //System.out.println(listInteger.get(4));
        //System.out.println(listInteger.size());
        //System.out.println(listInteger.elements.length);
        //System.out.println(listInteger.indexOf(5));
        int count = 0;
        for (Object e : clone) {
            if (e != null) count++;
            System.out.println(e);
        }
        System.out.println(count);
    }
}
