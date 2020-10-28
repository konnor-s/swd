public class ScoringMethod {
    private String scoringMethod;
    private int scoreValue;

    ScoringMethod(String name, int value){
        scoringMethod = name;
        scoreValue = value;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public String getScoringMethod() {
        return scoringMethod;
    }
}
