package org.example.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;


public class ButtonActionListener implements ActionListener {

    private JButton button;


    public ButtonActionListener(JButton button) {
        this.button = button;
    }

// COOMENT
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectedBtn = (JButton) e.getSource(); // Den knappen man klickat på

        // Alla knappar i den panelen  (container)
        Component[] knappar = selectedBtn.getParent().getComponents();

        System.out.println("DU KLICKADE PÅ DENNA KNAPPJÄVEL");
        System.out.println("X: " + selectedBtn.getX());
        System.out.println("Y: " + selectedBtn.getY());

        JButton blankButton = getBlankButton(knappar);
        isMoveLegal(selectedBtn, blankButton);          //TODO: Ska bakas in i annan metod.

    }

    // Metod för att kontrollera huruvida en "move" är tillåten genom att räkna på om givna koordinater
    //  +/- 200 matchar:
    // 1. är x samma som blankBtn?
    //        - om ja:
    //            - är y +/- 200 = blankBtn?
    public boolean isMoveLegal(JButton selectedButton, JButton blankButton) {
        if (selectedButton.getX() == blankButton.getX()) {
            if (selectedButton.getY() - 200 == blankButton.getY() ||            //TODO: Kan rad 49 & 50 skrivas ihop?
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
            } else {
                System.out.println("False");
                return false;
            }
        }
        System.out.println("False");
        return false;
    }

    public JButton getBlankButton(Component[] knappar) {
        for (Component button : knappar) {
            JButton currentButton = (JButton) button;
            if (currentButton.getText().isBlank()) {
                System.out.println("BLANK BUTTON:");
                System.out.println("X: " + button.getX());
                System.out.println("Y: " + button.getY());
                return currentButton;
            }
        }
        throw new NoSuchElementException();
    }
}


















/*
        for (int row = 0; row < buttonGrid.length; row++) {
            for (int col = 0; col < buttonGrid.length; col++) {
                if (buttonGrid[row][col] == selectedBtn) {
                    System.out.println(selectedBtn.getText() + " KNAPPENS NR");
                    System.out.println(row + ", " + col + " KNAPPENS POS");
                    List<Integer> blank = getCurrentEmptyButtonPosition(buttonGrid);
                    System.out.println(blank + ", BLANK POS");
                    JButton blankBtn = buttonGrid[blank.get(0)][blank.get(1)];
                    isMoveLegal(blankBtn, buttonGrid, row, col);
                        // Tillåt move
                }
            }
        }
    }

 */
/*
    public List<Integer> getCurrentEmptyButtonPosition(JButton[][] buttonGrid) {

//        int SelectedPanelPosition;
        for (int row = 0; row < buttonGrid.length; row++) {
            for (int col = 0; col < buttonGrid.length; col++) {
                if(buttonGrid[row][col].getText().isBlank()){
                    return new ArrayList<>(List.of(row, col));
                }
            }
        }
        throw new NoSuchElementException(); // Finns ej
    }

    public boolean isMoveLegal(JButton blankBtn, JButton[][] buttonGrid, int currentRow, int currentCol){
        if (buttonGrid[currentRow][currentCol-1] == blankBtn || buttonGrid[currentRow][currentCol+1] == blankBtn ||
                buttonGrid[currentRow+1][currentCol] == blankBtn ||
                buttonGrid[currentRow-1][currentCol] == blankBtn){
            System.out.println("True");
            return true;
        }
        else{
            System.out.println("False");
            return false;
        }


            /*bool adjacentIsBlank(int selectedGrid, int currentBlankGrid){

if (selectedGrid[row][collumn-1] == currentBlankGrid || selectedGrid [row-1][collumn] etc...){
return true;
}

 */
