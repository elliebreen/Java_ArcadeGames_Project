# Java_ArcadeGames_Project
Arcade Games project, with persistent leaderboard created as part of the java module at university.


The project implements a simple gaming system which is executed by running the Main class file. 
The package consists of a Game class with subclasses, RockPaperScissors and CoinToss, 
a Player class with VIPPlayer and LimitedPlayer and finally a Leaderboard which displays the leader board for the games.
The Game class makes use of inheritance by creating methods that are generic to all games such as StartUp, MainMethod and getChoice, which gets the users choice. 
It also has a playGame method which plays one of the subclass games chosen.

The Player method demonstrates the use of access modifiers, inheritance, encapsulation, and polymorphism. 
Each player has private attributes which are accessed through getter and setter methods. 
The subclasses inherit these attributes and when instantiated, set their corresponding turnLimits. 
The VIPPlayer class also has a toString method which overrides the super class method, demonstrating polymorphism at play. When a player is instantiated,
it is added to an array list of players and each player is appended to the leader board text file after each session.
Finally, the leader board class implements a sorted leader board. It reads the leader board text file into a string.
The string is then split into an array of strings, each index corresponding to a user. 
Each index is then split whereby the name is added as the key and the points are the value in the HashMap. 
This HashMap is then converted into a list to be compared and sorted and then printed.

To play the game run the Main file and enjoy!
