/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 11/15/13
 * Project 3: A Rare Medium Well Done
 */

import java.io.*;
import java.io.PrintStream;

public class RecipeWriter {
   private final PrintStream mWriter;

   public RecipeWriter (String fileName) throws IOException {
      mWriter = new PrintStream(fileName, "UTF-8");
   }//close public RecipeWriter

   public void writeRecipe(Recipe r){
      String finalRecipe = r.getRecipeName() + "|" + r.getDescription() + "|"
       + r.getServingNumber() + "|" + r.getPrepTime() + "|" + r.getCookTime()
       + "|";

      //adds the ingredients to your string
      for (int i = 0; i < r.getIngredients().length; i++) {
         String ingredient = r.getIngredients()[i];
         if (ingredient != null) {
            finalRecipe += (i==0) ? ingredient : ("@" + ingredient);
         }//end if
      }//close for loop

      finalRecipe += "|";
      //adds the instructions to your string
      for (int i = 0; i < r.getInstructions().length; i++) {
         String instruction = r.getInstructions()[i];
         if (instruction != null) {
            finalRecipe += (i==0) ? instruction : ("@" + instruction);
         }//end if
      }//close for loop

      mWriter.println(finalRecipe);
   }//close writeRecipe

   public void close(){
      mWriter.close();
   }//close method close

}//close class RecipeWriter

