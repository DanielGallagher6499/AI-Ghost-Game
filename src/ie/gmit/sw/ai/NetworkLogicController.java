package ie.gmit.sw.ai;

/*	Daniel Gallagher - G00360986
 * 	Artificial intelligence project
 */

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationLinear;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.util.simple.EncogUtility;

public class NetworkLogicController {

    private static BasicNetwork network = new BasicNetwork();
    //Inputs for the network
    //I made random cases to train the network
    //First case in the inputs must match first case in the outputs
    private static double[][] data = { // Player Power, Enemy Strength
            { 5, 1 }, { 5, 2 }, { 5, 3 }, { 5, 4 }, { 5, 5 }, { 6, 5 }, { 15, 1 }, { 5, 10  }, { 6, 9 }, { 7, 10 },
            { 7, 2 }, { 8, 4 }, { 11, 8 }, { 14, 6 }, { 8, 10 }, {5 , 6}};
    //Outputs of the network
    //If the output is 1 - Player takes no damage
    //If the output is 0 - Player takes damage dealt by the enemy they collided with
    private static double[][] expected = { // Player takes - No Damage / Damage
            { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 0, 1 }, { 0, 1 }, { 0, 1 },
            { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 0, 1 },{0 , 1}};

    public void createTopology() {
        network.addLayer(new BasicLayer(null, true, 2));
        network.addLayer(new BasicLayer(new ActivationLinear(), true, 2));
        network.addLayer(new BasicLayer(new ActivationLinear(), false, 2));
        network.getStructure().finalizeStructure();
        network.reset();
        System.out.println("====NN Topology Successfully created====");
        
    } 
    public void trainNetwork() {
        System.out.println("====Forming NN====");

        System.out.println("====Training in progress====");
        MLDataSet trainingSet = new BasicMLDataSet(data, expected);

        ResilientPropagation train = new ResilientPropagation(network, trainingSet);
        double minError = 0.09;
        int epoch = 1;
        EncogUtility.trainToError(train, minError);
        train.finishTraining();
        System.out.println("====Training Complete====");
        double correct = 0;
        double total = 0;
        for (MLDataPair pair : trainingSet) {
            total++;
            MLData output = network.compute(pair.getInput());
            int y = (int) Math.round(output.getData(0));
            int yd = (int) pair.getIdeal().getData(0);
            if (y == yd) {
                correct++;
            }
        }
        System.out.println("Network Acuracy: " + ((correct / total) * 100));
        Encog.getInstance().shutdown();
    }

    public int NNprediction(int playerPower, int enemyStrength) {
        double[] input = { playerPower, enemyStrength };
        MLData data = new BasicMLData(input);

        return network.classify(data);
    }
    
    //Used to test my predictions and if they were implemented correctly
    /*public static void main(String[] args) {
		NetworkLogicController nn = new NetworkLogicController();
		nn.createNetworkTopology();
		nn.trainNNetwork();
		System.out.println(nn.NNprediction(5, 6));
	}
	*/

}
    