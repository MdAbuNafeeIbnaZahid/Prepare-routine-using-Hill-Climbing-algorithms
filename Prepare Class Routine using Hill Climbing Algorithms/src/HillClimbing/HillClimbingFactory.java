package HillClimbing;

import HillClimbing.SelectingSuccessor.SteepestAscentSelector;
import HillClimbing.SelectingSuccessor.StochasticSelector;

/**
 * Created by nafee on 11/23/17.
 */
public class HillClimbingFactory {

    public static final String STEEPEST_ASCENT_HILL_CLIMBING = "STEEPEST_ASCENT_HILL_CLIMBINT";
    public static final String STOCHASTIC_HILL_CLIMBING = "STOCHASTIC_HILL_CLIMBING";

    public static HillClimbing getHillClimbing(  Problem problem, String hillClimbingType )
    {

        HillClimbing ret = null;


        switch ( hillClimbingType )
        {
            case STEEPEST_ASCENT_HILL_CLIMBING :
                ret = new HillClimbing(problem, new SteepestAscentSelector());
                break;
            case STOCHASTIC_HILL_CLIMBING:
                ret = new HillClimbing(problem, new StochasticSelector());
                break;
            default:
                ret = null;
                break;
        }

        return ret;







//        if ( hillClimbingType.equals(STEEPEST_ASCENT_HILL_CLIMBING) )
//        {
//            return new HillClimbing(problem, new SteepestAscentSelector());
//        }
//        else if ( hillClimbingType.equals(STOCHASTIC_HILL_CLIMBING) )
//        {
//            return new HillClimbing(problem, new StochasticSelector());
//        }
//        else // Given type doesn't match with any known type
//        {
//            return null;
//        }
    }
}
