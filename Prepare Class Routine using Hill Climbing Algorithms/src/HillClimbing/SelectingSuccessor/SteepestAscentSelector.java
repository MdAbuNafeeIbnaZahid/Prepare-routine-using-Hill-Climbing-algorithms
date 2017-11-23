package HillClimbing.SelectingSuccessor;

import HillClimbing.CandidateSolution;

/**
 * Created by nafee on 11/11/17.
 */
public class SteepestAscentSelector implements SuccessorSelector
{
    @Override
    public CandidateSolution getNextSuccessor(Iterable<CandidateSolution> neighbors, CandidateSolution currentCS) {
        CandidateSolution ret = null;
        for ( CandidateSolution neighbor : neighbors )
        {
            if ( ret == null || ret.getCost() > currentCS.getCost() )
            {
                ret = neighbor;
            }
        }
        return ret;
    }
}
