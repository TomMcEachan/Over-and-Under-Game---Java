package overAndUnder;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import overAndUnder.Player;

public class Game  {
	
	
//---------------------------------------------------------------------------------------------------------------//
	//Global variables 
	final public static String gameName = "Over and Under";
	public boolean gameOver;
	private boolean answerRight;
	private  boolean playerGoesAgain;
	


	//Creating the icons for the game
	static ImageIcon overAndUnderIcon = new ImageIcon("overAndUnder.png");
	
	//ArrayList
	public static ArrayList <Integer> diceData = new ArrayList <> (5);
	public static ArrayList <String> guessData = new ArrayList<>(5);
	public static ArrayList <Integer> playerTurn = new ArrayList<>(5);
	
	//Creating the main player objects for the Game -- null as player input is needed
	public static Player player1 = new Player (null, null, null, null, 0, 0, 0, 0);
	public static Player p1HighScore = new Player(null, 0);
	public static PlayerGuess p1Guess = new PlayerGuess ();
	public static Game newGame = new Game();
	public static Dice dice = new Dice(0);
	public static LeagueTable leagueTable = new LeagueTable();
	
	//Setting the players statistics at the beginning of the game 
	public void playerStartStats () {
		player1.setPlayerTurns(5);
		player1.setNumberOfBets(0);
		player1.setMoneyInBank(3);
		player1.setWins(0);
		player1.setTurn(0);
	} 
	
	
	//Creates an instance of the stake object 
	Stake player1Stake = new Stake (0, 0, 0); // -- null as player input is needed 
	
	//This displays the game start method and allows the player to change the stake if they would like to
	public void gameStarts() {
		String[] options = {"START", "CHANGE STAKE", "CANCEL"};
		int choice;
		String output = "...a guessing game";
		choice = JOptionPane.showOptionDialog(null, output, gameName, JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE, overAndUnderIcon, options, options[0]);
		
		
		if (choice == 1) { // if the the player has decided to change the stake -- continue game
		} else if (choice == 2) { // the player has decided to cancel the game
			System.exit(0);
		}
	}
	
	/*	This method allows the user to choose a stake an assigns a 
	integer value to a variable so that it can be set	 */
	
	public void chooseStake() {
		String[] options = {"Normal odds", "Up the odds", "I've got money to burn"};
		int modeChoice;
		String output =  "There are 3 modes to chose from:\n\n"
					   + "Normal odds:\n"
					   + "- a turn costs £1\n"
					   + "- if you guess higher or lower and get it right you win £2\n"
					   + "- if you guess exactly 7 and get it right you win £5\n\n"
					   + "Up the odds:\n"
					   + "- a turn costs £2\n"
					   + "- if you guess higher or lower and get it right you win £4\n"
					   + "- if you guess exactly 7 and get it right you win £10\n\n"
					   + "Money to burn:\n"
					   + "- a turn costs £3\n"
					   + "- if you guess higher or lower and get it right you win £6\n"
					   + "- if you guess exactly 7 and get it right you win £15\n\n"
					   + "Which option do you pick?"; 
		
		modeChoice = JOptionPane.showOptionDialog(null, output, gameName,JOptionPane.YES_NO_CANCEL_OPTION
				, JOptionPane.PLAIN_MESSAGE, overAndUnderIcon, options, options[0]);
		
		
		//This else-if statement assigns the stake to the game based upon the users choice
		if (modeChoice == 0) {
			player1Stake.setTakeTurnMoney(1);
			player1Stake.setStakeWin2(2);
			player1Stake.setStakeWin5(5);
		} else if (modeChoice == 1) {
			player1Stake.setTakeTurnMoney(2);
			player1Stake.setStakeWin2(4);
			player1Stake.setStakeWin5(10);
		} else if (modeChoice == 2) {
			player1Stake.setTakeTurnMoney(3);
			player1Stake.setStakeWin2(6);
			player1Stake.setStakeWin5(15);
		} 
		
		String modeChoiceOutput = "Okay your stakes are:\n\n"
								+ "Turn cost: £" + player1Stake.getTakeTurnMoney() + "\n"
								+ "Win (higher/lower): £" + player1Stake.getStakeWin2() + "\n" 
								+ "Win (exactly 7):   £" + player1Stake.getStakeWin5() + "\n\n" 
								+ "Do you want to play the game with these stakes?";
		
		int choiceConfirm = JOptionPane.showConfirmDialog(null, modeChoiceOutput, gameName, 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, overAndUnderIcon);
		
		if (choiceConfirm != 0 ) {
			System.exit(0);
		} 
		
	}
	
