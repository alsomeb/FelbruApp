package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ButtonActionListener implements ActionListener {

    private JButton button;

    private JButton[][] buttonGrid;

    public ButtonActionListener(JButton button, JButton[][] buttonGrid) {
        this.button = button;
        this.buttonGrid = buttonGrid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectedBtn = (JButton) e.getSource(); // Den knappen man klickat på

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
