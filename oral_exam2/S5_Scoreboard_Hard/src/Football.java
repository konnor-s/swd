public class Football extends Game {

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
