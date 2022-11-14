package overAndUnder;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player  {
	
	//Creating the player Icon 
	static ImageIcon playerIcon = new ImageIcon("playerIcon.png");
	
	//instance variables 
	private String playerFirstName;
	private String playerSecondName;
	private String playerAlias;
	private String playerName;
	private int numberOfBets;
	private int turns;
	private int moneyInBank;
	private int wins;
	private int turn;
	private String age;
	private int ageInt;
	final private int AGE_TO_PLAY = 18;
		
	//Player constructor
	public Player (String playerFirstName, String playerSecondName, 
			String playerAlias, String playerName, int numberOfBets, 
			int turns, int moneyInBank, int wins){
			
			 this.playerFirstName = playerFirstName;
			 this.playerSecondName = playerSecondName;
			 this.playerAlias = playerAlias; 
			 this.playerName = playerName;	
			 this.numberOfBets = numberOfBets;
			 this.turns = turns;
			 this.moneyInBank = moneyInBank;
			 this.wins = wins;
		}
	
	//PlayerHighScore Constructor
	public Player (String playerAlias, int moneyInBank) {
		this.playerAlias = playerAlias;
		this.moneyInBank = moneyInBank;
	}
	
	//Player constructor with no parameters
	public Player() {}
	
	//Creating a league table constructor so that it's methods can be accessed
	
	public static LeagueTable leagueTable = new LeagueTable();
	
	

//--------------------------------------------------------------------------------------//
		
	public void PlayerInfo() {
		//Asking user their full name and game alias and setting that 
		
		//Question 1 -- Setting the players first name 
		String fName = JOptionPane.showInputDialog(null, "What is your first name?", 
				Game.gameName, JOptionPane.QUESTION_MESSAGE);
		
		setPlayerFirstName(fName); //sets the player second name to what they typed in 
		
		while (fName.isEmpty()) { //If the player does not enter a name then this error message continues to appear until the issue is resolved 
			
			String firstName = JOptionPane.showInputDialog(null, "You didn't enter a first name!\n\n "
															+ "What is your first name?", 
														  Game.gameName, JOptionPane.ERROR_MESSAGE);
			
			fName = firstName; //This sets fName to the firstName variable in the error message 
			
			setPlayerFirstName(fName);
		}
		
		//-----------------------------------------------------------------------------//
		
		//Question 2 -- Setting the players second name 
		String sName = JOptionPane.showInputDialog(null, "What is your second name?",
				Game.gameName,JOptionPane.QUESTION_MESSAGE);
		
		while (sName.isEmpty()) { //If they do not type in a name then error message continues to appear until the issue is resolved
			String secondName = JOptionPane.showInputDialog(null, "You didn't enter a second name!\n\n"
															+ "What is your second name?", 
															Game.gameName, JOptionPane.ERROR_MESSAGE);
			
			sName = secondName; //This sets sName to the second name variable in the error message 
			
		}
		
		setPlayerSecondName(sName); //sets the player second name to what they typed in
		
		//-------------------------------------------------------------------------------//
		
		//Question 3 -- Setting the players game name 
		String aName = JOptionPane.showInputDialog(null, "What is your game name?\n\n This must be 4 characters and CAPITALISED!!", 
				Game.gameName,JOptionPane.QUESTION_MESSAGE);
		
		setPlayerAlias(aName); //sets the player alias to what they typed in
		
		while (aName.isEmpty()) {
			String aliasName = JOptionPane.showInputDialog(null, "You didn't enter a game name!\n\n"
															+ "What is your second name?", 
															Game.gameName, JOptionPane.ERROR_MESSAGE);
			
			aName = aliasName; //This sets aName to the second name variable in the error message
		}
			
		while (aName.length() != 4 ||  aName.equals(aName.toLowerCase())) {
			String aliasName = JOptionPane.showInputDialog(null, "You did not enter a game name that was "
														  + "4 characters and capitalised.\n\n Please try again!", 
														  Game.gameName, JOptionPane.ERROR_MESSAGE);
			
			
			aName = aliasName; //This sets aName to the alias name variable in the error message
		}
			
			setPlayerAlias(aName);
					
			
		//Question 4 -- Asking for the players age for age verification 
			
		String age = JOptionPane.showInputDialog(null, "What age are you?", 
					 Game.gameName, JOptionPane.QUESTION_MESSAGE);
		
		while (age.isEmpty()) {
			age = JOptionPane.showInputDialog(null, "You did not enter an age!\n\n Please enter one!", 
														Game.gameName, JOptionPane.ERROR_MESSAGE);
		}
		
		ageInt = Integer.parseInt(age);
		
		if (ageInt < AGE_TO_PLAY) { //Checking if the player is the legal age to gamble
			JOptionPane.showMessageDialog(null, fName +  
										" you must be " + AGE_TO_PLAY + " or older to play this game!\n" + 
										 "You are not old enough to play -- goodbye!\n", 
										 Game.gameName, JOptionPane.ERROR_MESSAGE);
			System.exit(0); //Closing the game because they are not old enough 
		}
		
		
	
		setPlayerAge(ageInt); //This sets the age to the ageNum in the error message 
		
		//-------------------------------------------------------------------------------//
		
		//Confirming with user that their first and second name is correct
		int confirm = JOptionPane.showConfirmDialog(null, "Your name is " + getPlayerFirstName() 
		+ " " + getPlayerSecondName() + "\n \n Your Alias is: " + getPlayerAlias(), 
		Game.gameName, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

			/* Checking with user if their name and alias are correct. If it is not correct, 
			 * they get a message and the createPlayer() method starts again.  */
					
					if (confirm == 0) {
						JOptionPane.showMessageDialog(null, "Okay " + getPlayerAlias() + 
								" - let's start the Game!", Game.gameName, 
								JOptionPane.INFORMATION_MESSAGE, playerIcon);
					} else {
						
						JOptionPane.showMessageDialog(null, "Oh no - let's try that again!",
								Game.gameName, JOptionPane.WARNING_MESSAGE);
						PlayerInfo();
				}
		
			//Creating full player name so that it can be used elsewhere in the program without having to combine first and second name every time
					
			setPlayerName(getPlayerFirstName() + "  " + getPlayerSecondName());	
			
				
		}//PlayerInfo() method ends 

		
//----------------------------------------------------------------------------------------------------------//
		
		//Getters & Setters 


		//Getters and Setters for player first name 
			
		public String getPlayerFirstName() {
				return playerFirstName;
			}
				
		public void setPlayerFirstName(String playerFirstName) {
				this.playerFirstName = playerFirstName;
			}

		//---------------------------------------------------//
				
		//Getters and Setters for player second name 
		public String getPlayerSecondName() {
			return playerSecondName;
		}
					
		public void setPlayerSecondName(String playerSecondName) {
			this.playerSecondName = playerSecondName;
		}
				
		//---------------------------------------------------//
				

		//Getters and Setters for player alias 
				
				
		public String getPlayerAlias() {
			return playerAlias;
		}

		public void setPlayerAlias(String playerAlias) {
			this.playerAlias = playerAlias;
		}

				
		//--------------------------------------------------//
				
		//Getters and Setters for players name
				
		public String getPlayerName() {
			return playerName;
		}

				
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
		
		
		//Getters and Setters for players Age 
		
		public String getPlayerAge() {
			return age;
		}
		
		public void setPlayerAge (int ageInt) {
			
		}
				
		//----------------------------------------------------//
		
		//Turns left getter and setter
		public int getPlayerTurns() {
			return turns;
		}


		public void setPlayerTurns(int turns) {
			this.turns = turns;
		}

		//--------------------------------------------------//
						
						
		//Number of bets getter and setter 
		public  int getNumberOfBets() {
			return numberOfBets;
		}

		public void setNumberOfBets(int numberOfBets) {
			this.numberOfBets = numberOfBets;
		}
				
		//--------------------------------------------------//
			
		//Money in bank getter and setter
		public int getMoneyInBank() {
			return moneyInBank;
		}

		public void setMoneyInBank(int moneyInBank) {
			this.moneyInBank = moneyInBank;
		}
		
		//--------------------------------------------------//
		
		//Number of wins getter and setter
		
		public int getWins() {
			return wins;
		}
		
		public void setWins(int wins) {
			this.wins = wins;
		}
		
		
		//Turn getter and setter 
		
		public int getTurn () {
			
			return turn;
		}
	
		public void setTurn (int turn) {
			this.turn = turn;
		}
}

