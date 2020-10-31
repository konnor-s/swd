/**
 * Extends Game class to define particular game soccer.
 * @author Konnor Sommer
 */
public class Soccer extends Game {
    /**
     * Constructs new soccer game with its teams, period type, and scoring methods.
     * @param a Home team
     * @param b Away team
     */
    Soccer(String a,String b){
        super(a,b);
        createPeriods(0,45,"Half",2);
        addScoringMethod(new ScoringMethod("Goal", 1));
    }
}
