import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    private ArrayList<String> lines;
    private int numberOfTitles;
    public int attemptsLeft;
    public String movieTitle;
    public String movieTitleHidden;

    public Game(String movieTitlesFile) throws Exception {
        this.attemptsLeft = 10;

        File titleList = new File(movieTitlesFile);
        Scanner readTitles = new Scanner(titleList);

        this.lines = new ArrayList<String>();
        this.numberOfTitles = 0;
        while (readTitles.hasNextLine()) {
            this.lines.add(readTitles.nextLine());
            this.numberOfTitles += 1;

        }
        int titleIndex = (int) (Math.random() * numberOfTitles);
        this.movieTitle = lines.get(titleIndex);
        this.movieTitleHidden = movieTitle.replaceAll("[a-zA-Z]", "_");


    }



    public char getLetter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your guess: ");
        String userInput = scanner.nextLine().toLowerCase();

        if(userInput.length() != 1){
            System.out.println("That is not a letter.");
            return getLetter();
        }

        else{
            return userInput.charAt(0);
        }

    }

    // This method returns index of letter guessed by user, if letter does not exist in title, method returns -1
    private int indexOfLetter(char letter) {
        int index = movieTitle.indexOf(letter);
        return index;
    }

   // This method checks if  letter provided by user is in movie title. It will add letter to guessedLetters or wrongLetters list and keep track of score.
    public boolean checkLetter(char letter) {
        // letter is correct
        if (indexOfLetter(letter) > -1) {
            return true;
        } else {
            this.attemptsLeft -= 1;
            return false;
        }
    }

    public String replaceGuessedLetters(char letter) {
        StringBuilder MovieTitleHiddenSb = new StringBuilder(movieTitleHidden);
        for (int i = movieTitle.indexOf(letter); i > -1; i = movieTitle.indexOf(letter, i+1)) {
            MovieTitleHiddenSb.setCharAt(i, letter);

        }
        this.movieTitleHidden = MovieTitleHiddenSb.toString();
        return movieTitleHidden;
    }

    public boolean guessedTitle() {
        if (movieTitleHidden.equals(movieTitle)) {
            System.out.println("Congratulations, you win.");
            return true;
        } else {
            return false;
        }
    }
}


