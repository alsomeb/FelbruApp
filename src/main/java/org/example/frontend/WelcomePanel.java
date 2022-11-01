package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    private final JLabel welcomeText = new JLabel("Welcome To Felbru App");
    private final JButton startGameButton = new JButton("Start Game");

    public WelcomePanel() {

        // Button
        startGameButton.setFocusable(false);
        startGameButton.setFont(new Font("Sans-serif", Font.BOLD, 20));
        startGameButton.setBackground(Color.decode("#B4CDE6"));

        // Text
        welcomeText.setFont(new Font("Sans-serif", Font.BOLD, 20));

        this.setBackground(Color.decode("#C7F2A4"));
        this.setLayout(new GridBagLayout());
        this.add(welcomeText);
        this.add(Box.createHorizontalStrut(10)); // Space Between label and button
        this.add(startGameButton);
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }
}
