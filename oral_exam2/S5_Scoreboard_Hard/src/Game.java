import java.util.ArrayList;

public class Game {
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private  ArrayList<ScoringMethod> scoringMethods = new ArrayList<ScoringMethod>();
    private Period gamePeriod;

    Game(String a, String b){
        setTeams(a,b);
    }

    public void addScoringMethod(ScoringMethod method){
        scoringMethods.add(method);
    }
    public void createPeriods(int period,int length,String name, int num){
        gamePeriod = new Period(period,length,name,num);
    }
    public void setTeams(String a, String b){
        teamA = a;
        teamB = b;
    }
    public String[] getTeams(){
        return new String[]{teamA,teamB};
    }
    public int[] getScores(){
        return new int[]{scoreA,scoreB};
    }
    public void addScore(ScoringMethod score, String team){
        if (team.equals(teamA)){
            scoreA+=score.getScoreValue();
        }
        else if (team.equals(teamB)){
            scoreB += score.getScoreValue();
        }
    }
    public ArrayList<ScoringMethod> getScoringMethods(){
        return scoringMethods;
    }
    public void startGame(){
        gamePeriod.setPeriod(1);
    }
    public void endGamePeriod(){
        gamePeriod.setPeriod(gamePeriod.getPeriod()+1);
    }
    public int getGamePeriod(){
        return gamePeriod.getPeriod();
    }
    public int getPeriodLength(){
        return gamePeriod.getLength();
    }
    public String getPeriodName(){
        return gamePeriod.getName();
    }
    public boolean isOver(){
        if (gamePeriod.getPeriod() >gamePeriod.getNumPeriods()){
            return true;
        }
        else return false;
    }
    public String getWinner(){
        if (isOver()){
            if (scoreA>scoreB){
                return teamA;
            }
            else if (scoreB>scoreA){
                return teamB;
            }
            else return "Tie Game!";
        }
        else return "Game not over!";
    }
}
