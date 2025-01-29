import java.util.Random;
import java.util.Scanner;

public class GameChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Hello! I'm your game chatbot. I can play games with you!\n");
        while (true) {
            System.out.println("Here are the games you can play:");
            System.out.println("1. Number Guessing Game");
            System.out.println("2. Quiz Game");
            System.out.println("3. Word Guessing Game");
            System.out.println("4. Reverse Word Game");
            System.out.println("5. Math Challenge Game");
            System.out.println("6. Riddle Game");
            System.out.println("7. Anagram Game");
            System.out.println("8. Hangman Game");
            System.out.println("9. Trivia Game");
            System.out.println("10. Higher or Lower Game");
            System.out.println("11. Exit");
            System.out.print("Enter the number of the game you'd like to play: ");

            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    playNumberGuessingGame(scanner);
                    break;
                case "2":
                    playQuizGame(scanner);
                    break;
                case "3":
                    playWordGuessingGame(scanner);
                    break;
                case "4":
                    playReverseWordGame(scanner);
                    break;
                case "5":
                    playMathChallengeGame(scanner);
                    break;
                case "6":
                    playRiddleGame(scanner);
                    break;
                case "7":
                    playAnagramGame(scanner);
                    break;
                case "8":
                    playHangmanGame(scanner);
                    break;
                case "9":
                    playTriviaGame(scanner);
                    break;
                case "10":
                    playHigherOrLowerGame(scanner);
                    break;
                case "11":
                    System.out.println("Goodbye! Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    
    private static void playNumberGuessingGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("\nWelcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Try to guess it!");

        while (true) {
            System.out.print("Enter your guess: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!\n");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    
    private static void playQuizGame(Scanner scanner) {
        System.out.println("\nWelcome to the Quiz Game!");
        System.out.println("Answer the following questions. Type your answer and press Enter.\n");

        String[][] questions = {
            {"What is the capital of France?", "paris"},
            {"What is 5 + 3?", "8"},
            {"Who wrote 'Hamlet'?", "shakespeare"}
        };

        int score = 0;

        for (String[] question : questions) {
            System.out.println(question[0]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals(question[1])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question[1] + "\n");
            }
        }

        System.out.println("You scored " + score + " out of " + questions.length + "!\n");
    }

    
    private static void playWordGuessingGame(Scanner scanner) {
        String[] words = {"java", "python", "programming", "computer", "algorithm"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        StringBuilder hiddenWord = new StringBuilder("_".repeat(wordToGuess.length()));
        int attempts = 0;

        System.out.println("\nWelcome to the Word Guessing Game!");
        System.out.println("Guess the word, one letter at a time.");

        while (true) {
            System.out.println("Word: " + hiddenWord);
            System.out.print("Enter a letter: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                System.out.println("Please enter a valid single letter.");
                continue;
            }

            char guessedLetter = userInput.charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    hiddenWord.setCharAt(i, guessedLetter);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Incorrect guess.");
            }

            attempts++;

            if (hiddenWord.toString().equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                System.out.println("It took you " + attempts + " attempts.");
                break;
            }
        }
    }

    
    private static void playReverseWordGame(Scanner scanner) {
        String word = "example";
        StringBuilder reversedWord = new StringBuilder(word).reverse();

        System.out.println("\nWelcome to the Reverse Word Game!");
        System.out.println("Try to guess the word after it's been reversed!");

        System.out.println("Reversed Word: " + reversedWord);
        System.out.print("Enter your guess: ");
        String userGuess = scanner.nextLine().trim().toLowerCase();

        if (userGuess.equals(word)) {
            System.out.println("Correct! You guessed the word.");
        } else {
            System.out.println("Incorrect. The correct word was: " + word);
        }
    }

    
    private static void playMathChallengeGame(Scanner scanner) {
        Random random = new Random();
        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(20) + 1;
        int correctAnswer = num1 * num2;

        System.out.println("\nWelcome to the Math Challenge Game!");
        System.out.println("What is " + num1 + " x " + num2 + "?");

        System.out.print("Your answer: ");
        try {
            int userAnswer = Integer.parseInt(scanner.nextLine());
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer was: " + correctAnswer);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    
    private static void playRiddleGame(Scanner scanner) {
        String riddle = "I speak without a mouth and hear without ears. I have nobody, but I come alive with wind. What am I?";
        String answer = "echo";

        System.out.println("\nWelcome to the Riddle Game!");
        System.out.println("Here's your riddle: " + riddle);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().trim().toLowerCase();

        if (userAnswer.equals(answer)) {
            System.out.println("Correct! Well done.");
        } else {
            System.out.println("Incorrect. The answer was: " + answer);
        }
    }

    
    private static void playAnagramGame(Scanner scanner) {
        String word = "listen";
        String jumbledWord = "silent";

        System.out.println("\nWelcome to the Anagram Game!");
        System.out.println("Unscramble the following word: " + jumbledWord);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().trim().toLowerCase();

        if (userAnswer.equals(word)) {
            System.out.println("Correct! You unscrambled the word.");
        } else {
            System.out.println("Incorrect. The correct word was: " + word);
        }
    }

    
    private static void playHangmanGame(Scanner scanner) {
        String word = "computer";
        StringBuilder hiddenWord = new StringBuilder("_".repeat(word.length()));
        int attempts = 6;
        String guessedLetters = "";

        System.out.println("\nWelcome to the Hangman Game!");
        System.out.println("Try to guess the word!");

        while (attempts > 0) {
            System.out.println("Word: " + hiddenWord);
            System.out.print("Guessed Letters: " + guessedLetters);
            System.out.println("\nAttempts left: " + attempts);
            System.out.print("Enter a letter: ");
            String guess = scanner.nextLine().trim().toLowerCase();

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            guessedLetters += guess;

            if (word.contains(guess)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess.charAt(0)) {
                        hiddenWord.setCharAt(i, guess.charAt(0));
                    }
                }

                if (hiddenWord.toString().equals(word)) {
                    System.out.println("Congratulations! You've guessed the word: " + word);
                    break;
                }
            } else {
                attempts--;
                System.out.println("Incorrect guess.");
            }
        }

        if (attempts == 0) {
            System.out.println("Sorry, you've run out of attempts! The word was: " + word);
        }
    }

    
    private static void playTriviaGame(Scanner scanner) {
        String[][] triviaQuestions = {
            {"Who painted the Mona Lisa?", "da vinci"},
            {"What is the largest planet in our solar system?", "jupiter"},
            {"In what year did the Titanic sink?", "1912"}
        };

        System.out.println("\nWelcome to the Trivia Game!");
        int score = 0;

        for (String[] question : triviaQuestions) {
            System.out.println(question[0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (userAnswer.equals(question[1])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question[1]);
            }
        }

        System.out.println("You scored " + score + " out of " + triviaQuestions.length + "!");
    }

    
    private static void playHigherOrLowerGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("\nWelcome to the Higher or Lower Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        while (true) {
            System.out.print("Enter your guess: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!\n");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
