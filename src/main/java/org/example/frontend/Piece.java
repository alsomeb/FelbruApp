package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class Piece extends JPanel {

    private int number;
    private final JLabel label1 = new JLabel("1");


    public Piece(){

//        this.setPreferredSize(new Dimension(20,20));
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black,2));
        this.add(label1);
    }


}
