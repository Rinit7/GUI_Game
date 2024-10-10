//Author:Swanit Rivankar
//RollNo:2453
//Title:Choose the correct Color
//Start Date:20th August 2024
//Modified Date:31th August 2024
//Description: This Java code implements a GUI-based game called "Choose the Correct Color." The game challenges the player to correctly identify either the color or the word displayed on the screen under various difficulty levels (Easy, Medium, Hard, and Custom).
import javax.swing.*;

public class Custom extends Level {
    public int custom(int score, JFrame frame) throws InterruptedException {
        int u = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the cooldown time (in seconds):")) * 1000;
        int v = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of rounds:"));
        return levelfunc(u, score, v, frame);
    }
}
