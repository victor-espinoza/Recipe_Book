/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

import java.util.Comparator;

public interface List extends Iterable {
   void addLast(Object item);
   void insert(int index, Object item);

   Object get(int index);
   int indexOf(Object item);

   Object removeAt(int index);
   boolean remove(Object item);

   void clear();
   int getCount();

   void sort(Comparator comp);
}//close interface List