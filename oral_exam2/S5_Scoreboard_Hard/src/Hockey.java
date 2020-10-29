public class Hockey extends Game{
    Hockey(String a,String b){
        super(a,b);
        createPeriods(0,20,"Third",3);
        addScoringMethod(new ScoringMethod("Goal", 1));
    }

}
