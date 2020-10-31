/**
 * Extends Game class to define particular game Football.
 * @author Konnor Sommer
 */
public class Football extends Game {
    /**
     * Constructs new football game with its teams, period type, and scoring methods.
     * @param a Home team
     * @param b Away team
     */
    Football(String a, String b){
        super(a,b);
        createPeriods(0,15,"Quarter",4);
        addScoringMethod(new ScoringMethod("Touchdown", 6));
        addScoringMethod(new ScoringMethod("Field Goal", 3));
        addScoringMethod(new ScoringMethod("Extra Point", 1));
        addScoringMethod(new ScoringMethod("Two-Point Conversion", 2));
        addScoringMethod(new ScoringMethod("Safety", 2));
    }
}
