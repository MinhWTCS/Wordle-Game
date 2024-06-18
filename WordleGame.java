import java.util.Random;

public class WordleGame {
    private static final String[] wordBank = {"WORLD", "HELLO", "MESSI", "MESSY", "MUSIC", "FLOOD", "DREAM", "ADULT", "JIMIN", "ABUSE", "EAGLE", "BLACK", "SMACK", "WHALE", "QUEEN", "ERROR", "CRASH", "SPIKE", "DANDY"};
    private static final int MAX_ATTEMPTS = 6;

    private String answer;

    public WordleGame() {
        Random random = new Random();
        answer = wordBank[random.nextInt(wordBank.length)];
    }

    public String getAnswer() {
        return answer;
    }

    public boolean CorrectGuess(String guess) {
        return guess.equals(answer);
    }

    public String Answer(String guess) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char guessedLetter = guess.charAt(i);
            char actualLetter = answer.charAt(i);
            if (guessedLetter == actualLetter) {
                feedback.append("<html><font color='green'>").append(guessedLetter).append("</font></html>");
            } else if (answer.contains(String.valueOf(guessedLetter))) {
                feedback.append("<html><font color='yellow'>").append(guessedLetter).append("</font></html>");
            } else {
                feedback.append("<html><font color='white'>").append(guessedLetter).append("</font></html>");
            }
        }
        return feedback.toString();
    }

    public int Maxattempts() {
        return MAX_ATTEMPTS;
    }
}
