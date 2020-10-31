import java.util.Scanner;

/**
 * Implements a scoreboard to keep score of a game.
 * @author Konnor Sommer
 */
public class ScoreboardTest {
    /**
     * Implements a scoreboard to keep score of a game.
     * @param args
     */
    public static void main(String args[]) {
        Game game = new Game("a","b");
        boolean valid = true;
        Scanner input = new Scanner(System.in);


        while(valid){
            int sport = 0;
            //Get input of 1,2,3,4 to select sport
            while ((sport != 1) & (sport !=2)&(sport !=3)&(sport !=4)) {
                System.out.println("Select the type of game:\n 1. Football\n 2. Basketball\n 3. Soccer\n 4. Hockey");
                sport = input.nextInt();
            }
            //Get home and away teams
            System.out.println("Enter home team: ");
            input.nextLine();
            String teamA = input.nextLine();
            System.out.println("Enter away team: ");
            String teamB = input.nextLine();

            //Create the selected sport
            switch (sport) {
                case 1:
                    game = new Football(teamA, teamB);
                    break;
                case 2:
                    game = new Basketball(teamA, teamB);
                    break;
                case 3:
                    game = new Soccer(teamA, teamB);
                    break;
                case 4:
                    game = new Hockey(teamA, teamB);
                    break;
            }

            game.startGame();
            //Loop through options menu while game is still in progress
            while (!game.isOver()) {
                //Print scores
                System.out.println("\n"+teamA + ": " + game.getScores()[0] + "  " + teamB + ": " + game.getScores()[1]);
                //Print period
                System.out.println("Current " + game.getPeriodName() + ": " + game.getGamePeriod());
                //Print the menu. Loop using length of scoringMethods array to know how many scoring options should be printed.
                System.out.println("\nMenu:");
                for (int i = 1; i <= 2; i++) {
                    for (int j = 0; j < game.getScoringMethods().size(); j++) {
                        if (i == 1) {
                            System.out.println((j + 1) + ". " + teamA + " " + game.getScoringMethods().get(j).getScoringMethod());
                        } else
                            System.out.println((j + 1 + game.getScoringMethods().size()) + ". " + teamB + " " + game.getScoringMethods().get(j).getScoringMethod());
                    }
                }
                System.out.println(game.getScoringMethods().size() * 2 + 1 + ". End " + game.getPeriodName());
                System.out.println("Enter choice: ");
                int choice = input.nextInt();

                //Determine which team to add score to based on user choice
                if (choice <= game.getScoringMethods().size()) {
                    game.addScore(game.getScoringMethods().get(choice - 1), teamA);
                }
                else if (choice <= game.getScoringMethods().size() * 2) {
                    game.addScore(game.getScoringMethods().get(choice - 1 - game.getScoringMethods().size()), teamB);
                }
                //End period
                else if (choice == game.getScoringMethods().size() * 2 + 1) {
                    game.endGamePeriod();
                }
            }
            //Game over
            System.out.println("\nGame Over. Final Score:");
            System.out.println(teamA + ": " + game.getScores()[0] + "  " + teamB + ": " + game.getScores()[1]);
            System.out.println("Winner: " + game.getWinner());

            System.out.println("\nCreate new game? 1 for yes, 0 for no");
            if (input.nextInt() !=1){
                valid = false;
            }
        }
    }
}
