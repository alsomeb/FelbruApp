package org.example.frontend;

import org.example.backend.Piece;
import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

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

/*        List<Piece> pieceList = new ArrayList<>(List.of(
                new Piece(),
                new Piece(2),
                new Piece(3),
                new Piece(4),
                new Piece(5),
                new Piece(6),
                new Piece(7),
                new Piece(8),
                new Piece(9),
                new Piece(10),
                new Piece(11),*//**//*
                new Piece(12),
                new Piece(13),
                new Piece(14),
                new Piece(15),
                new Piece()
        ));*/
    }



}
