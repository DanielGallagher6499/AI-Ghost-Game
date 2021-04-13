package ie.gmit.sw.ai;

/*	Daniel Gallagher - G00360986
 * 	Artificial intelligence project
 */

public class enemy {
	private int enemyHealth = 20;
	private int strength;
	public static char enemyID = 0;
	
	//Get Enemy Health Method
	public int getEnemyHealth() {
		return enemyHealth;
	}
	
	//Get Enemy Strength Method depending on enemyID
	public int getStrength() {
		char ID = getEnemyID();
		if(ID == '2')
		{
			System.out.println("Red Enemy - Hit force = 10HP");
			strength = 10;
		}
		else if(ID == '3')
		{
			System.out.println("Pink Enemy - Hit force = 8HP");
			strength = 8;
		}
		else if(ID == '4')
		{
			System.out.println("Blue Enemy - Hit force = 6HP");
			strength = 6;
		}
		else if(ID == '5')
		{
			System.out.println("Red Green Enemy - Hit force = 5HP");
			strength = 5;
		}
		else if(ID == '6')
		{
			System.out.println("Orange Enemy - Hit force = 2HP");
			strength = 2;
		}
		return strength;
	}
	
	//Set the enemyID method
	public void setEnemyID(char enemyID) {
		enemy.enemyID = enemyID;
		
	}
	//Get enemyID method
	public static char getEnemyID() {
		return enemyID;
	}
	
}