	//--------------------------------------------------------------------------------------------------------//
	
	//This method takes one turn away from the player
		public void takeTurn() {
			player1.setPlayerTurns(player1.getPlayerTurns() - 1); //Takes a turn from players amount of turns
			player1.setTurn(player1.getTurn() + 1); // Adds a turn to the turn counter 
		}
			
		public void takeStake() {
			player1.setMoneyInBank(player1.getMoneyInBank() - player1Stake.getTakeTurnMoney());	
		}
			
	//If the player guesses correctly they win 2 -- if the player changes stake, this becomes is a multiple of 2
		public void playerWins2() {
			player1.setMoneyInBank(player1.getMoneyInBank()+ player1Stake.getStakeWin2());	
		}
			
	//If the player guesses correctly they win 5 -- if the player changes stake, this becomes is a multiple of 5
		public void playerWins5() {
			player1.setMoneyInBank(player1.getMoneyInBank()+ player1Stake.getStakeWin5());
		}	
	
	//--------------------------------------------------------------------------------//
	public void gameRules() {
		
		int userUnderstands;
		String outputRules = "The aims of the game are simple!\n"
							+ "You must guess if the computer will roll higher, lower or exactly 7.\n"
							+ "If you guess what the computer rolls - you win!"
							+ "\n\n"
							+ "1.If you guess correctly and the computer rolled higher or lower you win money\n"
							+ "2.If you guess correctly and the computer rolled exactly 7 you win even more money\n"
							+ "3.If you guess incorrectly you win nothing! :(\n"
							+ "4.You have 5 turns per game\n"
							+ "5.Your name will be displayed on a leaderboard at the end of the game\n\n"
							+ "Do you want to play the game?";
		
		//This outputs the rules to the user 
		userUnderstands = JOptionPane.showConfirmDialog(null, outputRules, gameName, 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, overAndUnderIcon);
		
		if (userUnderstands != 0 ) {
			System.exit(0);
		} 
	}
	
	//-----------------------------------------------------------------------------------------------//
	public void gameInfo() {	
	//This creates the new player 
	player1.PlayerInfo();	
	}

	//----------------------------------------------------------------------------------------------//
	public void gamePlay() {
	
	PlayerGuess.playerGuesses();
	
	//Creating new instance of a the dice roll object
	Dice d1 = new Dice (0, 0);
	
	//The computer rolls the dice and the player takes a turn
	d1.diceRoll();
	takeTurn();
	takeStake();
		
	//This else-if statement checks if the user has won the round or not 
	if (p1Guess.getGuess() == d1.getRollComparison()) {
		String output = "Well done - you guessed " + p1Guess.getGuessString() + " and got it it right!";
		JOptionPane.showMessageDialog(null, output, gameName, JOptionPane.INFORMATION_MESSAGE);
		setAnswerRight(true);
		player1.setWins(player1.getWins() + 1); //player wins code ends
	} else if (p1Guess.getGuess() != d1.getRollComparison()) {
		String output = "You guessed " + p1Guess.getGuessString() + " and didn't get it right :( !";
		JOptionPane.showMessageDialog(null, output, gameName, JOptionPane.INFORMATION_MESSAGE);
		setAnswerRight(false); //player loses code ends 
	}
	
	
	
	// This else-if statement assigns the correct amount of money to the user depending on the win status
	if (p1Guess.getGuess() == 0 && isAnswerRight() == true) {
		playerWins2();
	} else if (p1Guess.getGuess() == 1 && isAnswerRight() == true) {
		playerWins2();
	} else if (p1Guess.getGuess() == 2 && isAnswerRight() == true) {
		playerWins5();
	}
	
	//This is a statistics tracker message which will display every time the user takes a turn 
	String statsTracker = player1.getPlayerAlias() + " you have...\n\n"
						+ "Turns Left: " + player1.getPlayerTurns() + "\n"
						+ "Money In Bank: £ " + player1.getMoneyInBank() + "\n" 
						+ "Wins: " + player1.getWins();
			
						//This displays the message for the user
						JOptionPane.showMessageDialog(null, statsTracker, Game.gameName, 
								JOptionPane.INFORMATION_MESSAGE);	
		
		diceData.add(d1.getRoll()); //This adds what the computer rolled to the diceData ArrayList
		guessData.add(p1Guess.getGuessString()); //This adds what the player guessed to the ArrayList	
		playerTurn.add(player1.getTurn()); // This adds what turn the player is on the Array
								
		}
	
