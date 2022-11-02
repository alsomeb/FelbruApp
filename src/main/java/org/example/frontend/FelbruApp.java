package org.example.frontend;

import javax.swing.*;
import java.awt.*;


// Alex förklarar
public class FelbruApp extends JFrame {
    private final JPanel basePanel = new JPanel();
    private final WelcomePanel welcomePanel;
    private final GamePanel gamePanel;
    private final JButton startGameButton;

    public FelbruApp() {
        basePanel.setLayout(new BorderLayout());

        // Welcome Panel & Game panel
        welcomePanel = new WelcomePanel();
        gamePanel = new GamePanel();

        basePanel.add(welcomePanel, BorderLayout.CENTER);

        // JButton från WelcomePanel
        // finns en getter på "startGameButton" i WelcomePanel klassen,
        // Vi kan nu komma åt den och skriva en Actionlyssnare på knappen i denna klass
        startGameButton = welcomePanel.getStartGameButton();
        // startGameButtons knapplyssnare i en egen metod
        startButtonListener();

        // Frame
        this.add(basePanel); // Basplattan (Panelen)
        this.setSize(800, 839);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FelBru App");
    }

    // Kan skriva detta med ett Lambda pga ActionListener är ett Functional Interface dvs bara en metod finns!
    private void startButtonListener() {
        startGameButton.addActionListener(actionEvent -> {
            basePanel.remove(welcomePanel);
            basePanel.add(gamePanel, BorderLayout.CENTER);
            repaint();
            revalidate();
        });
    }
}
