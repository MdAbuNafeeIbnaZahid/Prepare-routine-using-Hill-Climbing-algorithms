package HillClimbing;

import HillClimbing.SelectingSuccessor.SteepestAscentSelector;
import HillClimbing.SelectingSuccessor.StochasticSelector;

/**
 * Created by nafee on 11/23/17.
 */
public class HillClimbingFactory {

    public static String STEEPEST_ASCENT_HILL_CLIMBING = "STEEPEST_ASCENT_HILL_CLIMBINT";
    public static String STOCHASTIC_HILL_CLIMBING = "STOCHASTIC_HILL_CLIMBING";

    public static HillClimbing getHillClimbing(  Problem problem, String hillClimbingType )
    {
        if ( hillClimbingType.equals(STEEPEST_ASCENT_HILL_CLIMBING) )
        {
            return new HillClimbing(problem, new SteepestAscentSelector());
        }
        else if ( hillClimbingType.equals(STOCHASTIC_HILL_CLIMBING) )
        {
            return new HillClimbing(problem, new StochasticSelector());
        }
        else // Given type doesn't match with any known type
        {
            return null;
        }
    }
}