	//-----------------------------------------------------------------------------------------------//
	
	public void gameOver() {
		
		//This sets the players final score and the players name for the League Table
		
		p1HighScore.setMoneyInBank(player1.getMoneyInBank());
		p1HighScore.setPlayerAlias(player1.getPlayerAlias());
		
		//This displays the GAME OVER message for the user
		String GameOver = "GAME OVER!\n\n" + "Thanks for playing " + player1.getPlayerAlias();
		JOptionPane.showMessageDialog(null, GameOver, Game.gameName, JOptionPane.INFORMATION_MESSAGE);
		
		//This tells the user why they lost the game 
		if (Game.player1.getPlayerTurns() <= 0 && Game.player1.getMoneyInBank() <= 0) {
			final String noTurnsNoMoney = "The game ended because you had no turns and no money left!";
			JOptionPane.showMessageDialog(null, noTurnsNoMoney);
		} else if (Game.player1.getPlayerTurns() <= 0) {
			final String noTurnsLeft = "The game ended because you had no turns left!";
			JOptionPane.showMessageDialog(null, noTurnsLeft);
		} else if (Game.player1.getMoneyInBank() <= 0) {
			final String noMoneyLeft = "The game ended because you had no money left!";
			JOptionPane.showMessageDialog(null, noMoneyLeft);
		} else {}
		
		
		
		
		
		 
			
		//This 
		
		
		if (player1.getTurn() == 5) {
		String endData = player1.getPlayerAlias() + ", below is a summary of your game results:\n\n"
			+ "Turn           Computer Rolled     You guessed\n\n" 
			+ "1. "  + "                    "  +  diceData.get(0) + "                        " +  guessData.get(0) + "\n"
			+ "2. "  + "                    "  +  diceData.get(1) + "                        " +  guessData.get(2) + "\n"
			+ "3. "  + "                    "  +  diceData.get(2) + "                        " +  guessData.get(2) + "\n"
			+ "4. "  + "                    "  +  diceData.get(3) + "                        " +  guessData.get(3) + "\n"
			+ "5. "  + "                    "  +  diceData.get(4) + "                        " +  guessData.get(4) + "\n\n"
			+ "Now to find out where you placed in the leaderboard...";
		
		JOptionPane.showMessageDialog(null, endData);
		} else if (player1.getTurn() == 4 ) {
			String endData = player1.getPlayerAlias() + " below is a summary of your game results:\n\n"
				+ "Turn        Computer Rolled        You guessed\n\n" 
				+ "1. "  + "                    "  +  diceData.get(0) + "                        " +  guessData.get(0) + "\n"
				+ "2. "  + "                    "  +  diceData.get(1) + "                        " +  guessData.get(2) + "\n"
				+ "3. "  + "                    "  +  diceData.get(2) + "                        " +  guessData.get(2) + "\n"
				+ "4. "  + "                    "  +  diceData.get(3) + "                        " +  guessData.get(3) + "\n\n"
				+ "Now to find out where you placed in the leaderboard...";
			JOptionPane.showMessageDialog(null, endData);
		} else if (player1.getTurn() == 3) {
			String endData = player1.getPlayerAlias() + " below is a summary of your game results:\n\n"
				+ "Turn        Computer Rolled        You guessed\n\n" 
				+ "1. "  + "                    "  +  diceData.get(0) + "                        " +  guessData.get(0) + "\n"
				+ "2. "  + "                    "  +  diceData.get(1) + "                        " +  guessData.get(2) + "\n"
				+ "3. "  + "                    "  +  diceData.get(2) + "                        " +  guessData.get(2) + "\n\n"
				+ "Now to find out where you placed in the leaderboard...";
			JOptionPane.showMessageDialog(null, endData);	
		} else if (player1.getTurn() == 2) {
			String endData = player1.getPlayerAlias() + " below is a summary of your game results:\n\n"
				+ "Turn        Computer Rolled        You guessed\n\n" 
				+ "1. "  + "                    "  +  diceData.get(0) + "                        " +  guessData.get(0) + "\n"
				+ "2. "  + "                    "  +  diceData.get(1) + "                        " +  guessData.get(2) + "\n\n"
				+ "Now to find out where you placed in the leaderboard...";
			JOptionPane.showMessageDialog(null, endData);		
		} else if (player1.getTurn() == 1) {
			String endData = player1.getPlayerAlias() + " below is a summary of your game results:\n\n"
				+ "Turn        Computer Rolled        You guessed\n\n" 
				+ "1. "  + "                    "  +  diceData.get(0) + "                           " +  guessData.get(0) + "\n\n"
				+ "Now to find out where you placed in the leaderboard...";
			JOptionPane.showMessageDialog(null, endData);
		} else {}
		
		
		leagueTable.leagueTable();
		
	}

