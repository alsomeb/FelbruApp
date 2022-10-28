package org.example.frontend;

import org.example.backend.Piece;
import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GamePanel extends JPanel {
    private JPanel piecePanel = new JPanel();


    List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();
    private int[][] grid = new int[4][4];

    public GamePanel() {
        // Piece Panel
        piecePanel.setLayout(new GridBagLayout());
        piecePanel.setBorder(BorderFactory.createLineBorder(Color.black,2));

        // Game Panel
        this.setLayout(new GridLayout(4, 4));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Color.BLACK);
        loadPieces();

    }


    private void loadPieces(){

        shuffledList.forEach(index -> this.add(new PiecePanel(new Piece(index))));
        System.out.println(shuffledList);

        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j] = shuffledList.get(counter);
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
