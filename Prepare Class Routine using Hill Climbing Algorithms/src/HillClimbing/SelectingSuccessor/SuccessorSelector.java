package HillClimbing.SelectingSuccessor;

import HillClimbing.CandidateSolution;

/**
 * Created by nafee on 11/11/17.
 */

public interface SuccessorSelector {
    CandidateSolution getNextSuccessor(Iterable<CandidateSolution> candidateSolutions, CandidateSolution currentCS );
}
