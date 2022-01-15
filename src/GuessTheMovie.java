

public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        // start a new game
        Game newGame = new Game("titles.txt");

        // generate random movie title from the list
        System.out.println(newGame.movieTitle);


        System.out.println("Welcome to the Guess The Title Game!");

        //The Game is on until player guesses title or is out of available attempts
        while(!newGame.guessedTitle() && newGame.attemptsLeft > 0) {

            //Display hidden movie title string
            System.out.println(newGame.movieTitleHidden);

            //Ask user for a guess
            char yourGuess = newGame.getLetter();

            //Check if letter is in word and keep track of score
            if (newGame.checkLetter(yourGuess)) {
                //If letter is in word
                newGame.replaceGuessedLetters(yourGuess);
                System.out.println("Correct");
            } else {
                System.out.println("Try again.");
                System.out.println("You have " + newGame.attemptsLeft + " guess(es) left.");
                if (newGame.attemptsLeft == 0) {
                    System.out.println("You lose.");
                }
            }

        }


    }


}
