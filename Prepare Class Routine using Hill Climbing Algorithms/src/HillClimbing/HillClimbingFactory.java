package HillClimbing;

import HillClimbing.SelectingSuccessor.SteepestAscentSelector;

/**
 * Created by nafee on 11/23/17.
 */
public class HillClimbingFactory {

    public static String STEEPEST_ASCENT_HILL_CLIMBING = "STEEPEST_ASCENT_HILL_CLIMBINT";

    public static HillClimbing getHillClimbing(  Problem problem, String hillClimbingType )
    {
        if ( hillClimbingType.equals(STEEPEST_ASCENT_HILL_CLIMBING) )
        {
            return new HillClimbing(problem, new SteepestAscentSelector());
        }
        else // Given type doesn't match with any known type
        {
            return null;
        }
    }
}
