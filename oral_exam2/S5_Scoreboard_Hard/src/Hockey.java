/**
 * Extends Game class to define particular game hockey.
 * @author Konnor Sommer
 */
public class Hockey extends Game{
    /**
     * Constructs new hockey game with its teams, period type, and scoring methods.
     * @param a Home team
     * @param b Away team
     */
    Hockey(String a,String b){
        super(a,b);
        createPeriods(0,20,"Third",3);
        addScoringMethod(new ScoringMethod("Goal", 1));
    }

}
