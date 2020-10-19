/*package whatever //do not write package name here */

import java.io.*;

@SuppressWarnings("unchecked")
public class array <T> implements Iterable <T> {
    
    private T[] arr; // Internal stack array
    private int len; // length user thinks array thinks
    private int capacity; // actual array size
    
    //constructor,initializing array size of 16
    public array {
        this(16);
    }
    //constructor, for capacity 
    public array(int capacity){
       if(capacity<0) throw new IllegalArgumentException("Illegal capacity:"+ capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    //size of array method
    public int size() {
        return len;
    }
    //checking array is isEmpty method
    public boolean isEmpty(){
        return size() == 0;
    }
    // getting index of an array
    public T get(int index){
        return arr[index];
    }
    //setting particular index of array to element
    public void set(int index,T elem){
        arr[index] = elem;
    }
    // removing all the elements in the array and resetting to new;
    public void clear(){
        for(int i=0;i<capacity;i++){
            arr[i] = null;
            len = 0;
        }
    }
    // increasing the capacity of the array,doubling the size of array
    public void add(T elem){
    // time to resizing,before checking the condition.Once it fails we need to increment
    if(len+1 >= capacity){
        if(capacity == 0) capacity = 1;
        else capacity *= 2; //doubling the size of array
        // creating new array with new capacity
        T[] new_arr = (T[]) new Object[capacity];
        for(int i=0;i<len;i++){
            //copying the old array elements to new array elements
            new_arr[i] = arr[i];
            arr = new_arr; // padding extra zeros to array
        }
        arr[len++] = elem;
    }
      //removing an element at specified index in list
    public T removeIndex(int index){
        //checking whether index is valid or not
        if(index>=len && index<0) throw new IndexOutOfBoundsException();
        //getting the data
        T data = arr[index];
        T [] new_arr = (T[]) new Object[len-1];
        for(int i=0;j=0;i<len;i++;j++){
            if(i==index); j--; // skip_over remove index by fixing j temporarily 
            else new_arr[j] = arr[i];
            arr = new_arr;
            capacity = --len;
            return data;
        }
    }
        
        public boolean remove(Object ob){
            for(int i=0;i<len;i++){
                if(arr[i].equals(obj)){
                    removeAt(i); return true;}
            }
                    return false;
                }
    //finding the index in the array, if found return 1 or else return -1    
    public int index(Object obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                return i;
            }
            return -1;
    }
    }
    public boolean contain(Object obj){
        return indexOf(obj) != -1;
    }
  // Iterator is still fast but not as fast as iterative for loop
  // Iterator will Iterator over array
  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < len;
      }

      @Override
      public T next() {
        return arr[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  // String repersentation of an array
  @Override
  public String toString() {
    if (len == 0) return "[]";
    else {
      StringBuilder sb = new StringBuilder(len).append("[");
      for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
      return sb.append(arr[len - 1] + "]").toString();
    }
  }
    
}