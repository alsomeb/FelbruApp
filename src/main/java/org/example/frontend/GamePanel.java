package org.example.frontend;

import org.example.backend.Piece;
import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GamePanel extends JPanel {

    private int[][] grid = new int[4][4];

    public GamePanel() {
        // Game Panel
        this.setLayout(new GridLayout(4, 4));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Color.BLACK);
        loadPieces();

    }


    private void loadPieces(){
        List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();

        shuffledList.forEach(index -> this.add(new PiecePanel(new Piece(index))));
        System.out.println(shuffledList);

        int counter = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                counter++;
                grid[i][j] = shuffledList.get(counter);
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
