package org.example.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ButtonActionListener implements ActionListener {

    private final JButton button;
    List<String> winCondition = createWinCondition();

    public ButtonActionListener(JButton button) {
        this.button = button;
    }

    // COOMENT
    @Override
    public void actionPerformed(ActionEvent e) {

        // Hämtar den klickade knappen
        JButton selectedBtn = (JButton) e.getSource(); // Den knappen man klickat på

        // Alla knappar i den panelen  (container)
        Component[] components = selectedBtn.getParent().getComponents();
        JButton[] buttons = convertComponentArrayToButtonArray(components);

        // Prints
        System.out.println("DU KLICKADE PÅ DENNA KNAPPJÄVEL");
        System.out.println("X: " + selectedBtn.getX());
        System.out.println("Y: " + selectedBtn.getY());

        JButton blankButton = getBlankButton(buttons);

        // Flytt av brickor
        movePiece(selectedBtn, blankButton);
        List<String> currentResultList = getCurrentResultList(buttons);

        // Resultat i terminalen för debugging av spel
        printLists(buttons);


//        testIsWin(testCurrentResult(),winCondition);
//        isWin(currentResultList,winCondition);
    }

    public void printLists(JButton[] buttons) {
        List<String> current = getCurrentResultList(buttons);
        System.out.println(current);
        System.out.println(winCondition);
    }

    public void createTestWinCondition(JButton[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(winCondition.get(i));
        }

    }

    public void movePiece(JButton selectedButton, JButton blankButton) {

        if (isMoveLegal(selectedButton, blankButton)) {
            blankButton.setEnabled(true);
            blankButton.setText(selectedButton.getText());
            selectedButton.setText("");
            selectedButton.setEnabled(false);
        }

    }

    public JButton[] convertComponentArrayToButtonArray(Component[] components) {
        JButton[] buttons = new JButton[components.length];

        for (int i = 0; i < components.length; i++) {
            buttons[i] = (JButton) components[i];
        }
        return buttons;
    }

    // Metod för att kontrollera huruvida en "move" är tillåten genom att räkna på om givna koordinater
    //  +/- 200 matchar:
    // 1. är x samma som blankBtn?
    //        - om ja:
    //            - är y +/- 200 = blankBtn?
    //COMMENT
    public boolean isMoveLegal(JButton selectedButton, JButton blankButton) {
        if (selectedButton.getX() == blankButton.getX()) {
            if (selectedButton.getY() - 200 == blankButton.getY() ||            //TODO: Kan rad 94, 95 skrivas ihop?
                    selectedButton.getY() + 200 == blankButton.getY()) {
                System.out.println("True");
                return true;
            }
        }
        if (selectedButton.getY() == blankButton.getY()) {
            if (selectedButton.getX() - 200 == blankButton.getX() ||
                    selectedButton.getX() + 200 == blankButton.getX()) {
                System.out.println("True");
                return true;
            }
        }
        // I alla andra fall
        System.out.println("False");
        return false;
    }

    public JButton getBlankButton(JButton[] buttons) {
        for (JButton button : buttons) {
            if (button.getText().isBlank()) {
                System.out.println("BLANK BUTTON:");
                System.out.println("X: " + button.getX());
                System.out.println("Y: " + button.getY());
                return button;
            }
        }
        throw new NoSuchElementException();
    }

    public List<String> getCurrentResultList(JButton[] buttons) {
        List<String> current = new ArrayList<>(
                Arrays.stream(buttons).map(button -> button.getText()).toList());

        int blank = current.indexOf("");
        current.set(blank, "empty");
        return current;
    }

    public List<String> createWinCondition() {
        return new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "empty"));
    }

    public boolean isWin(List<String> currentResult, List<String> winCondition) {
        if (winCondition.equals(currentResult)){
            JOptionPane.showMessageDialog(null,"Winner winner, chicken dinner!");
            return true;
        }
        return false;
    }

    public boolean testIsWin(List<String> testCurrentResult, List<String> winCondition) {
        if (winCondition.equals(testCurrentResult)){
           JOptionPane.showMessageDialog(null,"Winner winner, chicken dinner!");
            return true;
        }
        return false;
    }

    public List<String> testCurrentResult() {

        return new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "empty"));
    }

}
