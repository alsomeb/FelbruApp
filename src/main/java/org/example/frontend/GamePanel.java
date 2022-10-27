package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {



    public GamePanel() {

        this.setLayout(new GridLayout(4, 4));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.setBackground(Color.BLACK);


        loadPieces();



    }

    private void loadPieces(){
        for (int i = 0; i<=19; i++){
            this.add(new Piece());
        }
    }

}
