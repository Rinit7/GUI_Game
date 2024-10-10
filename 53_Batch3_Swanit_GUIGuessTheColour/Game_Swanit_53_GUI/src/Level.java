//Author:Swanit Rivankar
//RollNo:2453
//Title:Choose the correct Color
//Start Date:20th August 2024
//Modified Date:31th August 2024
//Description: This Java code implements a GUI-based game called "Choose the Correct Color." The game challenges the player to correctly identify either the color or the word displayed on the screen under various difficulty levels (Easy, Medium, Hard, and Custom).
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Random;

public class Level {
    public static final Color[] COLORS = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.MAGENTA};
    public static final String[] WORDS = {"red", "green", "yellow", "blue", "purple"};

    public int levelfunc(int t, int score, int p, JFrame frame) throws InterruptedException {
        Random random = new Random();

        for (int j = 0; j < p; j++) {
            int r = random.nextInt(COLORS.length * WORDS.length);
            int colorIndex = r / WORDS.length;
            int wordIndex = r % WORDS.length;

            // Show the word in a dialog for t milliseconds
            showWordDialog(WORDS[wordIndex], COLORS[colorIndex], t, frame);

            // Determine the selection prompt and correct answer
            String prompt = random.nextInt(2) == 0 ? "Select the color:" : "Select the word:";
            String correctAnswer = prompt.equals("Select the color:") ? WORDS[colorIndex] : WORDS[wordIndex];

            // Get the user's selection and check the result
            int result = getUserSelection(prompt, correctAnswer, frame);
            if (result == -1) {
                JOptionPane.showMessageDialog(frame, "You lost!");
                return score;  // Exit if user lost
            } else {
                score += result;  // Update score if the answer is correct
            }
        }

        return score;
    }

    private void showWordDialog(String word, Color color, int displayTime, JFrame frame) {
        JDialog wordDialog = new JDialog(frame, "Displayed Word", false);
        wordDialog.setSize(300, 100);
        wordDialog.setLayout(new FlowLayout());
        wordDialog.setAlwaysOnTop(true);

        // Word label
        JLabel wordLabel = new JLabel(word);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        wordLabel.setForeground(color);
        wordDialog.add(wordLabel);

        // Position the dialog above the main frame
        wordDialog.setLocationRelativeTo(frame);
        wordDialog.setLocation(frame.getX() + 100, frame.getY() - 50);

        // Show the dialog
        wordDialog.setVisible(true);

        // Timer to close the dialog after displayTime milliseconds
        new Timer(displayTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordDialog.dispose();  // Close the dialog
            }
        }).start();  // Start the timer
    }

    private int getUserSelection(String prompt, String correctAnswer, JFrame frame) {
        // Create radio buttons for the user to select an answer
        JPanel panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        for (String word : WORDS) {
            JRadioButton radioButton = new JRadioButton(word);
            radioButton.setActionCommand(word);
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        // Create custom dialog for selection
        int result = JOptionPane.showConfirmDialog(frame, panel, prompt, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If OK is pressed, check the user's answer
        if (result == JOptionPane.OK_OPTION) {
            Enumeration<AbstractButton> buttons = buttonGroup.getElements();
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    String userAnswer = button.getActionCommand();
                    if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                        return 10;  // Return score increase if the answer is correct
                    }
                }
            }
        } else {
            return -1;  // Return -1 to indicate that the user canceled
        }

        return -1;  // Return -1 to indicate loss
    }
}
