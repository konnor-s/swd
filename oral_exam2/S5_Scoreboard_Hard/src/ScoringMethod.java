/**
 * Defines a scoring method for some game.
 * @author Konnor Sommer
 */
public class ScoringMethod {
    /**
     * Name of this scoring method.
     */
    private String scoringMethod;
    /**
     * Score value of this scoring method.
     */
    private int scoreValue;

    /**
     * Constructs a new scoring method with its name and value.
     * @param name name of scoring method
     * @param value value of scoring method
     */
    ScoringMethod(String name, int value){
        scoringMethod = name;
        scoreValue = value;
    }

    /**
     * Returns the value of a score.
     * @return score value
     */
    public int getScoreValue() {
        return scoreValue;
    }

    /**
     * Returns the name of this scoring method.
     * @return scoring method name
     */
    public String getScoringMethod() {
        return scoringMethod;
    }
}
