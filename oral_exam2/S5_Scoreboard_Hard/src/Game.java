import java.util.ArrayList;

/**
 * Defines a game's attributes and methods
 * @author Konnor Sommer
 */
public class Game {
    /**
     * Home team (as string)
     */
    private String teamA;
    /**
     * Away team (as string)
     */
    private String teamB;
    /**
     * Home team score
     */
    private int scoreA;
    /**
     * Away team score
     */
    private int scoreB;
    /**
     * List of all scoring methods for this game
     * @see ScoringMethod
     */
    private  ArrayList<ScoringMethod> scoringMethods = new ArrayList<ScoringMethod>();
    /**
     * Information about the period for this game
     * @see Period
     */
    private Period gamePeriod;

    /**
     * Constructs a new game with the home and away teams
     * @param a Home team
     * @param b Away team
     */
    Game(String a, String b){
        setTeams(a,b);
    }

    /**
     * Adds new scoring methods to this game
     * @param method Scoring Method
     * @see Game#scoringMethods
     */
    public void addScoringMethod(ScoringMethod method){
        scoringMethods.add(method);
    }

    /**
     * Creates the type of period for this game
     * @param period current period
     * @param length length in minutes
     * @param name name of period
     * @param num number of periods in a game
     */
    public void createPeriods(int period,int length,String name, int num){
        gamePeriod = new Period(period,length,name,num);
    }

    /**
     * Sets the teams for this game.
     * @param a String Home team
     * @param b String Away team
     */
    public void setTeams(String a, String b){
        teamA = a;
        teamB = b;
    }

    /**
     * Returns the teams of this game in an array.
     * @return String array of team names
     */
    public String[] getTeams(){
        return new String[]{teamA,teamB};
    }

    /**
     * Returns the current scores of this game in an array.
     * @return int array of scores
     */
    public int[] getScores(){
        return new int[]{scoreA,scoreB};
    }

    /**
     * Adds score to one team.
     * @param score ScoringMethod
     * @param team String which team scored
     */
    public void addScore(ScoringMethod score, String team){
        if (team.equals(teamA)){
            scoreA+=score.getScoreValue();
        }
        else if (team.equals(teamB)){
            scoreB += score.getScoreValue();
        }
    }

    /**
     * Returns all possible scoring methods for this game.
     * @return ArrayList of scoring methods
     */
    public ArrayList<ScoringMethod> getScoringMethods(){
        return scoringMethods;
    }

    /**
     * Start the game by setting period to 1.
     */
    public void startGame(){
        gamePeriod.setPeriod(1);
    }

    /**
     * End the current period and progress to the next.
     */
    public void endGamePeriod(){
        gamePeriod.setPeriod(gamePeriod.getPeriod()+1);
    }

    /**
     * Return the current period.
     * @return int current period
     */
    public int getGamePeriod(){
        return gamePeriod.getPeriod();
    }

    /**
     * Return the length of a period
     * @return int period length
     */
    public int getPeriodLength(){
        return gamePeriod.getLength();
    }

    /**
     * Return the name of a period
     * @return String period name
     */
    public String getPeriodName(){
        return gamePeriod.getName();
    }

    /**
     * Return whether or not the game is over
     * @return boolean game over or not
     */
    public boolean isOver(){
        if (gamePeriod.getPeriod() >gamePeriod.getNumPeriods()){
            return true;
        }
        else return false;
    }

    /**
     * Return the winner of the game.
     * @return String game winner
     */
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
