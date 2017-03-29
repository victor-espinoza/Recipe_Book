/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

import java.util.*;

public class ArrayList implements List {

   private class ArrayListIterator implements Iterator {
      private int mIndex = 0;

      public boolean hasNext() {
         return mIndex < mCount;
      }//close hasNext()

      
      public Object next() {
         return mArray[mIndex++];
      }//close next()

      
      @Override
      public void remove() {
         throw new UnsupportedOperationException("Optional method not " +
          "supported.");
      }//close remove()
   }//close ArrayListIterator

   private Object[] mArray;
   private static final int DEFAULT_SIZE = 10;
   private int mCount;

   //Initializes a new array list with a default capacity.
   public ArrayList() {
      mArray = new Object[DEFAULT_SIZE];
   }//close ArrayList() constructor

   
   //Initializes a new array list with a specified capacity.
   public ArrayList(int initialCapacity) {
      mArray = new Object[initialCapacity];
   }//close ArrayList(...) constructor

   
   //Returns a new ArrayListIterator to help iterate over the array.
   public Iterator iterator() {
      return new ArrayListIterator();
   }//close iterator()

   
   //Returns the number of elements in the list.
   public int getCount() {
      return mCount;
   }//close getCount()

   
   //Removes all elements from the list.
   public void clear() {
      for (int i=0; i<mCount; i++)
         mArray[i]=null;
      mCount = 0;
   }//close clear()

   
   //Adds an item to the end of the list.
   public void addLast(Object item) {
      resizeIfNecessary();
      mArray[mCount++] = item;
   }//close addLast(...)

   
   /*Inserts an item at the given index. Shifts the element currently at
   the index (and all elements that follow it) to the right, increasing their
   indices by 1.*/
   public void insert(int index, Object item) {
      //resize array if necessary
      resizeIfNecessary();
      //shift everything after the desired insert index to the right
      shiftRight(index);
      //insert element in desired index and increase the count of 
      mArray[index] = item;
      mCount++;
   }//close insert(...)

   
   /*Determines the index position where the given element is stored in the 
   list. return -1 if the element is not found; otherwise its 0-based index.*/
   public int indexOf(Object item) {
      for (int i=0; i<mCount; i++) 
         if (mArray[i] == item) 
            return i;
      return -1;
   }//close indexOf(...)

   
   /*Removes an element at the specified index, returning the element that was
   just removed. All elements to the right of the specified index will be
   shifted to the left, decreasing their indices by 1.*/
   public Object removeAt(int index) {
      Object toReturn = mArray[index];
      shiftLeft(index);
      mCount--;
      return toReturn;
   }//close removeAt(...)

   
   //Removes a specific element from the list without knowing its index.
   public boolean remove(Object toRemove) {
      int index = indexOf(toRemove);
      if (index >= 0) {
         removeAt(index);
         return true;
      }//end if
      return false;
   }//close remove(...)
   

   //Retrieves the element at a given index.
   public Object get(int index) {
      return mArray[index];
   }//close get(...)
   

   //resizes array if it is too small
   private void resizeIfNecessary() {
      if (mCount == mArray.length) {
         Object[] newArray = new Object[mArray.length * 2];
         System.arraycopy(mArray, 0, newArray, 0, mCount);
         mArray = newArray;
      }//end if
   }//close resizeIfNecessary()
   

   //shifts array to the right
   private void shiftRight(int startNdx) {
      System.arraycopy(mArray, startNdx, mArray, startNdx + 1,
       mCount - startNdx);
   }//close shiftRight(...)
   

   //shifts array to the left
   private void shiftLeft(int startNdx) {
      System.arraycopy(mArray, startNdx + 1, mArray, startNdx,
       mCount - startNdx - 1);
   }//close shiftLeft(...)

   
   //perform insertion sort on array
   public void sort(Comparator comp){
      int j;
      Object elementI;
      for (int i=0; i<mCount; i++){
         //assign current value in array to a temporary value
         elementI = mArray[i];
         for (j=i; j>0; j--)
            //compare temp. value to previous value in array
            if (comp.compare(elementI, mArray[j-1]) < 0)
               //update current index in array with bigger number
               mArray[j] = mArray[j-1]; 
            else
               //if number is bigger, no need to traverse the rest of for loop
               break;
         //insert the temp value into its appropriate place in the array
         mArray[j] = elementI;
      }//end outer for loop
   }//close sort

}//close class ArrayList
