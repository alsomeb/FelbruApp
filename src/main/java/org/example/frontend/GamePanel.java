package org.example.frontend;

import org.example.backend.Piece;
import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GamePanel extends JPanel {
    private final int ROWS = 4;
    private final int COLS = 4;
    private final int GAP = 2;
    private JButton[][] buttonGrid = new JButton[ROWS][COLS];



    List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();
    private int[][] grid = new int[4][4];

    public GamePanel() {
        // Gamepanel
        this.setLayout(new GridLayout(ROWS, COLS, GAP, GAP));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Color.BLACK);
        loadPieces();

        // Game Panel
        //this.setLayout(new GridLayout(4, 4));

    }


    private void loadPieces(){

        //shuffledList.forEach(index -> this.add(new PiecePanel(new Piece(index))));
        //System.out.println(shuffledList);

        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j] = shuffledList.get(counter); // Matris av spelplan kommer se ut
//                this.add(buttonGrid[i][j]);
                counter++;
            }
        }
        System.out.println(Arrays.deepToString(grid));
    }


    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
