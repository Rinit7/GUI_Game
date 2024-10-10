import javax.swing.*;

public class Custom extends Level {
    public int custom(int score, JFrame frame) throws InterruptedException {
        int u = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the cooldown time (in seconds):")) * 1000;
        int v = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of rounds:"));
        return levelfunc(u, score, v, frame);
    }
}
