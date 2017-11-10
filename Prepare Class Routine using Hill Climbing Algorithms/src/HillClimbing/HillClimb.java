package HillClimbing;

import java.util.List;

/**
 * Created by nafee on 11/10/17.
 */
public class HillClimb {
    Problem problem;

    public HillClimb(Problem problem) {
        this.problem = problem;
    }


    // CAUTION : it may return null
    private CandidateSolution getBestCandidateSolution(List<CandidateSolution> solutions)
    {
        CandidateSolution bestCandidate = null;
        int minCost = Integer.MAX_VALUE;
        for (CandidateSolution cs : solutions)
        {
            if ( cs.getCost() < minCost )
            {
                minCost = cs.getCost();
                bestCandidate = cs;
            }
        }
        return bestCandidate;
    }



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
            List<CandidateSolution> successors = initialSolution.getSuccessors();
            CandidateSolution bestSuccessor = getBestCandidateSolution(successors);


            if ( bestSuccessor==null || bestSuccessor.getCost() >= initialSolution.getCost() )
            {
                break;
            }

            System.out.println( " bestSuccessor.getCost() =  " + bestSuccessor.getCost() );
            initialSolution = bestSuccessor;
        }

        return initialSolution;
    }
}
