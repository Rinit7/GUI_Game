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

public class Main {
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Choose the Correct Color");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(45, 52, 54)); 

        JLabel titleLabel = new JLabel("Choose the Correct Color");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(titleLabel);

        String[] levels = {"Easy", "Medium", "Hard", "Custom"};
        JComboBox<String> levelComboBox = new JComboBox<>(levels);
        levelComboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        levelComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        levelComboBox.setMaximumSize(new Dimension(150, 30));
        panel.add(levelComboBox);

        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(scoreLabel);

        JButton startButton = new JButton("Start Game");
        startButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(0, 184, 148));
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel.add(startButton);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        frame.add(panel);
        frame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            int score = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = (String) levelComboBox.getSelectedItem();
                try {
                    switch (selectedLevel) {
                        case "Easy":
                            Easy e1 = new Easy();
                            score = e1.easy(score, frame);
                            break;
                        case "Medium":
                            Medium m1 = new Medium();
                            score = m1.medium(score, frame);
                            break;
                        case "Hard":
                            Hard h1 = new Hard();
                            score = h1.hard(score, frame);
                            break;
                        case "Custom":
                            Custom c1 = new Custom();
                            score = c1.custom(score, frame);
                            break;
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                scoreLabel.setText("Score: " + score);
                JOptionPane.showMessageDialog(frame, "Your score is: " + score);
            }
        });
    }
}
