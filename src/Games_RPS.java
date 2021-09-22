import java.util.Random;
import java.util.Scanner;

public class Games_RPS {
    public static String rock     = "Rock";
    public static String scissors = "Scissors";
    public static String paper    = "Paper";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerOneName;
        String playerOneChoice;
        String computerName = "Safy the AI";
        System.out.println("Welcome");
        System.out.println("Do you wanna play singleplayer or multiplayer");
        System.out.print("Input: ");
        String singlePlayerOrMultiplayer = scanner.nextLine();
        if(singlePlayerOrMultiplayer.equals("Singleplayer")){
            System.out.println("Player 1 write your name: ");
            playerOneName = scanner.nextLine();
            System.out.println("Pick Rock, Paper or Scissors");
            playerOneChoice = scanner.nextLine();
            String computerChoice = getComputerChoice();
            System.out.println(game(playerOneName, playerOneChoice, computerName, computerChoice));
        } else if(singlePlayerOrMultiplayer.equals("Multiplayer")) {
            System.out.println("Player 1 write your name: ");
            playerOneName = scanner.nextLine();
            System.out.println("Pick Rock, Paper or Scissors");
            playerOneChoice = scanner.nextLine();
            System.out.println("Player 2 write your name: ");
            String playertwoName = scanner.nextLine();
            System.out.println("Pick Rock, Paper or Scissors");
            String playerTwoChoice = scanner.nextLine();
            System.out.println(game(playerOneName, playerOneChoice, playertwoName, playerTwoChoice));

        }
    }

    // Methode for Computer choice
    public static String getComputerChoice(){
        String computerChoice = "";
        int number = getRandomComputerChoice(1,3);
        if (number == 1) {
            computerChoice = rock;
        } else if (number == 2) {
            computerChoice = scissors;
        } else if (number == 3) {
                computerChoice = paper;
        }
        return computerChoice;
    }

    public static int getRandomComputerChoice(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    // Game med booleans og switches
    public static String game(String playerOneName, String playerOneInput, String playerTwoName, String playerTwoInput){

        boolean playerOneWonWithRock = playerOneInput.equals(rock) && playerTwoInput.equals(scissors);
        boolean playerTwoWonWithRock = playerTwoInput.equals(rock) && playerOneInput.equals(scissors);

        boolean playerOneWonWithScissors = playerOneInput.equals(scissors) && playerTwoInput.equals(paper);
        boolean playerTwoWonWithScissors = playerTwoInput.equals(scissors) && playerOneInput.equals(paper);

        boolean playerOneWonWithPaper = playerOneInput.equals(paper) && playerTwoInput.equals(rock);
        boolean playerTwoWonWithPaper = playerTwoInput.equals(paper) && playerOneInput.equals(rock);

        boolean itsADraw = playerOneInput.equals(playerTwoInput);

        String results = "";
        if(itsADraw){
            results = "It's a tie. Player 1's choice: " + playerOneInput + "Player 2's choice: " + playerTwoInput;
        } else if(playerOneWonWithRock){
            results = playerOneName + " won! " + playerOneName + "'s choice: " + playerOneInput + " " + playerTwoName + "'s choice: " + playerTwoInput;
        } else if(playerTwoWonWithRock){
            results = playerTwoName + " won! " + playerOneName + "'s choice: " + playerOneInput + " " + playerTwoName + "''s choice: " + playerTwoInput;
        } else if(playerOneWonWithScissors){
            results = playerOneName + " won! " + playerOneName +  "'s choice: " + playerOneInput + " " + playerTwoName + "'s choice: " + playerTwoInput;
        } else if(playerTwoWonWithScissors){
            results = playerTwoName + " won! " + playerOneName + "s choice: " + playerOneInput + " " + playerTwoName + "'s choice: " + playerTwoInput;
        } else if(playerOneWonWithPaper){
            results = playerOneName + " won! " + playerOneName + "'s choice: " + playerOneInput + " " + playerTwoName + "''s choice: " + playerTwoInput;
        } else if(playerTwoWonWithPaper){
            results = playerTwoName + " won! " + playerOneName +"'s choice: " + playerOneInput + " " + playerTwoName + "''s choice: " + playerTwoInput;
        }

        return results;

    }

    // Results
}
