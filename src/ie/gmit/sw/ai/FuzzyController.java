package ie.gmit.sw.ai;

/*	Daniel Gallagher - G00360986
 * 	Artificial intelligence project
 */

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyController {
	
	private static final String FCL_FILE = "./resources/fuzzy/game.fcl";
	
	public double getGameInfo(int enemyHealth, int playerHealth) {
		FIS fis = FIS.load(FCL_FILE, true);
		FunctionBlock fb = fis.getFunctionBlock("getGameInfo");
		fis.setVariable("enemyHealth", enemyHealth);
		fis.setVariable("playerHealth", playerHealth);
		fis.evaluate();
		Variable game = fb.getVariable("gameOver");
		//JFuzzyChart.get().chart(fis);
		//JFuzzyChart.get().chart(game.getDefuzzifier(), "Game Info", true);

		return (int) game.getValue();
		}
	
	//Used for testing fuzzy logic
	public static void main(String [] args) {
		FuzzyController g = new FuzzyController();
		double Game = g.getGameInfo(20, 20);
		System.out.println(Game);
	}
}