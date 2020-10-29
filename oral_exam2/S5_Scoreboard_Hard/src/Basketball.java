public class Basketball extends Game{
    Basketball(String a, String b){
        super(a,b);
        createPeriods(0,20,"Half",2);
        addScoringMethod(new ScoringMethod("Free Throw", 1));
        addScoringMethod(new ScoringMethod("Field Goal", 2));
        addScoringMethod(new ScoringMethod("3-Pointer", 3));
    }
}
