package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class FelbruApp extends JFrame {
    private final JPanel basePanel = new JPanel();
    private final WelcomePanel welcomePanel;
    private final GamePanel gamePanel;

    public FelbruApp() {
        basePanel.setLayout(new BorderLayout());

        // Game panels
        welcomePanel = new WelcomePanel();
        gamePanel = new GamePanel();

        //basePanel.add(gamePanel, BorderLayout.CENTER);
        basePanel.add(welcomePanel, BorderLayout.CENTER);

        // Frame
        this.add(basePanel);
        this.setSize(800, 839);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FelBru App");
    }
}
