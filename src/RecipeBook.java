/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

import java.util.Comparator;
import java.util.Iterator;

public class RecipeBook implements Iterable{
   //give constants a name in case they need to be changed in the future
   private final int SORT_BY_NAME = 1;
   private final int SORT_BY_SERVINGS = 2;
   private final int SORT_BY_TIME = 3;
   private final int DIVIDE_BY_2 = 2;
   
   //List contatinint the items in the recipe book
   private final List mRecipeBook;
   
   //variables determining which way to sort the recipe book
   private boolean mNameAscending = false;
   private boolean mNameDescending = false;
   
   //constructor for the recipe book
   public RecipeBook() {
      mRecipeBook = new ArrayList();
   }//close RecipeBook() constructor

   
   //add a recipe to the recipe book
   public void add(Recipe itemToAdd) {
      //add recipe to recipe book
      mRecipeBook.addLast(itemToAdd);
      //Perform the isSortedByName method so that we can keep track of
      //whether the list is sorted by name or not
      isSortedByName();
   }//close itemToAdd(...)

   
   //remove recipe from recipe book
   public void remove(Recipe itemToRemove) { 
      //remove item from array
      mRecipeBook.remove(itemToRemove);
      //Perform the isSortedByName method so that we can keep track of
      //whether the list is sorted by name or not
      isSortedByName();
   }//close removeRecipe(...)

   
   //get the number of recipies in the recipe book
   public int getCount() {
      return mRecipeBook.getCount();
   }//close getCount()

   
   //get a certain recipe in the recipe book
   public Recipe get(int index) {
      return (Recipe) mRecipeBook.get(index);
   }//close get

   
   //perform a linear search on the recipe book if it is not sorted
   public Recipe linearSearch(String recipeName) {
      Recipe desiredRecipe = null;
      //iterate through each recipe in the recipe book
      for (Object g: mRecipeBook) {
         Recipe testRecipe = (Recipe) g;
         if (testRecipe.getRecipeName().equalsIgnoreCase(recipeName)) {
            desiredRecipe = testRecipe;
            break;
         }//end if
      }//end for
      return desiredRecipe;
   }//close linearSearch(...)
   
   
   //perform a binary search on the recipe book (must be sorted)
   public Recipe binarySearch(String recipeName) {
      /* Calculate the midpoint value by adding up your start and endpoint
       * values and dividing that by 2, then check to see if the recipe name
       * at that index matches the desired recipe. If it does, then we return
       * that recipe. If it does not, then we set start and end to new values
       * depending on whether the list is ascending or descending and then
       * repeat the process until we find the recipe or return null if
       * we could not find the desired recipe.
       */
      int start = 0;
      int end = mRecipeBook.getCount() - 1;
      int mid;
      while (start <= end) {
         mid = (start + end) / DIVIDE_BY_2;
         Recipe r = (Recipe) mRecipeBook.get(mid);
         int compare = recipeName.compareTo(r.getRecipeName());
         if (compare == 0)
            return r;
         if (mNameDescending)
            compare = compare * -1;
         if (compare < 0)
            end = mid - 1;
         else
            start = mid + 1;
      }//end if
      return null;        
   }//close binarySearch(...)
   
   
   //check to see if the Recipe book is still sorted by name
  public void isSortedByName() {
      //Initialize a Comparator Object to compare our RecipeBook and check
      //to see if it is sorted by name or not.
      RecipeBookComparator comp = new RecipeBookComparator(1, true);
      Recipe currRecipe, prevRecipe;
      int compare;

      //initialize conditions to true
      mNameAscending = true;
      mNameDescending = true;
         
      //check if list is sorted by name in ascending/descending order
      for (int i=1; i<mRecipeBook.getCount(); i++){
         //assign current/previous values in array to temporary values
         currRecipe = (Recipe) mRecipeBook.get(i);
         prevRecipe = (Recipe) mRecipeBook.get(i-1);
         //compare values
         compare = comp.compare(currRecipe, prevRecipe);
         //update mNameAscending flag
         if(mNameAscending) 
            mNameAscending = compare >= 0;
         //update mNameDescending flag
         if(mNameDescending)
            mNameDescending = compare <= 0;
         //if list is not sorted in ascending or descending order by name,
         //then exit the loop so we don't waste any unnecessary time going
         //through the loop when we do not have to...
         if(!mNameAscending && !mNameDescending)
            break;
      }//end for loop
   }//close isStillSortedByName()

   
   //search for a recipe by its recipe name
   public Recipe searchByName(String recipeName) {
      //Check to see if the list is sorted by name. If it is, then use binary
      //search. If it is not sorted by name, then you perform linear search
      //instead.
      if (mNameAscending || mNameDescending) {
         System.out.println("\nPerforming binary search...");
         return binarySearch(recipeName);
      }//end if
      else {
         System.out.println("\nPerforming linear search...");
         return linearSearch(recipeName);
      }//end else
   }//close searchByName(...)

   
   //search for a recipe by a certain ingredient
   public List searchByIngredient(String ingredient) {
      List recipes = new ArrayList();
      Recipe desiredRecipe;
      for (Object g: mRecipeBook) {
         Recipe testRecipe = (Recipe) g;
         if (testRecipe.hasIngredient(ingredient)) {
            desiredRecipe = testRecipe;
            recipes.addLast(desiredRecipe);
         }//end if
      }//end for
      return recipes;
   }//close searchByIngredient(...)

   
   //Create and return an iterator for the recipe book list
   public Iterator iterator() {
      return mRecipeBook.iterator();
   }//close iterator()

   
   //Sort the recipe book according to the selected sorting criteria
   public void sortBook(int sortType, boolean aField){
      if (SORT_BY_NAME == sortType && mRecipeBook != null)
         mRecipeBook.sort(new RecipeBookComparator(SORT_BY_NAME, aField));
      if (SORT_BY_SERVINGS == sortType && mRecipeBook != null)
         mRecipeBook.sort(new RecipeBookComparator(SORT_BY_SERVINGS,
          aField));
      if (SORT_BY_TIME == sortType && mRecipeBook != null)
         mRecipeBook.sort(new RecipeBookComparator(SORT_BY_TIME, aField));

      /* Since the list was sorted, the mAscending and mDescending fields have
       * the potential to change. If the sortType is 1 (Sort by name), then
       * we set mAscending and mDescending to their appropriate values. If
       * sortType is not 1, then we set mAscending and mDescending to false,
       * indicating that the RecipeBook is not sorted by name. This also
       * causes the searchByName method to perform a linear search instead of
       * a binary search.
       */
      if (sortType == 1){
         if (aField)
            mNameAscending = true;
         else
            mNameDescending = true;
      }//end if
      else {
         mNameAscending = false;
         mNameDescending = false;
      }//end else
   }//close sortBook(...)

