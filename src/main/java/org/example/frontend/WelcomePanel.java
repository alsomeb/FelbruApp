package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    private final JLabel welcomeText = new JLabel("Welcome To Felbru App");
    private final JButton startGameButton = new JButton("Start Game");

    public WelcomePanel() {
        this.setLayout(new GridBagLayout());
        this.add(welcomeText);
        this.add(Box.createHorizontalStrut(10)); // Space Between label and button
        this.add(startGameButton);
    }
}
