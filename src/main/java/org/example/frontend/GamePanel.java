package org.example.frontend;

import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private final int ROWS = 4;
    private final int COLS = 4;
    private final int GAP = 2;
    private JButton[][] buttonGrid;



    List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();
    private int[][] grid = new int[4][4];

    public GamePanel() {
        // Gamepanel
        this.setLayout(new GridLayout(ROWS, COLS, GAP, GAP));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Color.BLACK);
        buttonGrid = new JButton[ROWS][COLS];
        buttonGrid = createInitialButtonGrid();


        // Game Panel
        //this.setLayout(new GridLayout(4, 4));

        //TODO: ev. obsolet.
//        ActionListener buttonListener = e -> {
//            JButton selectedBtn = (JButton) e.getSource();
//            for (int row = 0; row < buttonGrid.length; row++) {
//                for (int col = 0; col < buttonGrid[row].length; col++) {
//                    if (buttonGrid[row][col] == selectedBtn) {
//                        System.out.printf("Selected row and column: %d %d%n", row, col);
//                    }
//                }
//            }
//        };

    }




    private JButton[][] createInitialButtonGrid(){
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                //grid[i][j] = shuffledList.get(counter); // Matris av spelplan kommer se ut
                buttonGrid[i][j] = new JButton(String.valueOf(shuffledList.get(counter)));
                buttonGrid[i][j].addActionListener(new ButtonActionListener(buttonGrid[i][j], buttonGrid));
                this.add(buttonGrid[i][j]);
                if(buttonGrid[i][j].getText().equals("0")) {
                    buttonGrid[i][j].setText("");
                    buttonGrid[i][j].setEnabled(false);
                }
                counter++;
            }
        }
        return buttonGrid;
    }


    public JButton[][] getButtonGrid() {
        return buttonGrid;
    }

    public void setButtonGrid(JButton[][] buttonGrid) {
        this.buttonGrid = buttonGrid;
    }
}
