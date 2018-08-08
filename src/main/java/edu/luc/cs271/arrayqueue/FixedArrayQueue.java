package edu.luc.cs271.arrayqueue;

import java.util.*;

public class FixedArrayQueue<E> implements SimpleQueue<E>  {


    private final int capacity;

    private int size;

    private int front;

    private int rear;

    private final E[] data;

    // TODO why do we need an explicit constructor?

    @SuppressWarnings("unchecked")
    public FixedArrayQueue(final int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = capacity - 1;
    }

    @Override
    public boolean offer(final E obj) {
        // TODO
        if (size < capacity) {
            size++;
            rear = (rear + 1) % capacity;
            data[rear] = obj;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E peek() {
        // TODO
        if (isEmpty()) {
            return null;
        } else {
            return data[front];
        }
    }

    @Override
    public E poll() {
        // TODO
        if (isEmpty()) {
            return null;
        } else {
            E result = data[front];
            front = (front + 1) % capacity;
            size--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> asList() {
        // TODO implement using an ArrayList preallocated with the right size
        List<E> dataList = new ArrayList<>();
        while (!isEmpty()) {
            dataList.add(data[front]);
            front = (front + 1) % capacity;
            size--;
        }
        return dataList;
    }
}