package org.example.frontend;

import javax.swing.*;
import java.awt.*;

// Alex förklarar
public class WelcomePanel extends JPanel {
    private final JLabel welcomeText = new JLabel("Welcome To Felbru App");
    private final JButton startGameButton = new JButton("Start Game");

    public WelcomePanel() {

        // Button
        startGameButton.setFocusable(false); // Tar bort den fula focusable effecten
        startGameButton.setFont(new Font("Sans-serif", Font.BOLD, 20)); // Anger en ny font och styling
        startGameButton.setBackground(Color.decode("#B4CDE6")); // Anger färg med HEX

        // Text
        welcomeText.setFont(new Font("Sans-serif", Font.BOLD, 20));

        this.setBackground(Color.decode("#C7F2A4"));
        this.setLayout(new GridBagLayout()); // Texten och Knappen hamnar i mitten av rutan utan att vi behöver skriva någon mer kod
        this.add(welcomeText);
        this.add(Box.createHorizontalStrut(10)); // en osynlig låda som blir ett litet gap mellan JLabel och JButton så det ser bättre ut
        this.add(startGameButton);
    }

    // Getter så vi kan skriva lyssnare på knappen i "FelbruApp"
    public JButton getStartGameButton() {
        return startGameButton;
    }
}
