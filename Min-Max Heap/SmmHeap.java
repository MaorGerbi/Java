package maman14;

import java.util.ArrayList;

/*
    This is a symmetric min max heap, implemented as a binary tree 
    where the right child of each node is a Max Heap, and the left child of each
    node is a Min Heap, and node 0 is a dummy node.
*/
public class SmmHeap {
  private ArrayList<Integer> heap;

  // Constructs the SmmHeap, with a complexity of O(n)
  public SmmHeap(ArrayList<Integer> array) {
      heap = new ArrayList<Integer>(array);
      heap.add(0, -1);
      for(int i=heap.size()/2; i > 0; i--) {
          //insert(array.get(i));
          bubbleDown(i);
      }
  }
  
  // Inserts a value to the SmmHeap, with a complexity of O(logn)
  // It bubbles the value up to it's correct place in the tree,
  // passing each tree level once, which makes it O(logn)
  public void insert(int value) {
      heap.add(value);
      if(heap.size() == 2)
          return;
      int index = heap.size() - 1;
      if(index % 2 == 0 && heap.get(index) < heap.get(index - 1)) {
          swap(index, index-1);
      }
      boolean stop = false;
      while(!stop) {
          if(hasLeftUncle(index) && heap.get(index) < heap.get(leftUncle(index))) {
              swap(index, leftUncle(index));
              index = leftUncle(index);
          }
          else if(hasRightUncle(index) && heap.get(index) > heap.get(rightUncle(index))) {
              swap(index, rightUncle(index));
              index = rightUncle(index);
          }
          else {
              stop = true;
          }
      }
  }
  
  // Bubbles down a value at index 'index', to the correct place down the tree.
  // It passes each level once, which makes it O(logn)
  private boolean bubbleDown(int index) {
      boolean swapped = false;
      if(isLeftSibling(index) && hasRightSibling(index) && heap.get(index) > heap.get(index+1)) {
          swap(index, index+1);
          swapped = true;
      }
      else if(isRightSibling(index) && heap.get(index) < heap.get(index-1)) {
          swap(index, index-1);
          swapped = true;
      }
      
      int replaceWith;
      if(isLeftSibling(index)) {
          int leftChild = leftChild(index);
          if(leftChild < heap.size()) {
              int leftNephew = leftNephew(index);
              if(leftNephew < heap.size()) {
                  if(heap.get(leftChild) < heap.get(leftNephew)) {
                      replaceWith = leftChild;
                  }
                  else {
                      replaceWith = leftNephew;
                  }
              }
              else {
                  replaceWith = leftChild;
              }
          }
          else {
              replaceWith = index;
          }
          if(heap.get(index) > heap.get(replaceWith)) {
              swap(index, replaceWith);
              bubbleDown(replaceWith);
          }
      }
      else if(isRightSibling(index)) {
          int rightNephew = rightNephew(index);
          if(rightNephew < heap.size()) {
              int rightChild = rightChild(index);
              if(rightChild < heap.size()){
                  if(heap.get(rightChild) > heap.get(rightNephew)) {
                      replaceWith = rightChild;
                  }
                  else {
                      replaceWith = rightNephew;
                  }
              }
              else {
                  replaceWith = rightNephew;
              }
          }
          else {
            replaceWith = index;
          }
          if(heap.get(index) < heap.get(replaceWith)) {
              swapped = true;
              swap(index, replaceWith);
              bubbleDown(replaceWith);
          }
      }
      return swapped;
  }
  
  // Deletes the min node of the tree, by using BubbleDown method (O(logn))
  public int deleteMin() {
      int min = heap.get(1);
      swap(1, heap.size()-1);
      heap.remove(heap.size()-1);
      if(heap.size() > 1) {
        bubbleDown(1);
      }
      return min;
  }
  
  // Deletes the max node of the tree, by using BubbleDown method (O(logn))
  public int deleteMax() {
      int max;
      if(heap.size() < 3) {
          max = heap.get(1);
          heap.remove(1);
          return max;
      }
      max = heap.get(2);
      swap(2, heap.size()-1);
      heap.remove(heap.size()-1);
      bubbleDown(2);
      return max;
  }

  // determines if index k has a right sibling
  private boolean hasRightSibling(int k) {
      return heap.size() > k + 1;
  }
  
  // determines if index k has a left uncle
  private boolean hasLeftUncle(int k) {
      return k > 2;
  }
  
  // determines if index k has a right uncle
  private boolean hasRightUncle(int k) {
      return k > 2;
  }

  // finds the min node of the tree
  public int findMin() {
      return heap.get(1);
  }
  
  // finds the max node of the tree
  public int findMax() {
      return heap.size() > 2 ? heap.get(2) : heap.get(1);
  }

  // determines if index k is a left sibling
  private boolean isLeftSibling(int k) {
    return k % 2 != 0 && k != 0;
  }
  
  // determines if index k is a right sibling
  private boolean isRightSibling(int k) {
    return k % 2 == 0 && k != 0;
  }
  
  // gets the left child of index k
  private int leftChild(int k) {
    return 2 * k + 1;
  }
  
  // gets the right child of index k
  private int rightChild(int k) {
    return 2 * k + 2;
  }
  
  // gets the left nephew of index k
  private int leftNephew(int k) {
    if (k % 2 == 0) {
      return 2 * k - 1;
    } else {
      return 2 * k + 3;
    }
  }
  
  // gets the right nephew of index k
  private int rightNephew(int k) {
    if (k % 2 == 0) {
      return 2 * k;
    } else {
      return 2 * k + 4;
    }
  }
  
  // gets the left uncle of index k
  private int leftUncle(int k) {
      if(parent(k) % 2 == 0) {
          return parent(k) - 1;
      }
      else {
          return parent(k);
      }
  }
  
  // gets the right uncle of index k
  private int rightUncle(int k) {
      if(parent(k) % 2 == 0) {
          return parent(k);
      }
      else {
          return parent(k) + 1;
      }
  }
  
  // gets the parent of index k
  private int parent(int k) {
      if(isRightSibling(k))
          return k/2 - 1;
      else
          return k/2;
  }

  // swaps two indices
  private void swap(int x, int y) {
    int temp;
    temp = heap.get(x);
    heap.set(x, heap.get(y));
    heap.set(y, temp);
  }

  // prints the array(O(n))
  public void printArray() {
    System.out.print("heap array: ");
    for (int i = 1; i < heap.size(); i++) {
      System.out.print(heap.get(i) + " ");
    }
    System.out.println();
  }
}