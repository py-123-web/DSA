package adt;

/**
 *
 * @author All Members
 */

import java.util.Iterator;

public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T>, Iterable<T> {

  private T[] array;
  private int numberOfEntries;
  private static final int DEFAULT_CAPACITY = 25;

  public SortedArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public SortedArrayList(int initialCapacity) {
    numberOfEntries = 0;
    array = (T[]) new Comparable[initialCapacity];
  }
  
  //public void add(int position, T new Entry);

  public boolean add(T newEntry) {
      //+++++++++++++++++++
      if (isArrayFull()) {
        int newCapacity = array.length * 2; 
        T[] newArray = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < numberOfEntries; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
      }
      //+++++++++++++++++++++++
      
      
    int i = 0;
    while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
      i++;
    
    }
    makeRoom(i + 1);
    array[i] = newEntry;
    numberOfEntries++;
    return true;
  }
    
  public void clear() {
    array = (T[]) new Comparable[DEFAULT_CAPACITY];

    numberOfEntries = 0; // Reset the number of entries to 0
}

  public boolean remove(T anEntry) {
    int i = 0;
    while (i < numberOfEntries && anEntry.compareTo(array[i]) > 0) {
      i++;
    }
    
     if (i < numberOfEntries) {
        removeGap(i);
      }

      numberOfEntries--;
      return true;
  }


  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
      result = array[givenPosition];
    }

    return result;
  }
  
  public void replace(T oldEntry,T newEntry){
      int i = 0;
      while (i < numberOfEntries && oldEntry.compareTo(array[i]) > 0) {
      i++;
        }
      array[i] = newEntry ;
  }
  
  public int contains(T anEntry) {
      if(isEmpty())
          return -1;
     return binarysearch(anEntry);
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < numberOfEntries; ++index) {
      outputStr += array[index] + "\n";
    }

    return outputStr;
  }

  @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < numberOfEntries && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
            public boolean remove(T anEntry) {
    if (numberOfEntries == 0){
        if (numberOfEntries == 0){
            return false;
        }
        else{
            int i = 0;
            while (i < numberOfEntries && array[i].compareTo(anEntry) < 0){
                i++;
            }
            
            if (array[i].equals(anEntry)){ //target found
                removeGap(i + 1); //shifting after removed
                numberOfEntries--;
                return true;
            }
        }
    }
     return false;
  }
        };
    }
    
    private boolean isArrayFull() {
      return numberOfEntries == array.length;
    }

    private void doubleArray() {
      T[] oldList = array;
      int oldSize = oldList.length;

      array = (T[]) new Object[2 * oldSize];

      for (int index = 0; index < oldSize; index++) {
        array[index] = oldList[index];
      }
    }

    private void makeRoom(int newPosition) {
      int newIndex = newPosition - 1;
      int lastIndex = numberOfEntries - 1;
      for (int index = lastIndex; index >= newIndex; --index) {
        array[index + 1] = array[index];
      }
    }

    private void removeGap(int givenPosition) {
      int removedIndex = givenPosition;
      int lastIndex = numberOfEntries - 1;


      for (int index = removedIndex; index < lastIndex; index++) {
        array[index] = array[index + 1];
      }
    }

    private int binarysearch(T search){
        int lower = 0;
        int higher = numberOfEntries - 1;

        while(lower<=higher){
            int middle=(lower+higher)/2;
            int campresult=array[middle].compareTo(search);

            if (campresult == 0) {
                  return middle; 
              } else if (campresult < 0) {
                  lower = middle + 1;
              } else {
                  higher = middle - 1;
              }
          }

          return -1;
  }

}