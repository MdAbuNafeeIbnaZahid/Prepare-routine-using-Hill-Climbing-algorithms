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



    CandidateSolution climbHillRandomRestart(Problem problem)
    {
        int minCost = Integer.MAX_VALUE;
        CandidateSolution bestSolution = null;
        while (minCost != 0)
        {
            CandidateSolution initialSolution = problem.getRandomCandidateSolution();
            CandidateSolution solution = climbHill(initialSolution);
            if ( solution.getCost() < minCost )
            {
                minCost = solution.getCost();
                bestSolution = solution;
            }
        }
        return bestSolution;
    }

    CandidateSolution climbHill( CandidateSolution initialSolution )
    {
        while (true)
        {
            List<CandidateSolution> successors = initialSolution.getSuccessors();
            CandidateSolution bestSuccessor = getBestCandidateSolution(successors);
            if ( bestSuccessor.getCost() >= initialSolution.getCost() )
            {
                break;
            }
            initialSolution = bestSuccessor;
        }

        return initialSolution;
    }
}
