/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

import java.io.IOException;
import java.util.*;

public class RecipeProgram {

   //constant variables used throughout the program
   private static final int EXIT_LOOP = 8;
   private static final int SORT_FIELD_LIMIT = 4;
   private static final int ASCENDING_FIELD_LIMIT = 3;
   private static final int ASCENDING = 1;
   private static final int SORT_BY_NAME = 1;
   private static final int SORT_BY_SERVINGS = 2;
   private static final int SORT_BY_TIME = 3;
   private static final int DESCENDING = 2;
 
   public static void main(String[] args) {
      // TODO code application logic here
      // TODO code application logic here
      RecipeBook myRecipeBook = new RecipeBook();
      Scanner in = new Scanner(System.in);
      int sortField = 0;
      boolean ascendingOrDescending = true;

      int menuChoice;
      do {
         //display main menu and prompt user for their selection
         menuChoice = mainMenuPrompt(in);
         
         switch (menuChoice) {
            case 1:
               //Load a recipe file
               System.out.println("Please enter the name of a "
                + "recipe database file:");
               in.nextLine();
               String recipeFileName = in.nextLine();
               RecipeLoader loadRecipe = null;
               //try to open the filename given
               try {
                  loadRecipe = new RecipeLoader(recipeFileName);
               }//end try
               catch (IOException ex) {
                  System.out.println("Could not open the file "
                   + recipeFileName);
               }//end catch
               
               //add contents of file into the Recipe Book
               int recipeIndex = 0;
               if (loadRecipe != null) {
                  Recipe r = loadRecipe.readNextRecipe();
                  while (r != null) {
                     myRecipeBook.add(r);
                     r = loadRecipe.readNextRecipe();
                     recipeIndex++;
                  }//end while
               }//end if
               
               if (loadRecipe != null && recipeIndex >= 0) {
                  System.out.println("Loaded " + recipeIndex +
                   ((recipeIndex == 1) ? " recipe!" : " recipes!"));
               }//end if
 
               break;

            case 2:
               //Save a recipe file
               System.out.println("\nPlease enter the name of the file "
                + "to save to:");
               in.nextLine();
               String fileName = in.nextLine();
               //construct a RecipeWriter object
               try {
                  RecipeWriter writer = new RecipeWriter(fileName);
                  int i = 0;
                  //add each recipe in the Recipe Book to the RecipeWriter
                  for (Object g: myRecipeBook) {
                     Recipe writeRecipe = (Recipe) g;
                     writer.writeRecipe(writeRecipe);
                     i++;
                  }//close for loop
                  
                  System.out.println("Saved " + i + ((i==1) ? " recipe!" : 
                   " recipes!"));

                  writer.close();
               }//end try
               catch(IOException ex) {
                  System.out.println(ex);
               }//end catch
               break;

            case 3:
               //print all of the recipe names in your recipe book
               System.out.println("\nAll " + myRecipeBook.getCount()
                + " recipes:");
               for (int i = 0; i < myRecipeBook.getCount(); i++) {
                  Recipe recipe = myRecipeBook.get(i);
                  if ( recipe != null)
                     System.out.println(recipe.getRecipeName());
               }//close for loop
               break;
               
            case 4:
               //show recipe details
               System.out.println("Please enter a recipe name:");
               in.nextLine();
               String desiredRecipeName = in.nextLine();
               Recipe recipeDetails = myRecipeBook.searchByName(
                desiredRecipeName);
               System.out.print((recipeDetails != null) ? 
                ("\nRecipe:\n" + recipeDetails) : "Could not find a recipe "
                + "with that name\n" );
               break;

            case 5:
               //Removes a recipe
               System.out.println("Please enter a recipe name:");
               in.nextLine();
               String recipeToRemove = in.nextLine();
               Recipe desiredRecipe = myRecipeBook.searchByName(
                recipeToRemove);
               if (desiredRecipe != null) {
                  myRecipeBook.remove(desiredRecipe);
                  System.out.println("Recipe removed");
               }//end if
               else
                  System.out.println("Could not find a recipe with "
                   + "that name");
               break;

            case 6:
               //Checks to see if a recipe has a given ingredient
               in.nextLine();
               System.out.println("Please enter an ingredient name:");
               String ingredientInput = in.nextLine();
               List usesIngredient = myRecipeBook.searchByIngredient(
                ingredientInput);
               if (usesIngredient.get(0) != null) {
                  if (usesIngredient.getCount() == 1)
                     System.out.println("This recipe uses that ingredient:");
                  else
                     System.out.println("These recipes use that ingredient:");
                  //print out recipes that use the ingredient
                  for (Object g: usesIngredient) {
                     Recipe Recipe = (Recipe) g;
                     System.out.println(Recipe.getRecipeName());
                  }//close for loop
               }//end if
               else
                  System.out.println("No recipes use that ingredient");
               break;

            case 7:
               //Sort recipe book
               in.nextLine();
               String sortType = "Sorted recipes by";
               //ensure that the sortField is within the appropriate range.
               do {
                  System.out.println("Please choose a sort field - name (1), "
                   + "servings (2), or time (3): (Enter integer number)");
                  try {
                     sortField = in.nextInt();
                  }//end try
                  catch (InputMismatchException e) {
                     in.next();
                  }//end catch
               } while (sortField <= 0 || sortField >= SORT_FIELD_LIMIT);
               //end do

               //add appropriate words to the sortType string
               if (sortField == SORT_BY_NAME)
                  sortType += " name in";
               else if (sortField == SORT_BY_SERVINGS)
                  sortType += " servings in";
               else if (sortField == SORT_BY_TIME)
                  sortType += " time in";

               //ensure that the ascendingField is within the
               //appropriate range.
               int ascendingField = 0;
               do {
                  System.out.println("Ascending (1) or Descending (2) order" +
                   ": (Enter integer number)");
                  try {
                     ascendingField = in.nextInt();
                     if (ascendingField == ASCENDING)
                        ascendingOrDescending = true;
                     if (ascendingField == DESCENDING)
                        ascendingOrDescending = false;
                  }//end try
                  catch (InputMismatchException e) {
                     in.next();
                  }//end catch
               } while (ascendingField <= 0 || ascendingField >=
                ASCENDING_FIELD_LIMIT); //end do 

               //add appropriate words in the sortType string
               if (ascendingField == ASCENDING)
                  sortType += " ascending order";
               if (ascendingField == DESCENDING)
                  sortType += " descending order";
               
               //sort the recipe book and print out the sortType string
                myRecipeBook.sortBook(sortField, ascendingOrDescending);
               System.out.println(sortType);
               break;
         }//close switch
      } while (menuChoice != EXIT_LOOP);
      //end do

      System.out.println("\nThe program will now terminate. Enjoy the rest " +
       "of your day!");
   }//close main
   
   
   //Main Menu prompt for the user
   public static int mainMenuPrompt(Scanner in){
		int userChoice;
			
		//Prompt user to select a choice
		do {		
			System.out.println("\n" + "Main Menu:\n1. Load recipe file\n" +
          "2. Save recipe file\n3. Show all recipe names\n" +
          "4. Show recipe details\n5. Remove a recipe\n6. Find ingredient\n" +
          "7. Sort recipes\n8. Exit");
         
         System.out.println("Please enter a selection:");
					
			//make sure the input is a number
			while (!in.hasNextInt()) {
				System.out.println("Please Enter An INTEGER NUMBER Between 1-8!");
            System.out.println("\n" + "Main Menu:\n1. Load recipe file\n" +
             "2. Save recipe file\n3. Show all recipe names\n" +
             "4. Show recipe details\n5. Remove a recipe\n6. Find ingredient" +
             "\n7. Sort recipes\n8. Exit");
				in.next(); //advance the scanner for the next input attempt
			}//end inner while loop
							
			userChoice = in.nextInt();	
					
			//inform the user if the number entered is invalid
			if(userChoice<1 || userChoice>8)
				System.out.println("Please Enter An Integer Number Between 1-8!");				
		} while(userChoice<1 || userChoice>8); //end do
					
		return userChoice;		
	}//close mainMenuPrompt(...)
    
}//close class RecipeProgram