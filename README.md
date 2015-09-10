# example_roulette
Program to refactor that plays a game of roulette

Logan Rooper  ler24
Andrew Buie   ajb93

In what ways is the refactored code simpler?
  The refactored code removes much of the gameplay from the main ```Game.java``` class and moves it to the classes of the individual bets. Additionally, the refactored code is significantly more extensible and after refactoring, the addition of three new bet types was very easy.

In what ways is the refactored code more complex?
  The refactored code is more complex in that, in order for someone to manipulate it, they need to have an understanding of interfaces and abstract classes in Java.

What trade-offs did you make when refactoring your old code?
  We traded adding additional complexity in class structure to enable us to make the program more modifiable while eliminating an excess usage of conditional statements.

Which code do you prefer and why?
  We prefer the new code because it's easier to modify to add additional functionality.