/*package whatever //do not write package name here */

public class queue <T> implements Iterable <T> {
    
    private java.util.LinkedList <T> list = new java.util.LinkedList <T> ();
    
    public queue(){
    }
    //creating an queue with first elem 
    public queue(T firstelem){
        offer(firstelem);
    }
    public int size(){
        return list.size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    //peeking an element at the front of the list
    //if empty will throw an error
    public T peek(){
        if(isEmpty){
            throw new RuntimeException("queue is Empty");
        return list.peekFirst(); 
        }
    }
    //poll an element at the front of the queue
    //if empty will return an error
    public T poll(){
        if(isEmpty){
            throw new RuntimeException("queue is empty");
        return list.removeFirst();
        }
    }
    //adding elements to the queue
    public void offer(T elem){
        list.addLast(elem);
    }
    // Return an iterator to alow the user to traverse
  // through the elements found inside the queue
  @Override
  public java.util.Iterator<T> iterator() {
    return list.iterator();
  }
    
    }