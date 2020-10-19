/*package whatever //do not write package name here */

public class <T> stack implements Iterable <T> {
    private java.util.LinkedList <T> list = new java.util.LinkedList <T>();
    
    //constructor 
    public stack(){
    }
    //creating a stack with initial element
    public stack(T firstElem){
        push(firstElem);
    }
    //return number of elements in stack
    public int size(){
        return list.size();
    }
    //checking if the stack is empty
    public boolean isEmpty(){
        return size()==0;
    }
    //push an element on the stack
    public void push(T elem){
        list.addLast(elem);
    }
    //pop an element of the stack 
    public void pop(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        return list.removelast;
        }
    }
    // peek the top of the element without removing an element for the stack
    //throws an exception if it is empty
    public T peek(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        return list.peeklast;
        }
    }
    // Allow users to iterate through the stack using an iterator
  @Override
  public java.util.Iterator<T> iterator() {
    return list.iterator();
  }
        
    }
}