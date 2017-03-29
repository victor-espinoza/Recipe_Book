/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

import java.util.*;
import java.io.*;

public class RecipeLoader {

   private final Scanner mFileScanner;

   public RecipeLoader(String fileName) throws IOException {
      mFileScanner = new Scanner(new FileReader(fileName));
      mFileScanner.useDelimiter("\n|\\|");
   }//close RecipeLoader

   public Recipe readNextRecipe() {
      // format:
      // name|descr|serves|prep|cook|ingredient1@ingredient2@...|step1@step2@...
      if (mFileScanner.hasNext()) {
         String name = mFileScanner.next();
         String descr = mFileScanner.next();
         int servs = mFileScanner.nextInt();
         int prep = mFileScanner.nextInt();
         int cook = mFileScanner.nextInt();

         String[] ingredients = mFileScanner.next().split("@");
         String[] steps = mFileScanner.next().split("@");
         return new Recipe(name, descr, servs, prep, cook, ingredients, steps);
      }//end if
      return null;
   }

   public static void main(String[] args) throws IOException {
      RecipeLoader loader = new RecipeLoader("test.txt");
      System.out.println(loader.readNextRecipe());
      System.out.println(loader.readNextRecipe());
   }//close main(...)
}//close class RecipeLoader
