package overAndUnder;

public class Stake {

	
	private int stakeWin2;
	private int stakeWin5;
	private int stakeTakeTurnMoney;
	
	//Creates an object called stake 
	public Stake (int stakeWin2, int stakeWin5, int stakeTakeTurnMoney) {
		 this.stakeWin2 = stakeWin2;
		 this.stakeWin5 = stakeWin2;
		 this.stakeTakeTurnMoney = stakeTakeTurnMoney;
	}
	
	
	// ---------------------------------------------------------------------------------//
	
	//Getters and Setters 

	
		//StakeWin2 getter and setter
	
		public int getStakeWin2() {
			return stakeWin2;
		}
		
		public void setStakeWin2(int stakeWin2) {
			this.stakeWin2 = stakeWin2;
		}
	
		//StakeWin5 getter and setter 
		
		public int getStakeWin5() {
			return stakeWin5;
		}
		
		public void setStakeWin5(int stakeWin5) {
			this.stakeWin5 = stakeWin5;
		}
		
		//Take turns getter and setter
		public int getTakeTurnMoney() {
			return stakeTakeTurnMoney;
		}
	
		
		public void setTakeTurnMoney(int stakeTakeTurnMoney) {
			this.stakeTakeTurnMoney = stakeTakeTurnMoney;
		}
}
	

