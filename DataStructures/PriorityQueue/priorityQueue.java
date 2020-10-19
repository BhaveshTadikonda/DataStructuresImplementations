/*package whatever //do not write package name here */

import java.io.*;

// inside PQ -> Comparable elements inside the queue
class Priorityqueue <T extends Comparable<T>>{
    
    //the number of elements currently present inside the heap,instance variables
    private int heapSize = 0;
    //internal capacity of the heap,size of the list
    private int heapCapacity = 0;
    //dynamic list to track elements inside the heap
    private List <T> heap = null;
//this map will keep track of the possible indices of a particular node value found in the 
//heap. Having mapping let us has, 0(log(n)) removals and 0(1) containment check,at cost of
//additional space and minior checks 
    //Treemap -> mapping all the elements inside the queue
    private Map<T,TreeSet<Integer>> map = new HashMap<>();
    //construct, initially empty Priorityqueue
        public PQueue(){
            this(1);
        }
    //construct a priority with initial capacity
    public PQueue(int sz){
        heap = new ArrayList<>(sz);
    }
//construct a priority queue using heapify in 0(n) time,
    public PQueue (T[] elems){
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<T>(heapCapacity);
    }
        //place all elements in heap
        for(int i=0;i<heapSize;i++){
            mapAdd(elems[i],i);
            heap.add(elems[i]);
        }
        //heapify Process, 0(n)
        for(int i=Math.max(0,(heapSize/2)-1);i>=0;i--){
            sink(i);
        }
     //priority queue construction, 0(nlog(n))
     public PQueue (collection <T> elems){
         this(elems.size());
         for(T elem:elems) add(elem);
     }
    //returns true/false depending on size of the PQ is empty
     public boolean isEmpty(){
         return heapSize == 0;
     }
    //clears everything inside the heap 0(n)
     public void clear(){
        for(int i=0;i<heapCapacity;i++){
            heap.set(i,null);
        heapSize = 0;
        map.clear();
        }
     }
     //returns the size of the heap.
     public int size(){
         return size;
     }
    //returns value of the elements with lowest priority in the priority queue
    //if priority queue is empty it will return null 
    public T peek(){
        if(isEmpty) return null;
        return heap.get(0);
    }
    //removes the root of the queue - 0(log(n))
    public T poll(){
        return removeAt(0);
    }
    //Test an element in the heap
    public boolean contain(T elem){
     //map lookup for checking the element contained
     if(elem == null) return false;
     return map.containsKey(elem);
    }
    //linear scan to check the containment, 0(n)
    //for(int i=0;i<heapSize;i++){
    //     if(heap.get(i).equals(elem))
    //         return true;
    // }
    // return false;
        

	public static void main (String[] args) {
		System.out.println("GfG!");
	}
	//adds an element to the priorityQueue which is not null - 0(log(n))
	public void add(T elem){
	    if(elem == null) throw new IllegalArgumentException("");
	    if(heapSize < heapCapacity){
	        heap.set(heapSize,elem);
	    }else {
	        heap.add(elem);
	        heapCapacity++;
	    }
	    mapAdd(elem, heapSize);
	    swim(heapSize);
	    heapSize++;
	}
	//helper method, helps to check whether node(i) < node(j)
	//this method assumes, i,j are valid indices, 0(1)
	private boolean less(int i,int j){
	    T node1 = heap.get(i);
	    T node2 = heap.get(j);
	    return node1.compareTo(node2) <=0;
	}
	//Bottom up node swim up - 0(log(n))
	private void swim(int k){
	    //grab the index of the node with respective to the k
	    int parent = (k-1)/2;
 //keep swiming up, while we are not reaching to the root node and while lessthan parent node
      while(k>0 && less(k,parent)){
          swap(parent,k);
          k=parent;
        //grab the next parent WRT to k 
        parent = (k-1)/2;
      }
	}
	//Top down node sink, 0(log(n))
	private void sink(int k){
	   while(true){
	       int left = 2*k+1; //left node
	       int right = 2*k+2; //right node
	       int smallest = left;//assumes left is the smallest of two nodes of children 
	   //Find which is smaller left or right
	   //If left is smaller set smallest to be right
	   if(right<heapSize && less(right,left)){
	       smallest = right;
	   //stop if we are outside of bounds of tree/stop we cannot sink k anymore
	   if(left >= heapSize || less(k,smallest)) break; 
	   //move down the following tree for the smallest node
	   swap(smallest,k);
	   k = smallest;
	   }
     // Swap two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j) {
    T elem_i = heap.get(i);
    T elem_j = heap.get(j);

    heap.set(i, elem_j);
    heap.set(j, elem_i);
  }
  //removes particular element in the heap 0(log(n))
    public boolean element(T element){
        if(element == null){
            return false;
        }
    //linear search via linear time 0(n)
    // for(int i=0;i<heapSize;i++){
    //     if(element.equals(heap.get(i)));
    //     returnAt(i);
    //     return true;
    // }
     //logarithmic removal with the map 0(log(n))
     Integer index = mapGet(element);
     if(index!=null) removeAt(index);
     return index!= null;
    }
    
    //removes a node at particular index, 0(log(n))
    private T removeAt(int index){
        
        if(isEmpty) return null;
        heapSize--;
        T remove_data = heap.get(i);
        swap(i,heapSize);
    //obliterate values
    heap.set(heapSize,null);
    mapRemove(removed_data,heapSize);
    
    //obliterate values
    heap.set(heapSize,null);
    mapRemove(removed_data,heapSize);
    //removed last element 
    if(i==heapSize) return removed_data;
    
    T elem = heap.get(i);
    //try sink
    sin(i);
    //if sinking doesn't work try swiming up 
    if(heap.get(i).equals(elem))
    swim(i);
    return removed_data;
    }
        // Recursively checks if this heap is a min heap
  // This method is just for testing purposes to make
  // sure the heap invariant is still being maintained
  // Called this method with k=0 to start at the root
  public boolean isMinHeap(int k) {
    // If we are outside the bounds of the heap return true
    if (k >= heapSize) return true;

    int left = 2 * k + 1;
    int right = 2 * k + 2;

    // Make sure that the current node k is less than
    // both of its children left, and right if they exist
    // return false otherwise to indicate an invalid heap
    if (left < heapSize && !less(k, left)) return false;
    if (right < heapSize && !less(k, right)) return false;

    // Recurse on both children to make sure they're also valid heaps
    return isMinHeap(left) && isMinHeap(right);
  }

  @Override
  public String toString() {
    return heap.toString();
  }
	       
	       
	       
	   }
	}
	
}