import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{
    //This is a simulated Annealing Algorithm Designed to run on 1 Design Variable
    //The search space will be Z in order to maintain simplicity

    public static void main(String[] args)
    {
        Random random = new Random();
        int rand = random.nextInt(100000) - 50000;
        double probability = 1;

        System.out.println("Initial Value: " + rand);
        dataItem currentSolution = new dataItem(rand);

        List<dataItem> neighbours;

        for(int i = 0; i < 100000; i++)
        {
            neighbours = currentSolution.generateNeighbours();
            int randItem = random.nextInt(neighbours.size());
            dataItem randNeighbour = neighbours.get(randItem);

            if(quality(randNeighbour) <= quality(currentSolution))
            {
                double randomDouble = random.nextDouble();
                if(randomDouble < probability)
                {
                    currentSolution = randNeighbour;
                }
            }
            else
            {
                currentSolution = randNeighbour;
            }

            probability = probability * 0.95;
        }

        System.out.println(currentSolution.getValue());
    }

    static double quality(dataItem x)
    {
        return -(Math.pow(x.getValue(),2));
    }
}