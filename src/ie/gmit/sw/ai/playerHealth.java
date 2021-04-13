package ie.gmit.sw.ai;

/*	Daniel Gallagher - G00360986
 * 	Artificial intelligence project
 */

public class playerHealth {
	private static int playerHealth = 20;
	private enemy e = new enemy();
	private static int playerPower = 5;
	
	//Get playersHealth method
	public int getPlayerHealth() {
		return playerHealth;
	}
	
	//Method which is called when the player hits an enemy and loses
	public void playerHit()
	{
		//Hits the player with the specified force using their ID 
		playerHealth -= e.getStrength(); 
	}
	
	//Get playerPower Method
	public int getPlayerPower()
	{
		//Returns player power
		return playerPower;
	}
	
	//IncrementPower method - Called when the player beats a ghost
	public void incrementPower()
	{
		playerPower += 1;
	}
	
}