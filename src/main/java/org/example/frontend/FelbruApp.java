package org.example.frontend;

import javax.swing.*;

public class FelbruApp extends JFrame {
    private final JPanel basePanel = new JPanel();
    private final WelcomePanel welcomePanel;
    private final GamePanel gamePanel;


    public FelbruApp() {

        // Game panels
        welcomePanel = new WelcomePanel();
        gamePanel = new GamePanel();
        gamePanel.setVisible(false);
        basePanel.add(gamePanel);
        basePanel.add(welcomePanel);



        // Frame
        this.add(basePanel);
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
