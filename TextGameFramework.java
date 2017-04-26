/*
	Text Game Example
	Sean Curran
	
	This is a simple text-based game framework to be modified by students,
	allowing them to create their own game.
	Objects, threads and a GUI are omitted for simplicity.
	The purpose for this project is to teach the Bronxville Tech Club the basics of
	game design within the scope of the material we have covered.
	
	Fun text font thing: http://patorjk.com/software/taag/#p=display&f=Big&t=

*/

// Imports
import java.util.Scanner;

public class TextGameFramework
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
			"SCENARIO",
			"Option 1",
			"Option 2",
			"Option 3",
			"Option 4"
		};
		// Get the response from the player
		decision = takeTurn(dialogue1);
		// Check which response they picked and tell them what happened
		if(decision == 1)
		{
			System.out.println("Reaction 1 FAIL");
			displayGameOver();
			return;
		}
		else if(decision == 2)
		{
			System.out.println("Reaction 2 FAIL");
			displayGameOver();
			return;
		}
		else if(decision == 3)
		{
			System.out.println("Reaction 3 FAIL");
			displayGameOver();
			return;
		}
		else if(decision == 4)
		{
			System.out.println("Reaction 4 SUCCESS");
			System.out.println(/*This is a blank space. It makes the output look nicer*/);
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
