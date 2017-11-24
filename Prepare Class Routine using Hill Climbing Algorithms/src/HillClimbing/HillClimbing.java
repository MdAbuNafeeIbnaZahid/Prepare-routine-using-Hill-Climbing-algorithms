package HillClimbing;
import HillClimbing.SelectingSuccessor.*;

import java.util.List;

/**
 * Created by nafee on 11/10/17.
 */
public class HillClimbing {
    Problem problem;
    SuccessorSelector successorSelector;

    public HillClimbing(Problem problem, SuccessorSelector successorSelector) {
        this.problem = problem;
        this.successorSelector = successorSelector;
    }




//     CAUTION : it may return null
//     I think I don't this method at all as I am using an interface for this work
//    private CandidateSolution getNextCandidateSolution(List<CandidateSolution> solutions)
//    {
//        CandidateSolution bestCandidate = null;
//        int minCost = Integer.MAX_VALUE;
//        for (CandidateSolution cs : solutions)
//        {
//            if ( cs.getCost() < minCost )
//            {
//                minCost = cs.getCost();
//                bestCandidate = cs;
//            }
//        }
//        return bestCandidate;
//    }



    public CandidateSolution climbHillRandomRestart()
    {
        int minCost = Integer.MAX_VALUE;
        CandidateSolution bestSolution = null;
        while (minCost != 0)
        {
            CandidateSolution initialSolution = problem.getRandomCandidateSolution();

            System.out.println( " initialSolution.getCost() =  " + initialSolution.getCost() );

            CandidateSolution solution = climbHill(initialSolution);
            if ( solution.getCost() < minCost )
            {
                minCost = solution.getCost();
                bestSolution = solution;
                System.out.println( "got a better local maxima " +  minCost);
            }
        }
        return bestSolution;
    }

    private CandidateSolution climbHill( CandidateSolution initialSolution )
    {
        while (true)
        {
            List<CandidateSolution> successors = initialSolution.getNeighbors();
            CandidateSolution nextCandidateSolution = successorSelector.getNextSuccessor(successors, initialSolution);



            if ( nextCandidateSolution==null || nextCandidateSolution.getCost() >= initialSolution.getCost() )
            {
                break;
            }

            System.out.println( " nextCandidateSolution.getCost() =  " + nextCandidateSolution.getCost() );
            initialSolution = nextCandidateSolution;
        }

        return initialSolution;
    }
}
