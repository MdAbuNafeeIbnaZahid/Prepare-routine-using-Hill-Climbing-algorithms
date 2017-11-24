package HillClimbing.SelectingSuccessor;

import HillClimbing.CandidateSolution;
import selecting_probabilistically.ItemWithProbability;
import selecting_probabilistically.ProbabilisticSelector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nafee on 11/24/17.
 */
public class StochasticSelector implements SuccessorSelector {

    @Override
    public CandidateSolution getNextSuccessor(Iterable<CandidateSolution> neighbors, CandidateSolution currentCS) {
        List<ItemWithProbability> neighborsWithProb = new ArrayList<ItemWithProbability>();
        for ( CandidateSolution neighbor : neighbors )
        {
            double probability = currentCS.getCost() - neighbor.getCost();
            if ( probability < 0 )
            {
                continue;
            }
            ItemWithProbability itemWithProbability = new ItemWithProbability(probability, neighbor);
            neighborsWithProb.add(itemWithProbability);
        }

        ProbabilisticSelector probabilisticSelector = new ProbabilisticSelector(neighborsWithProb);
        CandidateSolution ret = (CandidateSolution) probabilisticSelector.getItemProbabilistically();


        return ret;
    }

}
