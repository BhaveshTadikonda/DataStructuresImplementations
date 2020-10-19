/*package whatever //do not write package name here */

import java.io.*;

class doublyLinkedList <T> implements Iterable <T> {
    
    //meaning LinkedList is empty
    private int size =0;
    // we are initializing head and tail to null,bcoz of empty LinkedList
    private <Node> head = null;
    private <Node> tail = null;
    
    //Internal node class to represent the data
    private static class Node <T> {
        // it contains all the data present in the doublyLinkedList
        T data;
    //It's doublyLinkedList so we have prev and next pointers in List
        Node <T> prev,next;
   //constructing for having namely prev and next pointers
        public Node(T data,Node<T>prev,Node<T>next){
            this.data = data;
            this.prev = prev;
            this.next = next;
            @Override public String toString(){
                return data.toString;
            }
        }
    }
   //empty the LinkedList in linear time-0(n),deallocates and allocates in linear time
   public void clear(){
       Node <T> trav = head;
    //deallocation happens here
       while(trav!=null){
          Node <T> next = trav.next;
          trav.prev = trav.next = null;
          trav.data = null;
          trav = next;
       }
    //setting head and tail to null.
      head=tail=trav=null;
      size =0;
   }
   //returns the size of LinkedList
   public int size(){
       return size;
   }
   //Is linkedlist empty
   public boolean isEmpty(){
       return size()==0;
   }
 //adding an element to the tail of linkedlist- 0(1)
    public void add(T elem){
        addlast(elem);
    }
 //adding elements to the start of the ll-0(1)
    public void addfirst(T elem){
        //linkedlist is empty (prev,next -> null)
     if(isEmpty()){
        head = tail = new Node <T> (elem,null,null);  
     }else {
    //if ll is not empty we are going to setup, head to start(so creating a new node)
         head.prev = new Node <T> (elem,null,head);
         head = head.prev;
     }
     size++;
    }
 //adding an elem to last of ll-0(1)
    public void addlast(T elem){
      //ll is empty (prev,next-> null)
     if(isEmpty(){
         head = tail = new Node <T> (elem,null,null);
     }else {
        tail.next = new Node<T> (elem,tail,null);
        tail = tail.next;
     }
     size++;
    }
//looking at the start of the LL -> (peek)-> 0(1) and return the value at the start.so data
    public T peekFirst(){
        if(isEmpty()) throws new RuntimeExceptionon("linkedlist empty"){
        return head.data;
    }
    }
    public T peekLast(){
        if(isEmpty()) throws new RuntimeExceptionon("linkedlist empty"){
            return tail.data;
        }
        }
 //removing the first node of ll - 0(1)
  public T removeFirst(){
   //can't remove the data if it is empty and throws Exception
   if(isEmpty()) throws new RuntimeExceptionon("linkedlist empty");
   // if not empty,getting the data at first and then moving to next node
   T data = head.data;
   head = head.next;
   --size;
   //if list isEmpty set the tail to null  
   if(isEmpty()) tail = null;
   //memory clean of previous node
   else head.prev = null;
  //return the data that just we removed
   return data;
  }
 // remove the lastnode of ll - 0(1)
  public T removeLast(){
     if(isEmpty()) throws new RuntimeExceptionon("linkedlist is empty");
     T data = tail.data;
     tail = tail.prev;
     --size;
    if(isEmpty()) head = null;
  //memoryclean up to check it is removed properly
    else tail.next = null;
     return data;
  }
 //removing arbitrary node from ll -> 0 (1)
 //setting it private,node class is private.no one could access it externally 
 private T remove(Node <T> node){
    //if the removing node is at last or first,remove them using methods
     if(node.prev == null) return removeFirst();
     if(node.next == null) return removeLast();
     
//if the removing node in the middle,make the pointers at adjacent node and skip node
    node.prev.next = node.next;
    node.next.prev = node.prev;
 //temporary store the data we want to return them
   T data = node.data;
   //memoryclean up 
   node.data = null;
   node = node.prev = node.next = null;
   --size;
   retruning the data just we removed it.
    return data;
 }
 //removing a node at particular index - 0(n)
 public T removeAt(int index){
     //make sure index provide is valid 
    if(index<0 || index>= size) throws new IllegalArgumentException();
    int i;
    Node <T> trav;
    //search from start of linkedlist
    if(index< size/2){
        for(int i=0;trav=head;i!=index;i++){
            trav = trav.next;
        }else {
    //search from back of linkedlist
        for(int i =size-1;trav=tail;i!=index;i--){
            trav = trav.prev;
        }
        return remove(trav);
       }
    }
 //removing arbitrary value from the linkedlist
 public boolean remove(Object obj){
     Node <T> trav = head;
    //support searching for null
    if(obj == null){
     for(trav=head;trav!=null;trav= trav.next){
         if(trav.data==null){
             remove(trav);
             return data;
         }
     } else {
        //search for non null objects
     for(trav=head;trav!=null;trav=trav.next){
         if(obj.equals(trav.data)){
             remove(trav);
             return true;
         }
     }
    } 
    return false;
 }
 }
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