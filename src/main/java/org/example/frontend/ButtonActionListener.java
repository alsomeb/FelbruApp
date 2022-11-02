package org.example.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ButtonActionListener implements ActionListener {
    // En skräddarsydd ActionListener, med ytterligare funktionalitet

    private boolean hasWonGame;

    private final JButton button;
    List<String> winCondition = createWinCondition();

    public ButtonActionListener(JButton button, boolean hasWonGame) {
        this.button = button;
        this.hasWonGame = hasWonGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Hämtar den JButton man klickat på
        JButton selectedBtn = (JButton) e.getSource();

        // Alla knappar i den panelen (container)
        Component[] components = selectedBtn.getParent().getComponents();
        JButton[] buttons = convertComponentArrayToButtonArray(components);

        // Debugging Prints
        System.out.println("SELECTED TILE POS");
        System.out.println("X: " + selectedBtn.getX());
        System.out.println("Y: " + selectedBtn.getY());

        // Hämtar aktuell blankButton
        JButton blankButton = getBlankButton(buttons);

        // Flytt av brickor
        movePiece(selectedBtn, blankButton);
        List<String> currentResultList = getCurrentResultList(buttons);

        // Resultat i terminalen för debugging av spel
        printLists(buttons);

        testIsWin(testCurrentResult(),winCondition);
        //isWin(currentResultList,winCondition);

        // Control flow för vunnet spel
        if(hasWonGame) {
            int choice = promptWonGame();
            switch (choice) {
                case 0 -> reloadGame(selectedBtn);
                case 1,-1 -> System.exit(0);
            }
        }
    }

    // Daniel Förklarar
    // För debugging.
    public void printLists(JButton[] buttons) {
        List<String> current = getCurrentResultList(buttons);
        System.out.println(current);
        System.out.println(winCondition + "\n");
    }


    // Daniel förklarar
    // Flyttar pjäs förutsatt att valet är tillåtet.
    public void movePiece(JButton selectedButton, JButton blankButton) {

        if (isMoveLegal(selectedButton, blankButton)) {
            blankButton.setEnabled(true);
            blankButton.setText(selectedButton.getText());
            blankButton.setBackground(Color.decode("#C7F2A4"));

            selectedButton.setText("");
            selectedButton.setBackground(Color.WHITE);
            selectedButton.setEnabled(false);
        }

    }

    // Daniel förklarar
    // Om X-värdet av vald knapp överensstämmer med X-värdet för blank yta kontrolleras huruvida Y +/-200 överensstämmer.
    // Metoden svarar på frågan huruvida knapparna är angränsande till varandra horisontellt och vertikalt, men inte diagonalt.
    public boolean isMoveLegal(JButton selectedButton, JButton blankButton) {
        if (selectedButton.getX() == blankButton.getX()) {
            if (selectedButton.getY() - 200 == blankButton.getY() ||
                    selectedButton.getY() + 200 == blankButton.getY()) {
                System.out.println("True"); // För debugging
                return true;
            }
        }
        if (selectedButton.getY() == blankButton.getY()) {
            if (selectedButton.getX() - 200 == blankButton.getX() ||
                    selectedButton.getX() + 200 == blankButton.getX()) {
                System.out.println("Can be moved: True"); // För debugging
                return true;
            }
        }
        // I alla andra fall
        System.out.println("Can be moved: False"); // För debugging
        return false;
    }

    // Alex förklarar
    // Konverterar Array av Typ "Components" till JButtons, så vi kan komma åt dens metoder,
    // Vi har hämtat alla Komponenter i container sedan innan
    public JButton[] convertComponentArrayToButtonArray(Component[] components) {
        JButton[] buttons = new JButton[components.length];

        for (int i = 0; i < components.length; i++) {
            buttons[i] = (JButton) components[i];
        }
        return buttons;
    }

    // Daniel förklarar
    // Om en button är "blank" returneras den.
    public JButton getBlankButton(JButton[] buttons) {
        for (JButton button : buttons) {
            if (button.getText().isBlank()) {
                System.out.println("BLANK TILE POS:");
                System.out.println("X: " + button.getX());
                System.out.println("Y: " + button.getY() + "\n");
                return button;
            }
        }
        throw new NoSuchElementException();
    }

    // Alex förklarar
    // Skickar in den konverterade JButton array och öppnar up en ström på den arrayen,
    // Hämtar knappens text från varje knapp och collectar allt till en lista
    // Denna används för att jämföra mot Facit Listan "WinCondition" som bestämmer om man vunnit spelet om dem här 2 Listorna equals() varandra
    public List<String> getCurrentResultList(JButton[] buttons) {
        List<String> current = new ArrayList<>(
                Arrays.stream(buttons).map(button -> button.getText()).toList());

        int blank = current.indexOf("");
        current.set(blank, "empty");
        return current;
    }

    // Daniel Förklarar
    // Spelet är vunnet endast när spelets JButtons motsvarar arrayen nedan.
    // Metoden kallas vid start av programmet och sparas i winCondition
    public List<String> createWinCondition() {
        return new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "empty"));
    }

    // Daniel Förklarar
    // vid varje flytt av pjäs jämförs win condition med spelbrädets nuvarande uppställning.
    public void isWin(List<String> currentResult, List<String> winCondition) {
        if (winCondition.equals(currentResult)){
            JOptionPane.showMessageDialog(null,"Winner winner, chicken dinner!");
            hasWonGame = true;
        }
    }

    // Daniel Förklarar
    // Testvariant av isWin för att säkerställa att logiken fungerar.
    public void testIsWin(List<String> testCurrentResult, List<String> winCondition) {
        if (winCondition.equals(testCurrentResult)){
            System.out.println("\n" + "Current: " + testCurrentResult + "\n" + "Win: " + winCondition);
            JOptionPane.showMessageDialog(null,"Winner winner, chicken dinner!");
            hasWonGame = true;
        }
    }

    // Daniel förklarar
    // En lista som speglar hur listan currentResult ser ut när spelet är vunnet.
    // Tillåter test av vinst utan att behöva spela igenom spelet.
    public List<String> testCurrentResult() {
        return new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "empty"));
    }

    // Alex förklarar
    private int promptWonGame() {
        Object[] options = {"Yes", "No, Exit"};
        Image winPicImage = new ImageIcon("src/main/resources/img/bigwin.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // ReSize
        ImageIcon winPicIcon = new ImageIcon(winPicImage); // Spara den i en ImageIcon för att använda I JOptionPane

        return JOptionPane.showOptionDialog(null, "Play Again ?", "You won! Congrats", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, winPicIcon, options, null);
    }

    // Alex Förklarar
    private void reloadGame(JButton selectedBtn) { // Behöver knappen pga vi skall hämta dens parent
        Container gamePanel = selectedBtn.getParent(); // Hämtar Container som är GamePanel
        Container mainPanel = gamePanel.getParent(); // Hämtar mainPanelen som är "basePanel i FelBru App (Parent till gamePanel)

        mainPanel.remove(gamePanel); // Tar bort gamePanel från mainPanel
        mainPanel.add(new GamePanel()); // Lägger in en ny gamePanel

        mainPanel.revalidate(); // Måla om UI
        mainPanel.repaint();
    }
}
