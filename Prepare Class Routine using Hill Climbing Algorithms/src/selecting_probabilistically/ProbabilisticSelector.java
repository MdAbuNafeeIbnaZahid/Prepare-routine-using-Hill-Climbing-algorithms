package selecting_probabilistically;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by nafee on 11/23/17.
 */
public class ProbabilisticSelector {

    private List<ItemWithProbability> itemsWithProb;
    private double relativeProbabilitySum = 0;
    private Random random = new Random();

    public ProbabilisticSelector(List<ItemWithProbability> itemsWithProb) {
        this.itemsWithProb = itemsWithProb;
        for ( ItemWithProbability itemWithProbability : itemsWithProb )
        {
            relativeProbabilitySum += itemWithProbability.getRelativeProbability();
        }
    }

    public Object getItemProbabilistically()
    {
        if ( itemsWithProb.isEmpty() ) // Given an empty iterable
        {
            return null;
        }

        double randProbSum = random.nextDouble()*relativeProbabilitySum;
        double probSum = 0;
        int idx = 0;

        while (probSum < randProbSum)
        {
            probSum += itemsWithProb.get(idx++).getRelativeProbability();
        }

        int selectedIdx = Math.max(0, idx-1);
        ItemWithProbability selectedItemWithProb = itemsWithProb.get(selectedIdx);
        return selectedItemWithProb.getItem();

    }
}
