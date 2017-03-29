/*Victor Espinoza
 * CECS 274
 * Fall 2013
 * Due Date: 12/18/13
 * Project #4 - Still Haven't Found What I'm Looking For
 */

public class Recipe {

   private String mRecipeName, mDescription;
   private int mServingNumber, mPrepTime, mCookTime;
   private String[] mIngredients;
   private String[] mInstructions;
   private int mIngredientCount, mInstructionsCount;

   //Recipe constructor
   public Recipe(String name, String recipeDescription, int servingNum,
    int prepareTime, int cookingTime, String[] recipeIngredients,
    String[] recipeInstructions) {
      //initialize variables accordingly
      mRecipeName = name;
      mDescription = recipeDescription;
      mServingNumber = (servingNum>0) ? servingNum : 1;
      mPrepTime = (prepareTime>=0) ? prepareTime : 0;
      mCookTime = (cookingTime>=0) ? cookingTime : 0;
      mIngredients = recipeIngredients;
      mInstructions = recipeInstructions;
   }//close Recipe(...) constructor

   
   //Get the recipe name
   public String getRecipeName() {
      return mRecipeName;
   }//close getRecipeName()
   
   
   //Set the recipe name
   public void setRecipeName(String newName) {
      this.mRecipeName = newName;
   }//close setRecipeName(...)

   
   //Get the recipe description
   public String getDescription() {
      return mDescription;
   }//close getDescription()

   
   //Set the recipe description
   public void setDescription(String newDescription) {
      this.mDescription = newDescription;
   }//close setDescription(...)

   
   //Get the servings number for the recipe
   public int getServingNumber() {
      return mServingNumber;
   }//close getServingNumber()

   
   //Set the servings number for the recipe
   public void setServingNumber(int newServingNumber) {
      if (newServingNumber>0)
         this.mServingNumber = newServingNumber;
   }//close setServingNumber(...)

   
   //Get the preparation time for the recipe
   public int getPrepTime() {
      return mPrepTime;
   }//close getPrepTime()

   
   //Set the preparation time for the recipe
   public void setPrepTime(int newPrepTime) {
      if (newPrepTime >= 0)
         this.mPrepTime = newPrepTime;
   }//close setPrepTime(...)

   
   //Get cooking time for recipe
   public int getCookTime() {
      return mCookTime;
   }//close getCookTime()

   
   //Set the cooking time for the recipe
   public void setCookTime(int newCookTime) {
      if (newCookTime >= 0)
         this.mCookTime = newCookTime;
   }//close setCookTime(...)
   
   
   //Get the ingredients for the recipe
   public String[] getIngredients() {
      return mIngredients;
   }//close getIngredients()

   
   //Set the ingredients for the recipe
   public void setIngredients(String[] newIngredients) {
      this.mIngredients = newIngredients;
   }//close setIngredients(...)
   
   
   //Get the recipe instructions
   public String[] getInstructions() {
      return mInstructions;
   }//close getInstructions()

   public void setInstructions(String[] newInstructions) {
      this.mInstructions = newInstructions;
   }//close setInstructions(...)

   
   //Override the toString method to display the recipe as desired
   @Override
   public String toString() {
      //add recipe name and servings number to output
      String finalRecipe = mRecipeName + System.getProperty("line.separator")
       + mDescription + System.getProperty("line.separator") + mServingNumber;
      //add serving size annotation to output
      finalRecipe+= (mServingNumber==1) ? " serving" :  " servings";
      //add preptime and its proper annotation to output
      finalRecipe+= System.getProperty("line.separator") + mPrepTime;
      finalRecipe+= (mPrepTime==1) ? " minute prep, ": " minutes prep, ";
      //add cooktime and its proper annotation to output
      finalRecipe+= mCookTime;   
      finalRecipe+= (mCookTime==1) ? " minute cooking" : " minutes cooking";
      //add new-lines and ingredients header to output
      finalRecipe+= System.getProperty("line.separator")
       + System.getProperty("line.separator") + "Ingredients:"
       + System.getProperty("line.separator");
       
      //add the ingredients in recipe to output.
      for (String mIngredient : mIngredients) 
         finalRecipe += mIngredient + System.getProperty("line.separator");
           
      //add new-lines and steps header to output
      finalRecipe += System.getProperty("line.separator") + "Steps:"
       + System.getProperty("line.separator");
      
      //add the instructions in recipe to output
      for (String mInstruction : mInstructions) 
         finalRecipe += mInstruction + System.getProperty("line.separator");

      //return the string representation of the recipe in the desired format.
      return finalRecipe;
   }//close toString()

   
   //Get the number of ingredients in the recipe
   public int getIngredientCount() {
      for (String mIngredient : mIngredients) 
         if (mIngredient != null) 
            mIngredientCount++;
      return mIngredientCount;
   }//close getIngredientCount()

   
   //Get the number of steps in the recipe
   public int getStepCount() {
      for (String mInstruction : mInstructions) 
         if (mInstruction != null)
            mInstructionsCount++;
      return mInstructionsCount;
   }//close getStepCount()

   
   //Get the total amount of time needed to complete the recipe
   public int getTotalRecipeTime() {
      return mCookTime + mPrepTime;
   }//close getTotalRecipeTime()

   
   //Check to see if a recipe has a certain ingredient (case insensitive)
   public boolean hasIngredient(String recipeIngredient) {
      boolean containsIngredient = false;
      for (String mIngredient : mIngredients)
         if (mIngredient.toLowerCase().contains(recipeIngredient.toLowerCase()
          )) {
            containsIngredient = true;
            break;
         } //end if
      return containsIngredient;
   }//close hasIngredient(...)

}//close public class Recipe