	//---------------------------------------------------------------------------------------------------//
	public void anotherGo() {
		
		//SPACE FOR A 'DO YOU WANT TO PLAY AGAIN' MESSAGE 
		String[] options = {"Nope", "Heck Yeah"};
				
		final String PlayAgain = "Do you want to play the game again?";
		int AnotherGo = JOptionPane.showOptionDialog(null, PlayAgain, gameName, JOptionPane.YES_NO_OPTION,
		JOptionPane.INFORMATION_MESSAGE, overAndUnderIcon, options, options[0]);
		
		if (AnotherGo == 0) {
			setPlayerGoesAgain(false);	
		} else if (AnotherGo == 1) {
			setPlayerGoesAgain(true);
		}
	}
	
	
	public void game() {
		
		gameStarts();//This is the main start screen for the game 
		gameRules();//Tells the player the rules and asks if they understand
		chooseStake();//This allows the user to choose if they want to change the stake of the game 
		playerStartStats();//Sets player starting data
		gameInfo();//Asks the player for their name & alias 
		
		//The game plays when the player has enough money/turns to play the game 
		while (Game.player1.getPlayerTurns() > 0 && Game.player1.getMoneyInBank() > 0) {
			gamePlay();
		}
		
		gameOver(); //Game ends and the players place in the League Table is displayed 
		anotherGo();//Player will be asked if they want to play again or not 
		
		//This checks if the player wants to play again
		while (getPlayerGoesAgain() == true) {
		gameAgain();//Restarts the game if the player wants to play again 
		} 
		
		while(getPlayerGoesAgain() == false) {
			System.exit(0);//exits the game if the player does not want to play again
		}
	}
		
	
	public void gameAgain() {
		
		chooseStake();
		playerStartStats();
		
		while (Game.player1.getPlayerTurns() > 0 && Game.player1.getMoneyInBank() > 0) {
			gamePlay();
		}
		
		gameOver();
		anotherGo();
		
		while (getPlayerGoesAgain() == true) {
			gameAgain();
		}
		
		while (getPlayerGoesAgain() == false) {
			System.exit(0);
		}
		
	}
		
	
//--------------------------------------------------------------------------------------------------------------//

	

//-------------------------------------------------------------------------------------------------------//
	
	//Getters and Setters 
	
	public boolean isAnswerRight() {
		return answerRight;
	}


	public void setAnswerRight(boolean answerRight) {
		this.answerRight = answerRight;
	}	
	
	//Getters & Setters for AnotherGo
	
	public boolean getPlayerGoesAgain() {
		return playerGoesAgain;
	}

	public void setPlayerGoesAgain(boolean playerGoesAgain) {
		this.playerGoesAgain = playerGoesAgain;
	}
}
