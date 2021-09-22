import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Games_project {
    public static void main(String[] args) {
        String[] options =
                {"kæreste","kaffemaskine","Netflix","sofa","løbesko",
                        "guitar","slik", "hund", "bog", "øl" };
        int[] answerRegistration = new int[10];

        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = randomNumberOfPeople(3, 15);

        // Options of choice
        System.out.println("Hvilken ting vil du helst have med på en øde ø?");
        System.out.println(numberOfPeople + " personer skal svare");
        for (int i = 0; i < options.length; i++){
            System.out.println(i+1 + " " + options[i]);
        }
        // Input from multiple users
        for (int i = 0; i < numberOfPeople; i++){
            System.out.print("Indtast valg: ");
            String userInput = scanner.nextLine();
            int indexOfArray = getIndexOfArrayOptions(options, userInput);
            System.out.println(options[indexOfArray]);
            addPointToAnswerRegistration(answerRegistration, indexOfArray);
        }

        for (int i = 0; i < answerRegistration.length; i++){
            System.out.print(answerRegistration[i] + ", ");
        }

        int indexOfHighestValue = getIndexOfHighestValue(answerRegistration);
        String winner = mostPopularVote(options,indexOfHighestValue);
        System.out.println("Det mest populær valg er " + winner);
    }

    public static int randomNumberOfPeople(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static int getIndexOfArrayOptions(String[] arrayForOptions, String userChoose){
        int indexOfOptions = 0;
        for (int i = 0; i < arrayForOptions.length; i++){
            if(Arrays.asList(arrayForOptions).contains(userChoose)){
                indexOfOptions = Arrays.asList(arrayForOptions).indexOf(userChoose);
                return indexOfOptions;
            }
        }
        return indexOfOptions;
    }
    public static int addPointToAnswerRegistration(int[] arrayForAnswerRegistration,int indexOfOptions){
        int addedPoint = arrayForAnswerRegistration[indexOfOptions] = arrayForAnswerRegistration[indexOfOptions] + 1;
        return addedPoint;
    }
    public static int getIndexOfHighestValue(int[] arrayForAnswerRegistration){
        int largest = 0;
        for (int i = 0; i < arrayForAnswerRegistration.length; i++){
            if (arrayForAnswerRegistration[i] > arrayForAnswerRegistration[largest]){
                largest = i;
            }
        }
        return largest;
     }
    public static String mostPopularVote(String[] arrayForOptions, int indexOfHighsetValue){
       String mostPopularChoice = arrayForOptions[indexOfHighsetValue];
       return mostPopularChoice;
    }

}
