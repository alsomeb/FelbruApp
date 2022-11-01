package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class FelbruApp extends JFrame {
    private final JPanel basePanel = new JPanel();
    private final WelcomePanel welcomePanel;
    private final GamePanel gamePanel;

    private final JButton startGameButton;

    public FelbruApp() {
        basePanel.setLayout(new BorderLayout());

        // Game panels
        welcomePanel = new WelcomePanel();
        gamePanel = new GamePanel();

        basePanel.add(welcomePanel, BorderLayout.CENTER);

        // knapp från WelcomePanel
        startGameButton = welcomePanel.getStartGameButton();
        startButtonListener();

        // Frame
        this.add(basePanel);
        this.setSize(800, 839);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FelBru App");
    }

    private void startButtonListener() {
        startGameButton.addActionListener(actionEvent -> {
            basePanel.remove(welcomePanel);
            basePanel.add(gamePanel, BorderLayout.CENTER);
            repaint();
            revalidate();
        });
    }
}
