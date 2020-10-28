abstract public class Game {
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;

    Game(String a, String b){
        setTeams(a,b);
    }
    public void setTeams(String a, String b){
        teamA = a;
        teamB = b;
    };
    public String[] getTeams(){
        return new String[]{teamA,teamB};
    }
    public int[] getScores(){
        return new int[]{scoreA,scoreB};
    }
    public void addScore(int score, String team{
        if team.equals(teamA){
            scoreA+=score;
        }
        else if team.equals(teamB){
            scoreB += score;
        }
    }
    public
}
/*
    set the teams
        get the teams
        get the scores for each team
        addScore
        getScoringMethods
        start the game
        end the current period of play
        get the current period of play
        get length of period
        get name of period (quarter, half, etc.)
        is the game over?
        winning team*/