//Author:Swanit Rivankar
//RollNo:2453
//Title:Choose the correct Color
//Start Date:20th August 2024
//Modified Date:31th August 2024
//Description: This Java code implements a GUI-based game called "Choose the Correct Color." The game challenges the player to correctly identify either the color or the word displayed on the screen under various difficulty levels (Easy, Medium, Hard, and Custom).
import javax.swing.*;

public class Hard extends Level {
    public int hard(int score, JFrame frame) throws InterruptedException {
        return levelfunc(500, score, 15, frame);
    }
}
