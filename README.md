# Scrabble Word Recommender

Recommend a list of words in the order of maximum score based on the players' tiles with/without board constraints. 

#### Base Engine 
This module creates the data structure from the dictionary, pre-compute scores for each word, implements method to find list of possible words and handles user interactions.

##### Team 
1. Aravind. A. R - *Create the data structure from the dictionary words and method to compare the input rack*
2. Aravind Srivatsan - *Create method to calcuate scores for each of the dictionary words*
3. Asra Yousuf - *Input formatting and interactions with players*

#### Handling Blank Input Tiles 
This module handles the blank input tiles and computes the score for the blank tiles to be subtracted.
##### Team 
1. Mohanish Golatkar - *Create the bsae structure of Blank Handling class and the sortRack() funtion*
2. Neel Paratkar - *Write the method which calculates the score when blank  tile is present in the rack*
3. Sri Harish - *Create the Blank Handling functions that checks if blanks present,get count and remove blanks*

#### Handling Input Constraints from Board
This module handles the constraints from the board such as letter positioning and maximum length of  the word.  
##### Team
1. Jayasruthi - *Convert the constraint to a regex for letter positioning and/or word length*
2. Shravan Venkataraman - *Match output with the constraint pattern*
3. Ekansh Mittal - *Generate new rack for board constraints*
