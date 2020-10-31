/**
 * Extends Game class to define particular game basketball.
 * @author Konnor Sommer
 */
public class Basketball extends Game{
    /**
     * Constructs new basketball game with its teams, period type, and scoring methods.
     * @param a Home team
     * @param b Away team
     */
    Basketball(String a, String b){
        super(a,b);
        createPeriods(0,20,"Half",2);
        addScoringMethod(new ScoringMethod("Free Throw", 1));
        addScoringMethod(new ScoringMethod("Field Goal", 2));
        addScoringMethod(new ScoringMethod("3-Pointer", 3));
    }
}
