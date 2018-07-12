package edu.luc.cs271.arrayqueue;

import java.util.*;

public class FixedArrayQueue<E> implements SimpleQueue<E>  {

  private int capacity;

  private int size;

  private int front;

  private int rear;

  private E[] data;

  // TODO why do we need an explicit constructor?
    //answers on GitHub

  @SuppressWarnings("unchecked")
 /* public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;*/

    //Me
   public FixedArrayQueue(int initCapacity)
    {
      this.capacity = initCapacity;
      this.data =(E[]) new Object[capacity];
      front = 0;
      rear = capacity - 1;
      size = 0;

    } //Me end



  @Override
 /* public boolean offer(final E obj) {
    //** TODO
    return false;
  }*/
 public boolean offer(E item){ //ME
   if(size == capacity){
     reallocate();
   }
   size++;
   rear = (rear +1) % capacity;
   this.data[rear] = item;
   return true;
  }

  private void reallocate() {//ME
   int newCapacity = 2 * capacity;
   E[] newData = (E[]) new Object[newCapacity];
   int j = front;
   for(int i = 0; i< size; i++){
     newData[i] = this.data[j];
     j = (j + 1) % capacity;
   }
   front = 0;
   rear = size - 1;
   capacity = newCapacity;//made capacity NOT final
   this.data = newData;//made NOT final
  }

  @Override
  public E peek() {
    // **TODO
    if(size == 0)
    return null;
    else
      return this.data[front];
  }

  @Override
  public E poll() {//ME
    // **TODO
    if(size ==0){
      return null;
    }
    E result = this.data[front];
    front = (front +1) % capacity;
    size--;
    return result;
  }

  @Override
  public boolean isEmpty() {
    // TODO

    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // **TODO implement using an ArrayList preallocated with the right size
      Queue<String> name = new LinkedList<String>();



    return Arrays.asList();

  }
   /* public void AsListNonempty2() {
        final String value1 = "hello";
        final String value2 = "world";
        final String value3 = "what";
        ArrayList.offer(value1);
        ArrayList.offer(value2);
        asList().poll();
        asList().offer(value3);
        final List<String> list = fixture.asList();
        assertEquals(2, fixture.size());
        assertEquals(2, list.size());
        assertEquals(Arrays.asList(value2, value3), list);
    }*/

}