   public class RecipeBookComparator implements Comparator {
      private final int mSortField;
      private final boolean mAscendingField;
      
      //RecipeBookComparator constructor method
      public RecipeBookComparator(int sortField, boolean ascendingField) {
         mSortField = sortField;
         mAscendingField = ascendingField;
      }//close RecipeBookComparator(...) constructor

      
      //compare method that is used to compare two recipes together
      public int compare(Object o1, Object o2) {
         Recipe r1 = (Recipe) o1, r2 = (Recipe) o2;
         //Make sure the recipes are not null before you start comparing
         //them.
         int compRecipeName, compServingSize, compTime;
         if (r1 != null && r2 != null) {
            switch (mSortField) {
               case 1:
                  // sort by recipe name, in ascending order.
                  compRecipeName = r1.getRecipeName().compareTo(
                   r2.getRecipeName());
                  return (mAscendingField) ? compRecipeName :
                   -1 * compRecipeName;
                 
               case 2:
                  //sort by servings in ascending order
                  compServingSize = r1.getServingNumber() -
                   r2.getServingNumber();
                  return (mAscendingField) ? compServingSize :
                   -1 * compServingSize;                    

               case 3:
                  //sort by time, in ascending order
                  compTime = r1.getTotalRecipeTime() - r2.getTotalRecipeTime();
                  return (mAscendingField) ?  compTime : -1 * compTime;     
            }//end switch
         }//end if
         return 0;
      }//close compare(...)

   }//close inner class RecipeBookComparator

}//close class RecipeBook


