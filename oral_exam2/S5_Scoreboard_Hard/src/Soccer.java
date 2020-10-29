public class Soccer extends Game {
    Soccer(String a,String b){
        super(a,b);
        createPeriods(0,45,"Half",2);
        addScoringMethod(new ScoringMethod("Goal", 1));
    }
}
