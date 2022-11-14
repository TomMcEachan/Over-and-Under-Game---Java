package overAndUnder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class LeagueTable {

	
	//------------------------------------------------------------------------------------------------------------------//
		
	
	//Creating global variables 
	public String output, mapString, dialog, textOutput;
	
	//This method produces a league table and clears when the user starts a new game
	public void leagueTable() {
	
		//Creating a TreeMap in order to display the Highscore's of players  
		TreeMap <String, Integer> highScores = new TreeMap<String, Integer> (Comparator.reverseOrder());
	
		//Creating 9 possible players (one more is added when the player completes the game) 
		 Player p2 = new Player("PHBS", 5);
		 Player p3 = new Player("ATXR", 2);
		 Player p4 = new Player("MOON", 3);
		 Player p5 = new Player("ANDR", 2);
		 Player p6 = new Player("PUCK", 1);
		 Player p7 = new Player("TRTN", 5);
		 Player p8 = new Player("PRTO", 5);
		 Player p9 = new Player("STYX", 4);
		 Player p10 = new Player("BEAU", 6); 

		 //Adds the players HighScore to TreeMap 
		 highScores.put(Game.p1HighScore.getPlayerAlias(), Game.p1HighScore.getMoneyInBank());
		 
		 //Adds the other 'players' to the Tree Map
		 highScores.put(p2.getPlayerAlias(), p2.getMoneyInBank());
		 highScores.put(p3.getPlayerAlias(), p3.getMoneyInBank());
		 highScores.put(p4.getPlayerAlias(), p4.getMoneyInBank());
		 highScores.put(p5.getPlayerAlias(), p5.getMoneyInBank());
		 highScores.put(p6.getPlayerAlias(), p6.getMoneyInBank());
		 highScores.put(p7.getPlayerAlias(), p7.getMoneyInBank());
		 highScores.put(p8.getPlayerAlias(), p8.getMoneyInBank());
		 highScores.put(p9.getPlayerAlias(), p9.getMoneyInBank());
		 highScores.put(p10.getPlayerAlias(), p10.getMoneyInBank());
		
		 //Sorts highScores by values
		 Map<String, Integer> highScoresSorted = highScores.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
		 Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (hi1, hi2) -> hi1, LinkedHashMap::new));
	
		 
		 //Creates two Arrays for printing the key and value 
		 
		 ArrayList <String> Key = new  ArrayList <String>();
		 ArrayList <Integer> Value = new  ArrayList <Integer>();
		 
		 textOutput = "The HighScores for " + Game.gameName + " are: \n\n";

		 //This iterates over the TreeMap in order to show the HighScores in the console  
		 Map<String, Integer> highScoresList = highScoresSorted;
		 
		for (Entry<String, Integer> entry : highScoresList.entrySet()) {
			System.out.println(entry.getKey() + ":  " + entry.getValue()); // Prints the high scores to the console 	
			Key.add(entry.getKey());  
		    Value.add(entry.getValue());	  		
			 }				 
		 
		//This creates the output for the HighScore message at the end of the game 
		output = Key.get(0) + " :  " + Value.get(0) + "\n" +
				 Key.get(1) + " :  " + Value.get(1) + "\n" + 
				 Key.get(2) + " :  " + Value.get(2) + "\n" + 
				 Key.get(3) + " :  " + Value.get(3) + "\n" + 
				 Key.get(4) + " :  " + Value.get(4) + "\n" + 
				 Key.get(5) + " :  " + Value.get(5) + "\n" + 
				 Key.get(6) + " :  " + Value.get(6) + "\n" + 
				 Key.get(7) + " :  " + Value.get(7) + "\n" + 
				 Key.get(8) + " :  " + Value.get(8) + "\n" + 
				 Key.get(9) + " :  " + Value.get(9) + "\n"; 
				
				 	
		//This outputs the players name 		 
		JOptionPane.showMessageDialog(null, textOutput + output); 
		
		
		Key.clear(); //Clears data from the Key ArrayList
		Value.clear(); //Clears data from the Value ArrayList 
				
	}
		
	//-------------------------------------------------------------------------------------------------------------//	
}