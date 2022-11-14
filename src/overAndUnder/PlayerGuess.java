package overAndUnder;


import javax.swing.JOptionPane;

public class PlayerGuess {
	 
	private static int guess; 
	private static String guessString;
	

	
	public static void playerGuesses() {
	
	//Creates the options for the message to the player 
	String[] options = {"Higher", "Lower", "Exactly 7"};
	
	//Creates the question for the user 
	String guessQuestion = "What do you think the computer will roll?";
	
	//Asks the question to the user and assigns an integer value to guess 
	guess = JOptionPane.showOptionDialog(null, guessQuestion, Game.gameName, JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, options, null);
	
	
	//Adds a string value to the players guess 
	if (guess == 0) {
		setGuessString("higher");
	}
	
	if (guess == 1 ) {
		setGuessString("lower");	
	}
	
	if (guess == 2) {
		setGuessString("exactly 7");	
	}			
}
	
	//----------------------------------------------------------------------//
	//Getters and Setters 
	
	
	//Guess getters and setters
	public int getGuess() {
		return guess;
	}
	
	public void setGuess(int guess) {
		PlayerGuess.guess = guess; 
	}	
	
	//Guess String Getters and Setters 4
	
	public static void setGuessString (String guessString) {
		PlayerGuess.guessString = guessString;	
	}
	
	public String getGuessString() {
		return guessString;
	}
}
