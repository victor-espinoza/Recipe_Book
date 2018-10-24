Project Overview:   
This program allows the user to load text files containing recipes, view recipe names within the session, display recipe information, search for a recipe by its ingredients, delete recipes, and save recipes to a text file.   
     
In this project I store the recipes within the RecipeBook as elements in an ArrayList which implements the List interface. When a user starts a session by running the program, they can upload recipe's to the Recipe Book by loading a text file filled with recipes to the program. The program goes through and adds each recipe present in the text file to the Recipe Book. Once the recipes are loaded, the user can then view a recipe's details, search for recipes by ingredients, delete a recipe, save the recipes in the Recipe Book to a text file, sort the recipes, and exit the program.  
     
When searching for a recipe by name, the program will use a binary search if the ArrayList is already sorted and it will use a linear search if the ArrayList is not sorted. This is done in order to increase the efficiency of the program when the Recipe Book is sorted by using a binary search, which excels at finding desired information quickly when the elements are sorted properly.  
       
Included in the Recipe_Book_Implementation Repository are two major text files containing recipes. Recipes1.txt contains 4 simple recipes that the user can view. Recipes2.txt contains different recipes that each student in the class submitted. In total, Recipes2.txt has 55 recipes that the user can browse through. The other text files contain either a single recipe or they are a result of saving the RecipeBook to a text file.  
     
The user can also add recipes to a text file and upload that file to the program as long as it maintains the proper recipe format so that it is loaded correctly.   
  
The format is as follows:  
Recipe_Name|Recipe_Description|Serving_Size|Prep_Time|Cooking_Time|Ingredients_Separated_by_@_Symbol|Recipe_Steps_Separated_by_@_Symbol  
  
Here is an example of a recipe using this format:  
Cereal with milk|Best breakfast ever.|1|1|0|Your favorite cereal@1 cup 2% milk|Pour cereal into bowl.@Pour milk over cereal.@Enjoy.@  
   
For a good example of how to use this program, make sure to check out the Sample Output section below!  
   
  
Dependencies:   
This project was created using NetBeans IDE Version: 8.0.2.  
  
  
Sample Output:  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
1  
Please enter the name of a recipe database file:  
Recipes1.txt  
Loaded 4 recipes!  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
3  
  
All 4 recipes:  
Neal's Guacamole  
Cereal with milk  
Bacon-stuffed avocado  
Lazy Scrambled Eggs  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
4  
Please enter a recipe name:  
Bacon-stuffed avocado  
  
Performing linear search...  
  
Recipe:  
Bacon-stuffed avocado  
Short, easy, and combines two sinful delights. From avocadorecipes.net  
2 servings  
5 minutes prep, 10 minutes cooking  
  
Ingredients:  
4 medium avocados, ripe, unpeeled  
8 slices bacon, cooked cris,p crumbled  
Lemon juice, as needed  
1/2 cup butter  
1/4 cup brown sugar  
1/4 cup white wine vinegar  
1/4 cup garlic puree/paste  
1/2 teaspoon salt  
  
Steps:  
Slice avocados in half lengthwise; scoop out only half of the avocado flesh from each piece, leaving a small bowl of flesh in each.  
Place scooped avocado in a medium bowl; add bacon and mash gently.  
Spoon mixture back into each avocado half. Brush with lemon juice to prevent browning.  
Combine remaining ingredients in a small sauce pan; bring to a boil over medium-high heat, stirring occasionally.  
Whisk mixture until smooth; pour over filled avocado halves. Serve immediately.  
  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
7  
Please choose a sort field - name (1), servings (2), or time (3): (Enter integer number)  
fsda  
Please choose a sort field - name (1), servings (2), or time (3): (Enter integer number)  
1  
Ascending (1) or Descending (2) order: (Enter integer number)  
1  
Sorted recipes by name in ascending order  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
3  
  
All 4 recipes:  
Bacon-stuffed avocado  
Cereal with milk  
Lazy Scrambled Eggs  
Neal's Guacamole  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
4  
Please enter a recipe name:  
Lazy Scrambled Eggs  
  
Performing binary search...  
  
Recipe:  
Lazy Scrambled Eggs  
Easy way of making scrambled eggs.  
2 servings  
2 minutes prep, 5 minutes cooking  
  
Ingredients:  
2-3 eggs per person  
2 tablespoons milk for every 3 eggs  
1 tablespoon butter for every 3 eggs  
Salt  
Pepper  
1 avocado (optional)  
  
Steps:  
Crack eggs directly into a cold frying pan. Add milk and butter; salt and pepper to taste.  
Turn heat on low, and break up eggs with spatula. Stir slowly.  
Cook until eggs are still "wet" but firm. Plate and top with sliced avocado.  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
6  
Please enter an ingredient name:  
avocado  
These recipes use that ingredient:  
Bacon-stuffed avocado  
Lazy Scrambled Eggs  
Neal's Guacamole  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
5  
Please enter a recipe name:  
Lazy Scrambled Eggs  
  
Performing binary search...  
Recipe removed  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
3  
  
All 3 recipes:  
Bacon-stuffed avocado  
Cereal with milk  
Neal's Guacamole  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
;fjasd  
Please Enter An INTEGER NUMBER Between 1-8!  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
2  
  
Please enter the name of the file to save to:  
Updated_Recipes.txt  
Saved 3 recipes!  
  
Main Menu:  
1. Load recipe file  
2. Save recipe file  
3. Show all recipe names  
4. Show recipe details  
5. Remove a recipe  
6. Find ingredient  
7. Sort recipes  
8. Exit  
Please enter a selection:  
8  
  
The program will now terminate. Enjoy the rest of your day!  
  
  
    
