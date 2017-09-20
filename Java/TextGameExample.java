/*
	Text Game Example
	Sean Curran
	
	This is a simple text-based game example to demonstrate the basic framework.
	Objects, threads and a GUI are omitted for simplicity.
	The purpose for this project is to teach the Bronxville Tech Club the basics of
	game design within the scope of the material we have covered.
	
	Fun text font thing: http://patorjk.com/software/taag/#p=display&f=Big&t=

*/

// Imports
import java.util.Scanner;

public class TextGameExample
{
	// Declare CLASS SCOPE variables
	// This means that ALL METHODS can access these variables
	public static Scanner s = new Scanner(System.in);
	
	// These three methods just display the fun text, adding a nice visual
	// touch to the game.
	public static void displayTitle()
	{
		System.out.println("");
		System.out.println(" _____         _      _____               ");
		System.out.println("|_   _|___ _ _| |_   |   __|___ _____ ___ ");
		System.out.println("  | | | -_|_'_|  _|  |  |  | .'|     | -_|");
		System.out.println("  |_| |___|_,_|_|    |_____|__,|_|_|_|___|");
		System.out.println("");
	}
	
	public static void displayEnd()
	{
		System.out.println("");
		System.out.println("                                                                         __ ");
		System.out.println(" _____ _           _          _____            _____ _         _        |  |");
		System.out.println("|_   _| |_ ___ ___| |_ ___   |   __|___ ___   |  _  | |___ _ _|_|___ ___|  |");
		System.out.println("  | | |   | .'|   | '_|_ -|  |   __| . |  _|  |   __| | .'| | | |   | . |__|");
		System.out.println("  |_| |_|_|__,|_|_|_,_|___|  |__|  |___|_|    |__|  |_|__,|_  |_|_|_|_  |__|");
		System.out.println("                                                          |___|     |___|   ");
		System.out.println("");
	}
	
	public static void displayGameOver()
	{
		System.out.println("");
		System.out.println(" _____                  _____             ");
		System.out.println("|   __|___ _____ ___   |     |_ _ ___ ___ ");
		System.out.println("|  |  | .'|     | -_|  |  |  | | | -_|  _|");
		System.out.println("|_____|__,|_|_|_|___|  |_____|\\_/|___|_|  ");
		System.out.println("");
	}
	
	// Display the text fo the game and gather input from the player,
	// sending that input back to the runGame method that calls
	// this method.
	public static int takeTurn(String[] choices)
	{
		String input = "";
		int playerChoice = 0;
		for(int i = 0; i < choices.length; i++)
		{
			if(i == 0)
			{
				System.out.println(choices[i]);
			}
			else
			{
				System.out.println(i + ". " + choices[i]);
			}
		}
		while(playerChoice < 1 || playerChoice > choices.length - 1)
		{
			input = s.nextLine();
			try
			{
				playerChoice = Integer.valueOf(input);
				if(playerChoice < 1 || playerChoice > choices.length - 1)
				{
					System.out.println("Please enter a valid input");
				}
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid input");
			}
		}
		return playerChoice;
	}

	/*
		Modify this method to create your own game
		To have more decisions, just create more dialogue arrays
		If statements are your friend too
		To get a game over, call the displayGameOver method and
		return nothing. This will exit the game
		To tell the user they won, just do a S.O.P saying that they won
		and return nothing. 
	*/
	public static void runGame()
	{
		int decision;
		// Array containing the dialogue to display on the screen
		// More lines may be added for more choices
		// The first line sets the scene
		String[] dialogue1 = {
			"You find a dog. What do you do?",
			"Pet the dog",
			"Kick the dog",
			"Leave the dog alone",
			"Toss the dog a treat"
		};
		// Get the response from the player
		decision = takeTurn(dialogue1);
		// Check which response they picked and tell them what happened
		if(decision == 1)
		{
			System.out.println("The dog bites you. You get rabies and die.");
			displayGameOver();
			return;
		}
		else if(decision == 2)
		{
			System.out.println("The dog goes flying. The owner shoots you. You die.");
			displayGameOver();
			return;
		}
		else if(decision == 3)
		{
			System.out.println("The dog wanted attention so it bites you. You get rabies and die.");
			displayGameOver();
			return;
		}
		else if(decision == 4)
		{
			System.out.println("The dog happily eats the treat and leaves you alone.");
			System.out.println(/*This is a blank space. It makes the output look nicer*/);
		}
		else
		{
			System.out.println("Something went wrong...");
			return;
		}
		// Next series of dialogue
		String[] dialogue2 = {
			"The owner approaches you and shouts \"WHAT ARE YOU DOING TO MY DOG??\"",
			"\"I...\"",
			"\"Uh...\"",
			"\"He...\"",
			"Run",
			"Punch him"
		};
		decision = takeTurn(dialogue2);
		if(decision == 1)
		{
			System.out.println("The owner ignores your blabbering and shoots you. You die.");
			displayGameOver();
			return;
		}
		else if(decision == 2)
		{
			System.out.println("The owner ignores your blabbering and shoots you. You die.");
			displayGameOver();
			return;
		}
		else if(decision == 3)
		{
			System.out.println("The owner ignores your blabbering and shoots you. You die.");
			displayGameOver();
			return;
		}
		// This is how to handle multiple successful options
		// It could get messy quick... Just be careful with
		// your curly brackets and you should be fine
		else if(decision == 4)
		{
			System.out.println("The owner is too slow to react and you get away.");
			System.out.println();
			String[] dialogue3 = {
				"You keep running when suddenly you approach a cliff",
				"Try to stop",
				"Jump",
				"Scream"
			};
			decision = takeTurn(dialogue3);
			if(decision == 1)
			{
				System.out.println("There is not enough ground left. You fall to your demise.");
				displayGameOver();
				return;
			}
			else if(decision == 2)
			{
				System.out.println("You jump off the cliff and fall to your demise.");
				displayGameOver();
				return;
			}
			else if(decision == 3)
			{
				System.out.println("Screaming did not help you. You fall to your demise.");
				displayGameOver();
				return;
			}
			else
			{
				System.out.println("Something went wrong...");
				return;
			}
		}
		else if(decision == 5)
		{
			System.out.println("The owner is stunned.");
			System.out.println();
			String[] dialogue3 = {
				"The dog comes back, angry that you assaulted his owner",
				"\"Nice doggy...\"",
				"\"How was that treat?\"",
				"\"Good boy...?\""
			};
			decision = takeTurn(dialogue3);
			if(decision == 1)
			{
				System.out.println("The dog bites you. You get rabies and die.");
				displayGameOver();
				return;
			}
			else if(decision == 2)
			{
				System.out.println("The dog bites you. You get rabies and die.");
				displayGameOver();
				return;
			}
			else if(decision == 3)
			{
				System.out.println("The dog bites you. You get rabies and die.");
				displayGameOver();
				return;
			}
			else
			{
				System.out.println("Something went wrong...");
				return;
			}
		}
		else
		{
			System.out.println("Something went wrong...");
			return;
		}
	}

	public static void main(String[] args)
	{
		// Call method to type out the cool text
		displayTitle();
		
		// Call method to actually run the game
		runGame();
		
		// Actions taken at the end of the game
		displayEnd();
	}
}
