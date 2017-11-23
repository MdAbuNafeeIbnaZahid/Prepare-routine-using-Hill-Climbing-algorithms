package selecting_probabilistically;

/**
 * Created by nafee on 11/23/17.
 */
public class ItemWithProbability {
    private double relativeProbability;
    private Object item;


    public double getRelativeProbability() {
        return relativeProbability;
    }

    public Object getItem() {
        return item;
    }

    public ItemWithProbability(double relativeProbability, Object item) {
        this.relativeProbability = relativeProbability;
        this.item = item;
    }
}
