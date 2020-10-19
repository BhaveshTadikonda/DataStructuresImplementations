/*package whatever //do not write package name here */

import java.io.*;

public class DoublyLinkedList <T> implements Iterable <T>{
    
    private int size=0;
    private node <T> head = null;
    private node <T> tail = null;
    
    // This method contains, data of nodes and also previous and next pointers
    
    // Internal repersentation of the Data
    private static class Node<T> {
        private T data;
        private Node<T> prev,next;
        
        // constructor for Node
        public Node(T data,Node <T>prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    // clearing the list of DoublyLinkedList, 0(n)
    public void clear(){
        Node<T> trav = head;
        while(trav!=null){ // there are still elements in the list
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    // adding element to the list, 0(1) [at the start or end of the list]
    public void add(T elem){
        addLast(elem);
    }
    //adding an element to start of the list
    public void addFirst(T elem){
        // linkedlist isEmpty
        if(isEmpty()){
            head = tail = new Node <T>(elem,null,null);
            else {
                head = tail = new Node <T>(elem,null,head);
                head = prev.next;
            }
        }
        size++;
    }
    public void addLast(T elem){
        // linkedlist is isEmpty
        if(isEmpty()){
        head = tail = new Node <T>(elem,null,null);
        else {
            head = tail = new Node <T>(elem,tail,null);
            tail = tail.next;
        }
    }
    size++;
    }
    
    // Checking the value of the first node, using peeking
    public T PeekFirst(){
        if(isEmpty) throw new RuntimeException("new list");
        return head.data;
    }
    //checking the value of last node, using peeking
    public T PeekLast(){
        if(isEmpty) throw new RuntimeException("empty list");
        return tail.data;
    }
    public T removeFirst(){
        // if empty can't remove 
        if(isEmpty) throw new RuntimeException("empty list");
        
        //extract data at the head and move,the head pointers forwards one node
        T data = head.data;
        head = head.next;
        --size;
        
        //if list isEmpty set the tail to null and empty
        if(isEmpty()) tail = null;
        //do a memory clean for prev node
        else head.prev = null;
        
        return data;
    }
    public T removeLast(){
        // if empty can't remove 
        if(isEmpty) throw new RuntimeException("empty list");
        
        //extract data at the head and move,the head pointers forwards one node
        T data = tail.data;
        tail = tail.next;
        --size;
        
        //if list isEmpty set the tail to null and empty
        if(isEmpty()) head = null;
        //do a memory clean for prev node
        else tail.next = null;
        return data;
    }
    //removing any node arbitrarily
    private T remove(Node <T> node){
        
    //removing node somewhere in the list either head or tail,handle them independently
      if(node.prev == null) return removeFirst();
      if(node.next == null) return removeLast();
      
      // make the adjacent pointers over the node and skip the node
      node.next.prev = node.prev;
      node.prev.next = node.next;
      
      //Temporary store data we want to return
      T data = node.data;
      
      //memory cleanup
      node.data = null;
      node = node.prev = node.next = null;
      --size;
      
      return data;
    }
    }
    // removing the node at particular index
    public T removeAt(int index) {
    // Make sure the index provided is valid
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }

    int i;
    Node<T> trav;

    // Search from the front of the list
    if (index < size / 2) {
      for (i = 0, trav = head; i != index; i++) {
        trav = trav.next;
      }
      // Search from the back of the list
    } else
      for (i = size - 1, trav = tail; i != index; i--) {
        trav = trav.prev;
      }

    return remove(trav);
  }
  public boolean remove(Object obj){
      Node<T> trav = head;
      
      //support Searching for null
      if(obj == null){
          //traversing the array
          for(trav=head;trav!=null;trav = trav.next){
              if(trav.data == null){
                  remove(trav);
                  return true;
              }
          }
          //Searching for not null values
      } else {
          for(trav=head;trav!=null;trav = trav.next){
              if(obj.equals(trav.data)){
                  remove(trav);
                  return true;
      }
  }
  return false;
  
  // Find the index of a particular value in the linked list, O(n)
  public int indexOf(Object obj) {
    int index = 0;
    Node<T> trav = head;

    // Support searching for null
    if (obj == null) {
      for (; trav != null; trav = trav.next, index++) {
        if (trav.data == null) {
          return index;
        }
      }
      // Search for non null object
    } else
      for (; trav != null; trav = trav.next, index++) {
        if (obj.equals(trav.data)) {
          return index;
        }
      }

    return -1;
  }
  

  // Check is a value is contained within the linked list
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private Node<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
      sb.append(trav.data + ", ");
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }
    
    
}