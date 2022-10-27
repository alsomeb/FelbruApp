package org.example.frontend;

import org.example.backend.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PiecePanel extends JPanel {

    private final Piece piece;
    private JLabel pieceLabel;

    public PiecePanel(Piece piece){
        this.piece = piece;
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black,2));
        setPieceLabel();
        this.add(pieceLabel);
        printMe();

    }

    public void setPieceLabel() {
        if (piece.getNumber() == 0) {
            pieceLabel = new JLabel();
        } else {
            pieceLabel = new JLabel(String.valueOf(piece.getNumber()));
        }
    }

    public void printMe() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(piece);
            }
        });
    }
}
