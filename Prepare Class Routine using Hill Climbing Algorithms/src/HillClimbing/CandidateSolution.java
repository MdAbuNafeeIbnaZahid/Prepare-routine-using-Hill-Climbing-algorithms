package HillClimbing;

import java.util.List;

/**
 * Created by nafee on 11/10/17.
 */
public interface CandidateSolution {

    public int getCost();
    public List<CandidateSolution> getNeighbors();
}
