import javax.swing.JOptionPane;

public class Wordle {
    public static void main(String[] args) {
        WordleGame game = new WordleGame();

        JOptionPane.showMessageDialog(null, "Welcome to Wordle! You have " + game.Maxattempts() + " attempts to guess the word.");

        for (int attempt = 1; attempt <= game.Maxattempts(); attempt++) {
            String guess = JOptionPane.showInputDialog("Attempt " + attempt + ":\nEnter your guess (5 letters):");

            if (guess == null) {
                JOptionPane.showMessageDialog(null, "Game aborted. Goodbye!");
                return;
            }

            guess = guess.trim().toUpperCase();

            if (guess.length() != 5) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter exactly 5 letters.");
                attempt--;
                continue;
            }

            if (game.CorrectGuess(guess)) {
                JOptionPane.showMessageDialog(null, "Congratulations! The word was: " + game.getAnswer());
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Feedback:\n" + game.Answer(guess));
            }
        }

        JOptionPane.showMessageDialog(null, "Sorry, you've used up all your attempts. The word was: " + game.getAnswer());
    }
}
