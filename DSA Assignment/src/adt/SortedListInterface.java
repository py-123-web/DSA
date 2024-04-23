package adt;

/**
 *
 * @author All Members
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> extends Iterable<T> {

    public boolean add(T newEntry);

    public boolean remove(T anEntry);

    public T getEntry(int givenPosition);

    public int contains(T anEntry);

    public void replace(T oldEntry, T newEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public void clear();//add on
}
