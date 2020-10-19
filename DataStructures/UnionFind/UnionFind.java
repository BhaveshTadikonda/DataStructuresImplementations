/*package whatever //do not write package name here */

import java.io.*;

class unionfind {
    
    //number of elements in this unionfind
    private int size;
    //used to track the sizes of each of components
    private int[] sz;
    //id[i] points to the parent of i,if id[i] = i then i is root node
    private int[] id;    
    //track number of components in the unionfind 
    private int numcomponents;
    
    public unionfind(int size){
        if(size<=0){
            throw new IllegalArgumentException("size<=0 not allowed");
            this.size = numcomponents = size;
            sz = new int[size];
            id = new int[size];
            
        for(int i=0;i<size;i++){
            id[i] = i; //link to itself (self root)(everything is root node)
            sz[i] = i; // each component original size is one(size of the node is one)
        }
        }
    }
//find which component/set 'p' belongs to, take amortized time(pathcompresionalongthewa)
        public int find(int p){
        //Find the root node of p(if we are p and we need to find rootnode)
        int root = p;
        while(root!=id[root]){
            root = id[root];
        //Path compression
        //compress the path leading back to the root,
        //which gives amortized time complexity 
        while(p!=root){
            int next = id[p];
            //compressed amortized
            id[p] = root;
            p = next;
        }
        return root;
        }
        }
//return whether or not the elements 'p' and 'q' are in the same component
       public boolean (int p, int q){
           return find(p) == find(q);
       }
    //return the size of the components/sets 'p' belongs
   public int componentsize(int p){
      // finds and dos the path compression as well
       return sz[find(p)];
   }
   //return the number of elements in the unionfind
   public int size(){
       return size;
   }
  //returning number of components
   public int components(){
       return numcomponents;
   }
   //unifying the components sets and elements present in p and q
   public void unify(int p,int q){
       int root1 = find(p);
       int root2 = find(q);
      //these elements are the same group
      if(root1==root2) return;
      //merge two componets/sets together
      //merge smaller components into larger components
      if(sz[root1]<sz[root2]){
          sz[root2] += sz[root1];
          id[root1] = root2;
      } else {
          sz[root1]+= sz[root2];
          id[root2] = root1;
      }
      //since the roots found are different we know that 
      //number of num/components decreased by one
      numcomponents--;
   }
   
   
   
	public static void main (String[] args) {
		System.out.println("GfG!");
	}
}