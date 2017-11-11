package HillClimbing.SelectingSuccessor;

import HillClimbing.CandidateSolution;

import java.util.Iterator;

/**
 * Created by nafee on 11/11/17.
 */
public interface SuccessorSelector {
    public CandidateSolution getNextSuccessor(Iterator<CandidateSolution> iterator, CandidateSolution currentCS );
}
