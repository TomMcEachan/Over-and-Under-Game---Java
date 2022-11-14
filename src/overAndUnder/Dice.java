package overAndUnder;

import javax.swing.JOptionPane;

public class Dice {

	// Instance Variables

	private int roll;
	private int rollComparison;
	private static int randomNum;
	private final int MINIMUM = 2;
	private final int MAXIMUM = 12;

	// Creating the dice object
	Dice(int roll, int rollComparison) {
		this.roll = randomNum;
	}

	// Creating the dice object with just the roll variable
	Dice(int roll) {
		this.roll = randomNum;
	}

	public void diceRoll() {

		// Randomising which dice roll the user gets
		double randomNum = (Math.random() * ((MAXIMUM - MINIMUM) + 1)) + MINIMUM;
		randomNum = (int) Math.round(randomNum);

		// Setting the roll to the number the computer has randomly picked
		if (randomNum >= 13) {
			randomNum = randomNum - 1;
		}

		setRoll(randomNum);

		// Telling the user what they rolled
		JOptionPane.showMessageDialog(null,
				"The computer has rolled both dice and has a combined total of... " + getRoll(), Game.gameName,
				JOptionPane.INFORMATION_MESSAGE);

		// This sets a value to enable comparison with what the user guessed
		if (getRoll() > 7) {
			setRollComparison(0); // Player comparator set to 0
		}

		if (getRoll() < 7) {
			setRollComparison(1); // Player comparator set to 1
		}

		if (getRoll() == 7) {
			setRollComparison(2); // Player comparator set to 2
		}
	}

	// Getters & Setters

	// ---------------------------------------------//
	public int getRoll() {
		return roll;
	}

	public void setRoll(double randomNum) {
		roll = (int) randomNum;
	}

	// ---------------------------------------------//
	public int getRollComparison() {
		return rollComparison;

	}

	public void setRollComparison(int rollComparison) {
		this.rollComparison = rollComparison;
	}

}
